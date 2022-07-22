package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttMember;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter test below springboot 3.0.0-x
 */
@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                "com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                "com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = true,
        scanBaseClasses = {
                //OmsOrderInquiry.class
                //DttPerson.class,
                //DttMember.class,
        }
)
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper.dtt"})
public class MydttPlusM3TestApp {

    public static void main(String[] args) {
        SpringApplication.run(MydttPlusM3TestApp.class, args);
    }

}
