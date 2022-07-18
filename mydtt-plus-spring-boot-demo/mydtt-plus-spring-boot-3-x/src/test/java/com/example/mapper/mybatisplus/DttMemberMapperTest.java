package com.example.mapper.mybatisplus;

import cn.hutool.json.JSONUtil;
import com.example.domain.dtt.DttMember;
import com.example.enums.MemberType;
import com.example.mapper.MemberMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class DttMemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void selectList() {
        List<DttMember> dttMemberList = memberMapper.selectList(null);
        dttMemberList.forEach(dttMember -> {
            System.out.println(JSONUtil.toJsonPrettyStr(dttMember));
        });
    }

    @Test
    void insert() {
        DttMember entity = new DttMember();
        entity.setIsEnable(true)
                .setOpenId("12313233243")
                .setDeleted(0)
                .setBalance(new BigDecimal(1))
                .setMemberType(MemberType.GUNMETAL)
                .setStatus(1);
        memberMapper.insert(entity);
        System.out.println(JSONUtil.toJsonPrettyStr(entity));
    }


    @Test
    @Transactional
    void insertTransactional() {
        DttMember entity = new DttMember();
        entity.setIsEnable(true)
                .setOpenId("12313233243")
                .setDeleted(0)
                .setBalance(new BigDecimal(1))
                .setMemberType(MemberType.GUNMETAL)
                .setStatus(1);
        memberMapper.insert(entity);
        System.out.println(JSONUtil.toJsonPrettyStr(entity));
        int i = 1 / 0;
    }
}
