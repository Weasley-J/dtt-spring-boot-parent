package com.example.mapper.mybatis;

import com.example.domain.dtt.DttMember;
import com.example.mapper.dtt.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DttMemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * insert record to table
     */
    @Test
    void insert() {
    }

    @Test
    void insertOrUpdate() {
    }

    @Test
    void insertOrUpdateSelective() {
    }

    /**
     * insert record to table selective
     */
    @Test
    void insertSelective() {
    }

    /**
     * select by primary key
     */
    @Test
    void getOne() {
        DttMember dttMember = jdbcTemplate.queryForObject("SELECT ID, OPEN_ID, NICKNAME, IS_ENABLE, BALANCE, BIRTHDAY, MEMBER_TYPE, STATUS, DELETED, REGISTRAR_DATE, ACCELERATE_BEGIN_TIME, ACCELERATE_END_TIME, UPDATE_TIME\n" +
                "FROM TESTDB.DTT_MEMBER WHERE ID = 1", DttMember.class);
        System.out.println(dttMember);
    }

    /**
     * select by primary key
     */
    @Test
    void selectById() {
        System.out.println(this.memberMapper.selectById(1L));
    }

    /**
     * update record selective
     */
    void updateByPrimaryKeySelective() {
    }

    /**
     * update record
     */
    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void updateBatch() {
    }

    @Test
    void updateBatchSelective() {
    }

    @Test
    void batchInsert() {
    }
}
