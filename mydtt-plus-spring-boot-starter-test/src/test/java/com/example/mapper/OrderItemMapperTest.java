package com.example.mapper;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.order.OrderItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderItemMapperTest {

    @Autowired
    private OrderItemMapper orderItemMapper;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void selectList() {
        List<OrderItem> dttMemberList = orderItemMapper.selectList(null);
        dttMemberList.forEach(dttMember -> {
            System.out.println(JacksonUtil.toJson(dttMember));
        });
    }
}
