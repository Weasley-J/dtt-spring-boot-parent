package com.example;

import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.alphahub.dtt.plus.util.YamlToPropsUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.system.SystemUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class MydttPlus2xTestAppTests {

    @Test
    void contextLoads() {
    }

    @Test
    void toProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = SystemUtil.getProps();
        Properties properties = YamlToPropsUtil.toProperties("application-db-mapper.yml");
        System.out.println(JacksonUtil.toPrettyJson(properties));
    }

    @Test
    void databaseType() {
        DatabaseType databaseType = DatabaseHandler.getDbType(SpringUtil.getBean(DataSourceProperties.class).getUrl());
        System.out.println(databaseType);
    }
}
