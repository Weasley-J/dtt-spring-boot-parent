package com.example.mapper;

import com.example.domain.dtt.DttMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DttMemberMapperTest {


    @Autowired
    DttMemberMapper dttMemberMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectById() {
        DttMember dttMember = dttMemberMapper.selectById(1L);
        System.out.println(dttMember);
    }
}
