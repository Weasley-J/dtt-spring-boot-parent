package com.example.service;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.domain.dtt.DttMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DttPersonServiceTest {

    @Autowired
    DttMemberService dttMemberService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
        dttMemberService.list(new LambdaQueryWrapper<>(DttMember.class).last(" LIMIT 10")).forEach(dttMember -> {
            System.err.println(JacksonUtil.toJson(dttMember));
        });
    }

    @Test
    void delete() {
        dttMemberService.removeById(null);
    }

}
