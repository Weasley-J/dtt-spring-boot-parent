package com.example;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dtt-spring-boot-starter test below springboot 2.x.x
 */
/*@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                "com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                "com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        scanBaseClasses = {
                //DttPerson.class,
                DttMember.class,
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = true
)*/
@EnableDtt
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlus2xTestApp {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlus2xTestApp.class, args);
    }
}
