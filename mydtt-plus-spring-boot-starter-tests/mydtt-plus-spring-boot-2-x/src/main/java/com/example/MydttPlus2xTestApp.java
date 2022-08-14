package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttMember;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter test below springboot 2.0.0-x
 */
@SpringBootApplication
@EnableDtt(
        scanBasePackages = {
                //"com.example.i18n.korean",
                //"com.example.domain.dtt",
                //"com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                //"com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = false,
        scanBaseClasses = {
                //OmsOrderInquiry.class,
                //DttPerson.class,
                DttMember.class,
                //OrderBatchShipReq.class,
                //RxInquiryLog.class,
        }
)
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlus2xTestApp {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlus2xTestApp.class, args);
    }
}
