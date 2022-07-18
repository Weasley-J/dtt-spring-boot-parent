package com.example.mapper.tkmapper;

import cn.hutool.json.JSONUtil;
import com.example.domain.dtt.DttMember;
import com.example.enums.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@SpringBootTest
class DttMemberTkMapperTest {

    @Autowired
    DttMemberTkMapper dttMemberTkMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * insert
     */
    @Test
    void insert() {
        DttMember member = new DttMember();
        member.setOpenId("insert");
        member.setNickname("insert");
        member.setIsEnable(false);
        member.setBalance(new BigDecimal("0"));
        member.setBirthday(LocalDateTime.now());
        member.setMemberType(MemberType.ORDINARY);
        member.setStatus(0);
        member.setDeleted(0);
        member.setRegistrarDate(LocalDate.now());
        member.setAccelerateBeginTime(LocalTime.now());
        member.setAccelerateEndTime(LocalTime.now());
        member.setUpdateTime(LocalDateTime.now());
        int insert = dttMemberTkMapper.insert(member);
        log.info("{} {}", insert, JSONUtil.toJsonStr(member));
    }

    /**
     * insert with tansactional
     */
    @Test
    @Transactional
    void insertTransactional() {
        DttMember member = new DttMember();
        member.setOpenId("insertTransactional");
        member.setNickname("insertTransactional");
        member.setIsEnable(false);
        member.setBalance(new BigDecimal("0"));
        member.setBirthday(LocalDateTime.now());
        member.setMemberType(MemberType.ORDINARY);
        member.setStatus(0);
        member.setDeleted(0);
        member.setRegistrarDate(LocalDate.now());
        member.setAccelerateBeginTime(LocalTime.now());
        member.setAccelerateEndTime(LocalTime.now());
        member.setUpdateTime(LocalDateTime.now());

        int insert = dttMemberTkMapper.insert(member);

        log.info("{} {}", insert, JSONUtil.toJsonStr(member));

        int i = 1 / 0;
    }


    /**
     * select list
     */
    @Test
    void selectList() {
        List<DttMember> dttMembers = dttMemberTkMapper.selectAll();
        dttMembers.forEach(System.out::println);
    }

}
