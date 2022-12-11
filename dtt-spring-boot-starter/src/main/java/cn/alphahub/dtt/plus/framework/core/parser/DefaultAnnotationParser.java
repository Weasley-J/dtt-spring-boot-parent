package cn.alphahub.dtt.plus.framework.core.parser;

import cn.alphahub.dtt.plus.annotations.Dtt;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.util.ClassUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.GET;
import static cn.alphahub.dtt.plus.constant.Constants.NULL_STRING;
import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.util.ClassUtil.getAllDeclaredFields;
import static cn.alphahub.dtt.plus.util.ClassUtil.getAllPublicGetterMethods;
import static com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline;

/**
 * 解析{@link  Dtt}注解的注释
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultAnnotationParser implements DttCommentParser<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultAnnotationParser.class);
    @Autowired
    private DatabaseHandler databaseHandler;
    @Autowired
    private DatabaseProperty databaseProperty;

    @Override
    public ParseFactory<ModelEntity> parse(String fullyQualifiedClassName) {
        logger.info("Use the annotation '@Dtt' to parse the data table structure information，class '{}'", fullyQualifiedClassName);
        Class<?> aClass = ClassUtil.loadClass(fullyQualifiedClassName);
        return () -> {
            Dtt dtt = aClass.getAnnotation(Dtt.class);
            ModelEntity model = new ModelEntity();
            if (dtt == null) {
                model.setDatabaseName(databaseProperty.getDatabaseName());
                model.setModelName(camelToUnderline(aClass.getSimpleName()));
                model.setModelComment("");
                model.setDetails(handleTableWithoutComment(aClass));
                return model;
            }
            model.setDatabaseName(databaseProperty.getDatabaseName());
            model.setModelComment(dtt.value());
            model.setModelName(camelToUnderline(aClass.getSimpleName()));
            model.setDetails(handleTableWithDttAnnotation(aClass));
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
        List<Field> allDeclaredFields = getAllDeclaredFields(aClass);
        return allDeclaredFields.stream().map(field -> {
            String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();
            String originalDbDataType = databaseHandler.getDbDataType(javaDataType);
            Dtt dtt = field.getAnnotation(Dtt.class);
            ModelEntity.Detail detail = new ModelEntity.Detail();
            if (ObjectUtils.isNotEmpty(dtt)) {
                String initialValue;
                if (StringUtils.equals(Enum.class.getSimpleName(), javaDataType) && StringUtils.isBlank(dtt.defaultValue()))
                    initialValue = parseDatabaseEnumTypes(field, originalDbDataType).getInitValue();
                else initialValue = StringUtils.defaultIfBlank(dtt.defaultValue(), NULL_STRING);

                if (PRIMARY_KEY.equals(field.getName()) && Boolean.FALSE.equals(dtt.primaryKey()))
                    detail.setIsPrimaryKey(true);
                else detail.setIsPrimaryKey(dtt.primaryKey());

                detail.setJavaDataType(javaDataType);
                detail.setFiledName(camelToUnderline(field.getName()));
                detail.setInitialValue(initialValue);
                detail.setFiledComment(dtt.value());

                if (dtt.length() > 0 && Objects.equals(String.class.getSimpleName(), javaDataType))
                    detail.setDatabaseDataType(originalDbDataType + "(" + dtt.length() + ")");
                else if ((dtt.precision() > 0 && dtt.scale() >= 0) && Objects.equals(BigDecimal.class.getSimpleName(), javaDataType))
                    detail.setDatabaseDataType(originalDbDataType + "(" + dtt.precision() + "," + dtt.scale() + ")");
                else
                    detail.setDatabaseDataType(StringUtils.defaultIfBlank(dtt.dbDataType(), parseDbDataType(field, originalDbDataType)));

            } else {
                logger.warn("模型'{}'里面的字段'{}'未添加 '@Dtt' 注解, 将不会解析模型描述信息.", aClass.getSimpleName(), field.getName());
                String realDbDataType = parseDbDataType(field, originalDbDataType);
                Object invoke = null;
                for (Method method : getAllPublicGetterMethods(aClass)) {
                    String fieldProps = com.baomidou.mybatisplus.core.toolkit.StringUtils.firstToLowerCase(method.getName().substring(GET.length()));
                    if (Objects.equals(fieldProps, field.getName())) {
                        invoke = ClassUtil.invoke(method, aClass);
                        break;
                    }
                }
                detail.setIsPrimaryKey(PRIMARY_KEY.equals(camelToUnderline(field.getName())));
                detail.setDatabaseDataType(realDbDataType);
                detail.setJavaDataType(javaDataType);
                detail.setFiledName(camelToUnderline(field.getName()));
                detail.setInitialValue(StringUtils.defaultIfBlank(String.valueOf(invoke), NULL_STRING));
                detail.setFiledComment("");
            }
            return detail;
        }).collect(Collectors.toList());
    }

}
