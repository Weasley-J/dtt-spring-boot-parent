package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.util.ClassUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY;
import static cn.alphahub.dtt.plus.util.ClassUtil.getAllPublicGetterMethods;
import static cn.alphahub.dtt.plus.util.ClassUtil.getEnumTypeStringValues;
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
     * @param field      Java field
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
        //If missing, use the first as the default value of the enumeration type
        wrapper.setDbDtaType(dbDataType + "(" + enumString + ")");
        wrapper.setInitValue(enumTypeStringValues[0]);
        return wrapper;
    }

    /**
     * Deduce the length of given underline filed name,
     * Java type of given 'underlineFiledName' must be 'java.lang.String'
     *
     * @param dbDataType database data type
     * @param field      Java field
     * @return The length of given underline filed name, i.e: varchar(64)
     */
    default String deduceLengthOfStringType(Field field, String dbDataType) {
        //Only handle 'java.lang.String'
        if (!field.getType().isAssignableFrom(String.class)) {
            return dbDataType;
        }
        return deduceDbDataTypeWithLength(field.getName());
    }


    /**
     * Deduce string length by filed name
     *
     * @param filedName The filed name of Java model property
     * @return The DB data type with length
     */
    default String deduceDbDataTypeWithLength(String filedName) {
        String dbDataType;
        String underlineFiledName = camelToUnderline(filedName);
        ContextWrapper wrapper = SpringUtil.getBean(ContextWrapper.class);
        String defaultTextType = wrapper.getTextLengthHandler().getStringLengthMapper().getDefaultTextType();
        Integer defaultTextLength = wrapper.getTextLengthHandler().getStringLengthMapper().getDefaultTextLength();
        dbDataType = defaultTextType + "(" + defaultTextLength + ")";

        Map<String, Integer> textLengthProperties = wrapper.getTextLengthHandler().getTextLengthProperties();
        if (CollectionUtils.isEmpty(textLengthProperties)) {
            return dbDataType;
        }

        // Get the length of the 'String' type configured by the user
        for (Map.Entry<String, Integer> entry : textLengthProperties.entrySet()) {
            String[] texts = entry.getKey().split(",");
            for (String text : texts) {
                if (underlineFiledName.contains(text)) {
                    return defaultTextType + "(" + entry.getValue() + ")";
                }
            }
        }

        return dbDataType;
    }

    /**
     * 解析全限定类名到数据表结构模型
     *
     * @param fullyQualifiedClassName fully qualified class name of model
     * @return 数据表结构模型
     */
    ParseFactory<T> parse(String fullyQualifiedClassName);

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
                    String originalDbDataType = SpringUtil.getBean(DatabaseHandler.class).getDbDataType(javaDataType);
                    String realDbDataType = this.parseDbDataType(field, originalDbDataType);

                    Object invoke = null;
                    for (Method method : getAllPublicGetterMethods(aClass)) {
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
        else return deduceLengthOfStringType(field, originalDbDataType);
    }


    /**
     * Enum Type Wrapper
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class EnumTypeWrapper {
        /**
         * The default value of EnumType
         */
        private String initValue;
        /**
         * The correct DB data type
         */
        private String dbDtaType;
    }
}
