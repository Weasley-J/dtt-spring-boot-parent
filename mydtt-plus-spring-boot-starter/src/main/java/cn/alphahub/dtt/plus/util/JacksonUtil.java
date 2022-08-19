package cn.alphahub.dtt.plus.util;


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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectWriter writer;
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
        timeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN)));
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)));
        mapper.registerModule(timeModule).findAndRegisterModules();
        writer = mapper.writerWithDefaultPrettyPrinter();
    }

    private JacksonUtil() {
    }

    /**
     * json字符串（不美化输出json）
     *
     * @param data 格式化数据
     * @return json字符串
     */
    public static String toJson(Object data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}, {}", data, e.getMessage(), e);
            }
            return null;
        }
    }

    /**
     * json字符串（美化输出json）
     *
     * @param data 格式化数据
     * @return json字符串
     */
    public static String toPrettyJson(Object data) {
        try {
            return writer.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{} {}", data, e.getMessage(), e);
            }
            return null;
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
            return mapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}; {}", content, e.getMessage(), e);
            }
            return null;
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
            return mapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}; {}", content, e.getMessage(), e);
            }
            return null;
        }
    }

}
