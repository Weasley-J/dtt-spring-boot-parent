package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.exception.ParseException;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.ClassUtil;
import cn.alphahub.dtt.plus.util.StringUtils;
import cn.alphahub.dtt.plus.util.SystemUtil;
import com.github.therapi.runtimejavadoc.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static cn.alphahub.dtt.plus.constant.Constants.*;
import static cn.alphahub.dtt.plus.util.ClassUtil.getAllPublicGetterMethods;

/**
 * 解析Java doc注释
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultJavadocParser implements DttCommentParser<ModelEntity> {
    protected static final Logger logger = LoggerFactory.getLogger(DefaultJavadocParser.class);
    /**
     * formatters are reusable and thread-safe
     */
    private static final CommentFormatter formatter = new CommentFormatter();
    @Autowired
    private DatabaseHandler databaseHandler;
    @Autowired
    private DatabaseProperty databaseProperty;

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
            logger.info("{}", SystemUtil.getLineSeparator());
        }
    }

    private static String format(Comment c) {
        return formatter.format(c);
    }

    @Override
    public ParseFactory<ModelEntity> parse(String fullyQualifiedClassName) {
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

            List<Method> publicMethods = getAllPublicGetterMethods(clazz);

            // Methods
            List<ModelEntity.Detail> details = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(publicMethods)) {
                for (Method method : publicMethods) {
                    String fieldName = StringUtils.firstToLowerCase(method.getName().substring(Constants.GET.length()));
                    String fieldNameToUnderline = StringUtils.camelToUnderline(fieldName);
                    Field field = ClassUtil.getDeclaredField(clazz, fieldName);
                    String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();

                    // 过滤掉不符合命名规范的列
                    if (field.getType().isInterface() || field.getType().isArray()) {
                        logger.warn("Java数据模型'{}'的私有成员变量'{}'属性是'{}'类型不符合规范，创建表结构中不会包含对应的列.", fullyQualifiedClassName, fieldName, field.getType().getName());
                        continue;
                    }

                    Object invokeValue = null;
                    if (Objects.equals(fieldName, field.getName())) {
                        invokeValue = ClassUtil.invoke(method, clazz);
                    }

                    String originalDbDataType = databaseHandler.getDbDataType(javaDataType);
                    String realDbDataType = parseDbDataType(field, originalDbDataType);

                    FieldJavadoc fieldJavadoc = null;
                    for (FieldJavadoc javadoc : classDoc.getFields()) {
                        if (fieldName.equals(javadoc.getName())) {
                            fieldJavadoc = javadoc;
                            break;
                        }
                    }

                    ModelEntity.Detail detail = new ModelEntity.Detail();
                    if (Objects.equals(PRIMARY_KEY.equals(fieldNameToUnderline), false))
                        this.handleJavadocTagOfPrimaryKey(new FrameworkDefinedJavaTagWrapper(fieldName, fieldJavadoc, detail, originalDbDataType));
                    else
                        detail.setIsPrimaryKey(true);
                    detail.setJavaDataType(javaDataType);
                    detail.setDatabaseDataType(realDbDataType);
                    detail.setFiledName(fieldNameToUnderline);
                    detail.setFiledComment(getFiledComment(fieldJavadoc));
                    detail.setInitialValue(null != invokeValue ? String.valueOf(invokeValue) : NULL_STRING);

                    this.handleFrameworkDefinedJavadocIfExists(new FrameworkDefinedJavaTagWrapper(fieldName, fieldJavadoc, detail, originalDbDataType));
                    this.handleJavadocTagOfDefaultValue(new FrameworkDefinedJavaTagWrapper(fieldName, fieldJavadoc, detail, originalDbDataType));
                    this.handleJavadocTagOfDbDataType(new FrameworkDefinedJavaTagWrapper(fieldName, fieldJavadoc, detail, originalDbDataType));

                    details.add(detail);
                }
            }

            //处理不加java注释的模型, 所有字段将缺失表描述信息
            if (CollectionUtils.isEmpty(details)) {
                details = handleTableWithoutComment(clazz);
            }

            return new ModelEntity()
                    .setDatabaseName(databaseProperty.getDatabaseName())
                    .setModelName(StringUtils.camelToUnderline(clazz.getSimpleName()))
                    .setModelComment(format(classDoc.getComment()))
                    .setDetails(details);

        };
    }

    /**
     * Get Filed Comment
     *
     * @param fieldJavadoc field java doc
     * @return filed comment
     */
    private String getFiledComment(FieldJavadoc fieldJavadoc) {
        if (null == fieldJavadoc) {
            return "";
        }
        String filedComment = format(fieldJavadoc.getComment());
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

    /**
     * Handle framework-defined Javadoc tags
     *
     * @param wrapper framework-defined Javadoc tags
     * @see Constants#CUSTOM_TAG_LENGTH
     * @see Constants#CUSTOM_TAG_PRECISION
     * @see Constants#CUSTOM_TAG_SCALE
     */
    public void handleFrameworkDefinedJavadocIfExists(FrameworkDefinedJavaTagWrapper wrapper) {
        if (wrapper.getFieldJavadoc() == null || CollectionUtils.isEmpty(wrapper.getFieldJavadoc().getOther())) return;
        ModelEntity.Detail detail = wrapper.getDetail();
        if (org.apache.commons.lang3.StringUtils.equalsIgnoreCase(String.class.getSimpleName(), detail.getJavaDataType())) {
            for (OtherJavadoc javadoc : wrapper.getFieldJavadoc().getOther()) {
                String fieldName = wrapper.getFieldJavadoc().getName();
                if (fieldName.equals(wrapper.getFieldName()) && CUSTOM_TAG_LENGTH.equals(javadoc.getName())) {
                    detail.setDatabaseDataType(wrapper.getOriginalDbDataType() + "(" + javadoc.getComment() + ")");
                    break;
                }
            }
        }
        if (org.apache.commons.lang3.StringUtils.equalsIgnoreCase(BigDecimal.class.getSimpleName(), detail.getJavaDataType())) {
            int _precision = 10;
            int _scale = 0;
            for (OtherJavadoc javadoc : wrapper.getFieldJavadoc().getOther()) {
                if (CUSTOM_TAG_PRECISION.equals(javadoc.getName())) {
                    _precision = Integer.parseInt(String.valueOf(javadoc.getComment()));
                }
                if (CUSTOM_TAG_SCALE.equals(javadoc.getName())) {
                    _scale = Integer.parseInt(String.valueOf(javadoc.getComment()));
                }
            }
            detail.setDatabaseDataType(wrapper.getOriginalDbDataType() + "(" + _precision + "," + _scale + ")");
        }
    }

    /**
     * To handle javadoc wrapper of default value
     *
     * @param wrapper the wrapper of framework defined javadoc tag
     * @see Constants#CUSTOM_TAG_DEFAULT_VALUE
     */
    public void handleJavadocTagOfDefaultValue(FrameworkDefinedJavaTagWrapper wrapper) {
        if (wrapper.getFieldJavadoc() == null || CollectionUtils.isEmpty(wrapper.getFieldJavadoc().getOther())) return;
        for (OtherJavadoc javadoc : wrapper.getFieldJavadoc().getOther()) {
            String fieldName = wrapper.getFieldJavadoc().getName();
            if (CUSTOM_TAG_DEFAULT_VALUE.equals(javadoc.getName()) && fieldName.equals(wrapper.getFieldName())) {
                wrapper.getDetail().setInitialValue(String.valueOf(javadoc.getComment()));
                break;
            }
        }
    }

    /**
     * To handle javadoc wrapper of primary key
     *
     * @param wrapper the wrapper of framework defined javadoc tag
     * @see Constants#CUSTOM_TAG_IS_PRIMARY_KEY
     */
    public void handleJavadocTagOfPrimaryKey(FrameworkDefinedJavaTagWrapper wrapper) {
        if (wrapper.getFieldJavadoc() == null || CollectionUtils.isEmpty(wrapper.getFieldJavadoc().getOther())) return;
        ModelEntity.Detail detail = wrapper.getDetail();
        for (OtherJavadoc javadoc : wrapper.getFieldJavadoc().getOther()) {
            String fieldName = wrapper.getFieldJavadoc().getName();
            if (fieldName.equals(wrapper.getFieldName()) && CUSTOM_TAG_IS_PRIMARY_KEY.equals(javadoc.getName())) {
                detail.setIsPrimaryKey(true);
                break;
            }
        }
    }

    /**
     * To handle javadoc wrapper of db data type
     *
     * @param wrapper the wrapper of framework defined javadoc tag
     * @see Constants#CUSTOM_TAG_DB_DATA_TYPE
     */
    public void handleJavadocTagOfDbDataType(FrameworkDefinedJavaTagWrapper wrapper) {
        if (wrapper.getFieldJavadoc() == null || CollectionUtils.isEmpty(wrapper.getFieldJavadoc().getOther())) return;
        ModelEntity.Detail detail = wrapper.getDetail();
        for (OtherJavadoc javadoc : wrapper.getFieldJavadoc().getOther()) {
            String fieldName = wrapper.getFieldJavadoc().getName();
            if (fieldName.equals(wrapper.getFieldName()) && CUSTOM_TAG_DB_DATA_TYPE.equals(javadoc.getName())) {
                detail.setDatabaseDataType(String.valueOf(javadoc.getComment()));
                break;
            }
        }
    }

    /**
     * Framework Defined Javadoc Tag Wrapper
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class FrameworkDefinedJavaTagWrapper implements Serializable {
        /**
         * The name for filed
         */
        private String fieldName;
        /**
         * The field javadoc
         */
        private FieldJavadoc fieldJavadoc;
        /**
         * The Meta-data from table
         */
        private ModelEntity.Detail detail;
        /**
         * original db data type, i.e: VARCHAR
         */
        private String originalDbDataType;
    }
}
