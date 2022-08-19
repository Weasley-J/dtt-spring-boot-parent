package com.example.dtt.util;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.dtt.DttMember;
import com.example.page.PageWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enter the description of this class here
 *
 * @author weasley
 * @version 1.0.0
 */
class JacksonUtilTests {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final String json = "{\n" + "  \"pageNum\": 1,\n" + "  \"pageSize\": 10,\n" + "  \"total\": 8,\n" + "  \"pages\": 1,\n" + "  \"list\": [\n" + "    {\n" + "      \"id\": 1,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:56\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:56\",\n" + "      \"accelerateEndTime\": \"15:46:56\",\n" + "      \"updateTime\": \"2022-08-19 15:46:56\"\n" + "    },\n" + "    {\n" + "      \"id\": 2,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:57\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:57\",\n" + "      \"accelerateEndTime\": \"15:46:57\",\n" + "      \"updateTime\": \"2022-08-19 15:46:57\"\n" + "    },\n" + "    {\n" + "      \"id\": 3,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:57\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:57\",\n" + "      \"accelerateEndTime\": \"15:46:57\",\n" + "      \"updateTime\": \"2022-08-19 15:46:57\"\n" + "    },\n" + "    {\n" + "      \"id\": 4,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:57\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:57\",\n" + "      \"accelerateEndTime\": \"15:46:57\",\n" + "      \"updateTime\": \"2022-08-19 15:46:57\"\n" + "    },\n" + "    {\n" + "      \"id\": 5,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:58\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:58\",\n" + "      \"accelerateEndTime\": \"15:46:58\",\n" + "      \"updateTime\": \"2022-08-19 15:46:58\"\n" + "    },\n" + "    {\n" + "      \"id\": 6,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:58\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:58\",\n" + "      \"accelerateEndTime\": \"15:46:58\",\n" + "      \"updateTime\": \"2022-08-19 15:46:58\"\n" + "    },\n" + "    {\n" + "      \"id\": 7,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:58\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:58\",\n" + "      \"accelerateEndTime\": \"15:46:58\",\n" + "      \"updateTime\": \"2022-08-19 15:46:58\"\n" + "    },\n" + "    {\n" + "      \"id\": 8,\n" + "      \"openId\": \"fawezOE5sT\",\n" + "      \"nickname\": \"蒋震南\",\n" + "      \"isEnable\": true,\n" + "      \"balance\": 865.0000,\n" + "      \"birthday\": \"2022-08-19 15:46:59\",\n" + "      \"memberType\": \"STUDENT\",\n" + "      \"status\": 0,\n" + "      \"deleted\": 1,\n" + "      \"registrarDate\": \"2022-08-19\",\n" + "      \"accelerateBeginTime\": \"15:46:59\",\n" + "      \"accelerateEndTime\": \"15:46:59\",\n" + "      \"updateTime\": \"2022-08-19 15:46:59\"\n" + "    }\n" + "  ]\n" + "}";

    /**
     * To json string
     */
    @Test
    void toJson() {
        PageWrapper<DttMember> readValue = JacksonUtil.readValue(json, new TypeReference<PageWrapper<DttMember>>() {
        });
        logger.info("{}", JacksonUtil.toJson(readValue));
    }

    /**
     * json字符串（美化输出json）
     */
    @Test
    void toPrettyJson() {
        PageWrapper<DttMember> readValue = JacksonUtil.readValue(json, new TypeReference<PageWrapper<DttMember>>() {
        });
        logger.info("{}", JacksonUtil.toPrettyJson(readValue));
    }

    /**
     * Method to deserialize JSON content from given JSON content String.
     */
    @Test
    void readValue() {
        PageWrapper<DttMember> readValue = JacksonUtil.readValue(json, new TypeReference<PageWrapper<DttMember>>() {
        });
        logger.info("{}", readValue);
    }
}
