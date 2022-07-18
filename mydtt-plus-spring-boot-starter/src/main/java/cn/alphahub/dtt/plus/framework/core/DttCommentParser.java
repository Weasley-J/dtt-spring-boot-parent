package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.ClassUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.util.ClassUtil.getEnumTypeStringValues;
import static cn.alphahub.dtt.plus.util.ClassUtil.getPublicGetterMethods;
import static com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline;

/**
 * 解析模型注释、模型描述
 *
 * @param <T> 解析类型
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface DttCommentParser<T> extends DttContext<T> {
    Logger logger = LoggerFactory.getLogger(DttCommentParser.class);

    /**
     * 根绝java枚举类型解析数据库枚举类型
     *
     * @param field      javaField
     * @param dbDataType database data type
     * @return DatabaseDataEnumType
     */
    default EnumTypeWrapper parseDatabaseEnumTypes(Field field, String dbDataType) {
        EnumTypeWrapper wrapper = new EnumTypeWrapper();
        StringBuilder enumStr = new StringBuilder();
        String[] enumTypeStringValues = getEnumTypeStringValues(field);
        for (String enumType : enumTypeStringValues) {
            enumStr.append("'").append(enumType).append("',");
        }
        String enumString = enumStr.substring(0, enumStr.length() - 1);
        String finalDatabaseDataType = dbDataType + "(" + enumString + ")";
        //If missing, use the first as the default value of the enumeration type
        wrapper.setInitValue(enumTypeStringValues[0]);
        wrapper.setDbDtaType(finalDatabaseDataType);
        return wrapper;
    }

    /**
     * 暂且处理varchar类型的长度
     *
     * @param dbDataType         database data type
     * @param underlineFiledName underline filed name
     * @return varchar类型
     */
    default String resolveVarcharLength(String underlineFiledName, String dbDataType) {
        if ("varchar".equals(dbDataType)) {
            if (underlineFiledName.contains("phone") || underlineFiledName.contains("tel") || underlineFiledName.contains("telephone") || underlineFiledName.contains("mail"))
                return dbDataType + "(16)";
            if (underlineFiledName.contains("id") || underlineFiledName.contains("no") || underlineFiledName.contains("number") || underlineFiledName.contains("name") || underlineFiledName.contains("code"))
                return dbDataType + "(64)";
            if (underlineFiledName.contains("url") || underlineFiledName.contains("link"))
                return dbDataType + "(128)";
            if (underlineFiledName.contains("body") || underlineFiledName.contains("msg") || underlineFiledName.contains("message") || underlineFiledName.contains("content") || underlineFiledName.contains("text"))
                return dbDataType + "(768)";
            else return dbDataType + "(256)";
        }
        // 非varchar类型直接返回
        return dbDataType;
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
        return Arrays.stream(aClass.getDeclaredFields())
                .filter(field -> !Objects.equals(Constants.SERIAL_VERSION_UID, field.getName()))
                .filter(field -> !field.getType().isInterface())
                .filter(field -> !field.getType().isArray())
                .map(field -> {
                    String javaDataType = field.getType().isEnum() ? Enum.class.getSimpleName() : field.getType().getSimpleName();
                    String originalDbDataType = DatabaseType.getDbDataType(javaDataType);
                    String realDbDataType = this.parseDbDataType(field, originalDbDataType);

                    Object invoke = null;
                    for (Method method : getPublicGetterMethods(aClass)) {
                        String fieldProps = StringUtils.firstToLowerCase(method.getName().substring(Constants.GET.length()));
                        if (Objects.equals(fieldProps, field.getName())) {
                            invoke = ClassUtil.invoke(method, aClass);
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
     * 解析数据库数据类型
     *
     * @param field              单个字段的信息
     * @param originalDbDataType 从yaml配置文件中读取的原始数据库数据类型
     * @return 解析后的实际数据库数据类型
     */
    default String parseDbDataType(Field field, String originalDbDataType) {
        if (field.getType().isEnum())
            return parseDatabaseEnumTypes(field, originalDbDataType).getDbDtaType();
        else return resolveVarcharLength(camelToUnderline(field.getName()), originalDbDataType);
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
