package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttPerson;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dtt-spring-boot-starter test below springboot 3.x.x
 */
@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                //"com.example.domain.order",
        },
        scanBaseClasses = {
                //OmsOrderInquiry.class
                DttPerson.class,
                //DttMember.class,
        },
        parserType = ParserType.ANNOTATION,
        dropTableBeforeCreate = false
)
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper.dtt", "com.example.mapper"})
public class DttPlus3xJavadocTest {

    public static void main(String[] args) {
        SpringApplication.run(DttPlus3xJavadocTest.class, args);
    }

}
