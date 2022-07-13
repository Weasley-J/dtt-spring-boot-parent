package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.annotations.Dtt;
import cn.alphahub.dtt.plus.config.InitDttHandler;
import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.framework.core.reflect.ReflectionUtil.methodToProperty;
import static com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline;

/**
 * 解析{{@code Dtt}}注解的注释
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultAnnotationParser implements CommentParser<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultAnnotationParser.class);

    @Override
    public ParsedModel<ModelEntity> parse(String fullyQualifiedClassName) {
        logger.info("Use the annotation '@Dtt' to parse the data table structure information，class '{}'", fullyQualifiedClassName);
        return () -> {
            Class<Object> aClass = ClassUtil.loadClass(fullyQualifiedClassName);
            Dtt dtt = aClass.getAnnotation(Dtt.class);
            ModelEntity model = new ModelEntity();
            model.setModelComment(dtt != null ? dtt.value() : "");
            model.setModelName(camelToUnderline(aClass.getSimpleName()));
            model.setDetails(null != dtt ? handleTableWithDttAnnotation(aClass) : handleTableWithoutComment(aClass));
            return model;
        };
    }

    /**
     * 根据 '@Dtt' 注解解析表结构模型
     *
     * @param aClass class object
     * @return 模型元数据详细信息集合
     */
    private List<ModelEntity.Detail> handleTableWithDttAnnotation(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields()).filter(field -> !Objects.equals(Constants.SERIAL_VERSION_UID, field.getName())).map(field -> {
            String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();
            String originalDbDataType = SpringUtil.getBean(InitDttHandler.class).getDatabaseDataType(javaDataType);
            Dtt[] dttAnnotations = field.getAnnotationsByType(Dtt.class);
            ModelEntity.Detail detail = new ModelEntity.Detail();
            if (ObjectUtils.isNotEmpty(dttAnnotations)) {
                Dtt dtt = dttAnnotations[0];

                String initialValue;
                if (StringUtils.equals(Enum.class.getSimpleName(), javaDataType) && StringUtils.isBlank(dtt.defaultValue()))
                    initialValue = parseDatabaseEnumTypes(field, originalDbDataType).getInitValue();
                else initialValue = StringUtils.defaultIfBlank(dtt.defaultValue(), "NULL");

                if (PRIMARY_KEY.equals(field.getName()) && Boolean.FALSE.equals(dtt.isPrimaryKey()))
                    detail.setIsPrimaryKey(true);
                else detail.setIsPrimaryKey(dtt.isPrimaryKey());

                detail.setDatabaseDataType(StringUtils.defaultIfBlank(dtt.dbDataType(), parseDbDataType(field, originalDbDataType)));
                detail.setJavaDataType(javaDataType);
                detail.setFiledName(camelToUnderline(field.getName()));
                detail.setInitialValue(initialValue);
                detail.setFiledComment(dtt.value());
            } else {
                logger.warn("模型'{}'里面的字段'{}'未添加 '@Dtt' 注解, 将不会解析模型描述信息.", aClass.getSimpleName(), field.getName());
                String realDbDataType = parseDbDataType(field, originalDbDataType);
                Object invoke = null;
                for (Method method : getPublicGetterMethods(aClass)) {
                    if (Objects.equals(methodToProperty(method.getName()), field.getName())) {
                        invoke = ClassUtil.invoke(aClass.getName(), method.getName(), new Object[0]);
                        break;
                    }
                }
                detail.setIsPrimaryKey(PRIMARY_KEY.equals(camelToUnderline(field.getName())));
                detail.setDatabaseDataType(realDbDataType);
                detail.setJavaDataType(javaDataType);
                detail.setFiledName(camelToUnderline(field.getName()));
                detail.setInitialValue(StringUtils.defaultIfBlank(String.valueOf(invoke), "NULL"));
                detail.setFiledComment("");
            }
            return detail;
        }).collect(Collectors.toList());
    }

}
