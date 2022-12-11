package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttPerson;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dtt-spring-boot-starter test below springboot 2.x.x
 */
@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                //"com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                //"com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        scanBaseClasses = {
                DttPerson.class,
        },
        parserType = ParserType.ANNOTATION,
        dropTableBeforeCreate = true
)
//@EnableDtt
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
public class DttPlus2xAnnotationTest {
    public static void main(String[] args) {
        SpringApplication.run(DttPlus2xAnnotationTest.class, args);
    }
}
