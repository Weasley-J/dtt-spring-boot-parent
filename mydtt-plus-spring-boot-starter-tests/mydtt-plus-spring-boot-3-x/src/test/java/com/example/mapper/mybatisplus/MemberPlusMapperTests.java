package com.example.mapper.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
        DttMember member = memberPlusMapper.selectOne(Wrappers.lambdaQuery(DttMember.class).eq(DttMember::getId, 1));
    }

    @Test
    void insert() {

    }

}