package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter test below springboot 3.x.x
 */
@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                //"com.example.domain.order",
        },
        scanBaseClasses = {
                //OmsOrderInquiry.class
                //DttPerson.class,
                //DttMember.class,
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = false
)
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper.dtt", "com.example.mapper"})
public class MydttPlus3xTestAp {

    public static void main(String[] args) {
        SpringApplication.run(MydttPlus3xTestAp.class, args);
    }

}
