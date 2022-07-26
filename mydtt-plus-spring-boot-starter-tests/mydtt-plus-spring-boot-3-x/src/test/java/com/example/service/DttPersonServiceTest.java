package com.example.service;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.dtt.DttMember;
import com.example.mapper.DttMemberMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DttMemberServiceTest {

    @Autowired
    DttMemberService dttMemberService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list(){
        dttMemberService.list().forEach(dttMember -> {
            System.err.println(JacksonUtil.toJson(dttMember));
        });
    }
}
