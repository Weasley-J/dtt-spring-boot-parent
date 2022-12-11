package com.example.properties;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Dtt Properties Tests
 *
 * @author weasley
 * @version 1.0.0
 */
@SpringBootTest
class DttPropertiesTests {

    @Autowired
    DttProperties dttProperties;

    @Test
    void contextLoads() {
    }


    @Test
    void contextLoads1() {
        System.err.println(JacksonUtil.toPrettyJson(this.dttProperties));
    }

}
