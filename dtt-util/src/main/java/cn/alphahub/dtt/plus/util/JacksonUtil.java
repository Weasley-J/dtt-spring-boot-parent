package cn.alphahub.dtt.plus.util;

import cn.alphahub.dtt.plus.util.exception.UtilException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Jackson工具类
 *
 * @author weasley
 * @version 1.0.0
 */
public final class JacksonUtil {
    public static final String LOCAL_TIME_PATTERN = "HH:mm:ss";
    public static final String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
    public static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final ObjectWriter WRITER;

    public static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
        timeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
        MAPPER.registerModule(timeModule).findAndRegisterModules();
        WRITER = MAPPER.writerWithDefaultPrettyPrinter();
    }

    private JacksonUtil() {
    }

    /**
     * json字符串（不美化输出json）
     *
     * @param data 格式化数据
     * @return json字符串
     */
    public static <T> String toJson(T data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new UtilException(e.getMessage(), e);
        }
    }

    /**
     * json字符串（美化输出json）
     *
     * @param data 格式化数据
     * @return json字符串
     */
    public static <T> String toPrettyJson(T data) {
        try {
            return WRITER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new UtilException(e.getMessage(), e);
        }
    }

    /**
     * Method to deserialize JSON content from given JSON content String.
     *
     * @param content      json string
     * @param valueTypeRef type reference
     * @param <T>          type
     * @return T
     */
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        try {
            return MAPPER.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new UtilException(e.getMessage(), e);
        }
    }

    /**
     * Method to deserialize JSON content from given JSON content String.
     *
     * @param content   json string
     * @param valueType value class type
     * @param <T>       type
     * @return type
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            return MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new UtilException(e.getMessage(), e);
        }
    }

}
