package com.example;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.alphahub.dtt.plus.util.YamlToPropsUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.system.SystemUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class MydttPlusTestsApplicationTests {

    @Autowired
    DttProperties dttProperties;

    @Autowired
    DttProperties.AllInOneTableProperties allInOneProperties;

    @Test
    void contextLoads() {
    }

    @Test
    void contextLoads2() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = SystemUtil.getProps();
        Properties properties = YamlToPropsUtil.toProperties("application-db-mapper.yml");
        System.out.println(JacksonUtil.toPrettyJson(properties));
    }

    @Test
    void contextLoads3() {
        DatabaseType databaseType = DatabaseHandler.getDbType(SpringUtil.getBean(DataSourceProperties.class).getUrl());
        System.out.println(databaseType);
    }

    @Test
    void contextLoads3a() {
        System.out.println(JacksonUtil.toPrettyJson(allInOneProperties));
    }

    @Test
    void contextLoads4() {
        System.out.println(JacksonUtil.toPrettyJson(dttProperties));
    }

    @Test
    void contextLoads5() {
        System.out.println(dttProperties.getDataTypeMapper().getMysql().get("LocalDateTime"));
    }

}
