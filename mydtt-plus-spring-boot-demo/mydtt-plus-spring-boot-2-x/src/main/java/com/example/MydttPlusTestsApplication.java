package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 * mydtt-plus-spring-boot-starter test below springboot 2.0.0-x
 */
@SpringBootApplication
/*@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                //"com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                //"com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = false,
        scanBaseClasses = {
                //DttPerson.class,
                DttMember.class,
        }
)*/
@MapperScan(basePackages = {"com.example.mapper"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlusTestsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlusTestsApplication.class, args);
    }
}
