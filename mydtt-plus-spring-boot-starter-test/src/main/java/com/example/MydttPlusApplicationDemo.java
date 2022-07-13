package com.example;

import cn.alphahub.dtt.plus.enums.ParseType;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter测试验证应用
 */
@SpringBootApplication
@EnableDtt(
        scanBasePackages = {
               // "com.example.domain.dtt",
                //"com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
               // "com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parseCommentType = ParseType.JAVA_DOC,
        dropTableBeforeCreate = true,
        scanBaseClasses = {
                //DttMember.class
                //ExcelData.class
        }
)
@MapperScan(basePackages = {"com.example.mappper"})
public class MydttPlusApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlusApplicationDemo.class, args);
    }
}
