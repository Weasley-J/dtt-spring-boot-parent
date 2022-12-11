package com.example.mapper.mybatisplus;

import com.example.domain.dtt.DttMember;
import com.example.mapper.dtt.MemberPlusMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberPlusMapperTests {

    @Autowired
    MemberPlusMapper memberPlusMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void selectOne() {
        DttMember dttMember = memberPlusMapper.selectById(1);
    }

    @Test
    void insert() {

    }

}
