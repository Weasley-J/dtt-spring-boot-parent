package com.example.config;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/20
 */
@SpringBootTest
class DttPropertiesTests {

    @Autowired
    DttProperties dttProperties;

    @Test
    void contextLoads() {

    }


    @Test
    void getPrimaryKeyMapper() {
        Map<DatabaseType, String> primaryKeyMapper = dttProperties.getPrimaryKeyMapper();
        System.out.println("primaryKeyMapper = " + primaryKeyMapper);
    }

    @Test
    void printDttProperties() {
        System.err.println(JacksonUtil.toPrettyJson(dttProperties));
    }

}
