package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.InitDttHandler;
import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.framework.core.reflect.ReflectionUtil.methodToProperty;
import static com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline;

/**
 * 解析注释、模型描述
 *
 * @param <T> 解析类型
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface CommentParser<T> extends DttContext<T> {
    /**
     * get method prefix
     */
    String GET = "get";

    /**
     * 根绝java枚举类型解析数据库枚举类型
     *
     * @param field javaField
     * @return DatabaseDataEnumType
     */
    default EnumTypeWrapper parseDatabaseEnumTypes(Field field, String databaseDataType) {
        EnumTypeWrapper wrapper = new EnumTypeWrapper();
        StringBuilder enumStr = new StringBuilder();
        Enum<?>[] enumValues = ClassUtil.invoke(field.getType().getName(), "values", new Object[0]);
        for (Enum<?> enumValue : enumValues) {
            enumStr.append("'").append(enumValue.name()).append("',");
        }
        String enumString = enumStr.substring(0, enumStr.length() - 1);
        String finalDatabaseDataType = databaseDataType + "(" + enumString + ")";
        //如果确实的情况下，使用第一个作为枚举类型的默认值
        wrapper.setInitValue(enumValues[0].name());
        wrapper.setDbDtaType(finalDatabaseDataType);
        return wrapper;
    }

    /**
     * 暂且处理varchar类型的长度
     *
     * @return varchar类型
     */
    default String resolveVarcharTypeLength(String underlineFiledName, String databaseDataType) {
        if ("varchar".equals(databaseDataType)) {
            if (underlineFiledName.contains("phone") || underlineFiledName.contains("tel") || underlineFiledName.contains("telephone") || underlineFiledName.contains("mail"))
                return databaseDataType + "(16)";
            if (underlineFiledName.contains("id") || underlineFiledName.contains("no") || underlineFiledName.contains("number") || underlineFiledName.contains("name") || underlineFiledName.contains("code"))
                return databaseDataType + "(64)";
            if (underlineFiledName.contains("url") || underlineFiledName.contains("link"))
                return databaseDataType + "(128)";
            if (underlineFiledName.contains("body") || underlineFiledName.contains("msg") || underlineFiledName.contains("message") || underlineFiledName.contains("content") || underlineFiledName.contains("text"))
                return databaseDataType + "(768)";
            else return databaseDataType + "(256)";
        }
        // 非varchar类型直接返回
        return databaseDataType;
    }

    /**
     * 解析全限定类名到数据表结构模型
     *
     * @param fullyQualifiedClassName fully qualified class name of model
     * @return 数据表结构模型
     */
    @Override
    ParsedModel<T> parse(String fullyQualifiedClassName);

    /**
     * 处理没有不加注释、不加注解的
     *
     * @param aClass class对象
     * @return 域模型信息集合
     */
    default List<ModelEntity.Detail> handleTableWithoutComment(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields()).filter(field -> !Objects.equals(Constants.SERIAL_VERSION_UID, field.getName())).map(field -> {

            String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();
            String originalDbDataType = SpringUtil.getBean(InitDttHandler.class).getDatabaseDataType(javaDataType);
            String realDbDataType = this.parseDbDataType(field, originalDbDataType);

            Object invoke = null;
            for (Method method : getPublicGetterMethods(aClass)) {
                if (Objects.equals(methodToProperty(method.getName()), field.getName())) {
                    invoke = ClassUtil.invoke(aClass.getName(), method.getName(), new Object[0]);
                    break;
                }
            }

            ModelEntity.Detail detail = new ModelEntity.Detail();
            detail.setIsPrimaryKey(PRIMARY_KEY.equals(camelToUnderline(field.getName())));
            detail.setDatabaseDataType(realDbDataType);
            detail.setJavaDataType(javaDataType);
            detail.setFiledName(camelToUnderline(field.getName()));
            detail.setInitialValue(null != invoke ? String.valueOf(invoke) : "NULL");
            detail.setFiledComment("");

            return detail;
        }).collect(Collectors.toList());
    }

    /**
     * 获取所有公共GETTER方法
     *
     * @param aClass class 对象
     * @return all public getter methods
     */
    default List<Method> getPublicGetterMethods(Class<?> aClass) {
        return ClassUtil.getPublicMethods(aClass, method -> method.getName().startsWith(GET));
    }

    /**
     * 解析数据库数据类型
     *
     * @param field              单个字段的信息
     * @param originalDbDataType 从yaml配置文件中读取的原始数据库数据类型
     * @return 解析后的实际数据库数据类型
     */
    default String parseDbDataType(Field field, String originalDbDataType) {
        if (field.getType().isEnum())
            return parseDatabaseEnumTypes(field, originalDbDataType).getDbDtaType();
        else return resolveVarcharTypeLength(camelToUnderline(field.getName()), originalDbDataType);
    }


    /**
     * Enum Type Wrapper
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class EnumTypeWrapper {
        private String initValue;
        private String dbDtaType;
    }
}
