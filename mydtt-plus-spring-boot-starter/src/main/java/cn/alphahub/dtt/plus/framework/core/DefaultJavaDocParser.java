package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.InitDttHandler;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.exception.ParseException;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.SysUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.therapi.runtimejavadoc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.framework.core.reflect.ReflectionUtil.methodToProperty;

/**
 * 解析Java doc注释
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultJavaDocParser implements CommentParser<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultJavaDocParser.class);
    /**
     * formatters are reusable and thread-safe
     */
    private static final CommentFormatter formatter = new CommentFormatter();

    private static void printMethodJavadoc(MethodJavadoc methodDoc) {
        System.out.println(methodDoc.getName() + methodDoc.getParamTypes());
        System.out.println(format(methodDoc.getComment()));

        if (!methodDoc.isConstructor()) {
            logger.info("  returns: {}", format(methodDoc.getReturns()));

        }

        for (SeeAlsoJavadoc see : methodDoc.getSeeAlso()) {
            if (logger.isInfoEnabled()) {
                logger.info("  See also: {}", see.getLink());
            }
        }

        for (OtherJavadoc other : methodDoc.getOther()) {
            if (logger.isInfoEnabled()) {
                logger.info("  {}: {}", other.getName(), format(other.getComment()));
            }
        }

        for (ParamJavadoc paramDoc : methodDoc.getParams()) {
            if (logger.isInfoEnabled()) {
                logger.info("  param {} {}", paramDoc.getName(), format(paramDoc.getComment()));
            }
        }

        for (ThrowsJavadoc throwsDoc : methodDoc.getThrows()) {
            if (logger.isInfoEnabled()) {
                logger.info("  throws {} {}", throwsDoc.getName(), format(throwsDoc.getComment()));
            }
        }

        if (logger.isInfoEnabled()) {
            logger.info("{}", SysUtil.getLineSeparator());
        }
    }

    private static String format(Comment c) {
        return formatter.format(c);
    }

    @Override
    public ParsedModel<ModelEntity> parse(String fullyQualifiedClassName) {
        logger.info("Parse Java Doc comments for data table structure information，class '{}'", fullyQualifiedClassName);
        return () -> {
            ClassJavadoc classDoc = RuntimeJavadoc.getJavadoc(fullyQualifiedClassName);
            if (classDoc.isEmpty()) {
                // optionally skip absent documentation
                if (logger.isWarnEnabled()) {
                    logger.warn("no documentation for '{}'", fullyQualifiedClassName);
                }
                return null;
            }

            Class<?> clazz = ClassUtil.loadClass(fullyQualifiedClassName);

            if (clazz.isEnum()) {
                throw new ParseException("枚举类 '" + clazz.getName() + "' 不支持反射解析");
            }

            // @see tags
            for (SeeAlsoJavadoc see : classDoc.getSeeAlso()) {
                if (logger.isInfoEnabled()) {
                    logger.info("See also: {}", see.getLink());
                }
            }
            // miscellaneous and custom javadoc tags (@author, etc.)
            for (OtherJavadoc other : classDoc.getOther()) {
                if (logger.isInfoEnabled()) {
                    logger.info("{}: {}", other.getName(), format(other.getComment()));
                }
            }

            // CONSTRUCTORS
            for (MethodJavadoc methodDoc : classDoc.getConstructors()) {
                printMethodJavadoc(methodDoc);
            }

            List<Method> publicMethods = ClassUtil.getPublicMethods(clazz, method -> method.getName().startsWith(GET));

            // METHODS
            List<ModelEntity.Detail> details = classDoc.getMethods().stream()
                    .filter(methodJavadoc -> {
                                String camelFiledName = StringUtils.firstToLowerCase(methodJavadoc.getName().substring(GET.length()));
                                Field field = ClassUtil.getDeclaredField(clazz, camelFiledName);
                                return methodJavadoc.getName().startsWith(GET)
                                        && !field.getType().isInterface()
                                        && !field.getType().isArray();
                            }
                    )
                    .map(methodJavadoc -> {

                        String underlineFiledName = StringUtils.camelToUnderline(methodJavadoc.getName().substring(GET.length()));
                        String camelFiledName = StringUtils.firstToLowerCase(methodJavadoc.getName().substring(GET.length()));
                        Field field = ClassUtil.getDeclaredField(clazz, camelFiledName);
                        String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();

                        Object invoke = null;
                        for (Method method : publicMethods) {
                            if (Objects.equals(methodToProperty(method.getName()), field.getName())) {
                                invoke = ClassUtil.invoke(fullyQualifiedClassName, method.getName(), new Object[0]);
                                break;
                            }
                        }

                        String originalDbDataType = SpringUtil.getBean(InitDttHandler.class).getDatabaseDataType(javaDataType);
                        String realDbDataType = parseDbDataType(field, originalDbDataType);

                        return new ModelEntity.Detail().setIsPrimaryKey(PRIMARY_KEY.equals(underlineFiledName))
                                .setJavaDataType(javaDataType)
                                .setDatabaseDataType(realDbDataType)
                                .setFiledName(underlineFiledName)
                                .setFiledComment(getFiledComment(methodJavadoc))
                                .setInitialValue(null != invoke ? String.valueOf(invoke) : "NULL");

                    }).collect(Collectors.toList());


            //处理不加java注释的模型, 所有字段将缺失表描述信息
            if (CollectionUtils.isEmpty(details)) {
                details = handleTableWithoutComment(clazz);
            }

            return new ModelEntity()
                    .setModelName(StringUtils.camelToUnderline(ClassUtil.getClassName(clazz, true)))
                    .setModelComment(format(classDoc.getComment()))
                    .setDetails(details);

        };
    }

    /**
     * @return filed comment
     */
    private String getFiledComment(MethodJavadoc methodJavadoc) {
        String filedComment = format(methodJavadoc.getComment());
        if (StringUtils.isNotBlank(filedComment)) {
            if (filedComment.startsWith("'")) {
                filedComment = filedComment.substring(1);
            }
            if (filedComment.endsWith("'")) {
                filedComment = filedComment.substring(0, filedComment.length() - 1);
            }
        }
        return filedComment;
    }
}
