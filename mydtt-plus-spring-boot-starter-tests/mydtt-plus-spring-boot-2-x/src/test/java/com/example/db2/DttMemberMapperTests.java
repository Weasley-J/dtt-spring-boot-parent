package com.example.db2;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
class DttMemberMapperTests {

    @Autowired
    MemberMapper memberMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        DttMember entity = new DttMember();
        entity.setId(1L);
        entity.setOpenId("2323213");
        entity.setNickname("1232323");
        entity.setIsEnable(true);
        entity.setBalance(new BigDecimal("11212"));
        entity.setBirthday(LocalDateTime.now());
        entity.setMemberType(MemberType.ORDINARY);
        entity.setStatus(0);
        entity.setDeleted(0);
        entity.setRegistrarDate(LocalDate.now());
        entity.setAccelerateBeginTime(LocalTime.now());
        entity.setAccelerateEndTime(LocalTime.now());
        entity.setUpdateTime(LocalDateTime.now());

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

    @Test
    void selectList() {
        List<DttMember> dttMemberList = memberMapper.selectList(null);
        dttMemberList.forEach(dttMember -> {
            System.err.println(JSONUtil.toJsonPrettyStr(dttMember));
        });
    }

    @Test
    void getOne() {
        DttMember member = memberMapper.selectOne(new QueryWrapper<DttMember>().lambda().eq(DttMember::getId, 1));
        System.out.println(member);
    }

}
