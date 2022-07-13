package com.example.config;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class DataSourceAutoConfigTests {

    @Autowired
    private JdbcTemplate defaultJdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Test
    void contextLoads1() {
        List<Map<String, Object>> data = defaultJdbcTemplate.queryForList("SELECT * FROM member");
        String prettyJson = JacksonUtil.toPrettyJson(data);
        System.out.println(prettyJson);

        List<Map<String, Object>> readValue = JacksonUtil.readValue(prettyJson, new TypeReference<List<Map<String, Object>>>() {
        });
        String toPrettyJson = JacksonUtil.toPrettyJson(data);
        System.out.println("\n" + toPrettyJson);

    }


    @Test
    @Transactional
    void contextLoads2() {
        int update = defaultJdbcTemplate.update("DELETE FROM member WHERE id in (11,12,13,14)");
        System.out.println("update = " + update);
        int i = 1 / 0;
    }


    @Test
    @Transactional
    void contextLoads3() {
        defaultJdbcTemplate.update("INSERT INTO `lejing_job`.`member` (`id`, `open_id`, `nickname`, `is_enable`, `balance`, `birthday`, `member_type`, `status`, `deleted`, `registrar_date`, `accelerate_begin_time`, `accelerate_end_time`, `update_time`) VALUES (null, 'lG9wnjCSzN', 'Hara Rin', 0, 27.34, '2015-11-26 05:13:45', 'GUNMETAL', 3, 0, '2001-03-16', '11:06:44', '16:14:26', '2016-03-03 01:23:37');");
        int i = 1 / 0;
    }

}
