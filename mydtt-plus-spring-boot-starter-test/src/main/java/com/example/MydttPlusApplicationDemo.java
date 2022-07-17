package com.example;

import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttMember;
import com.example.domain.dtt.DttPerson;
import com.example.domain.dtt.OmsB2bOrder;
import com.example.domain.shop.ExcelData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.DatabaseMetaData;

/**
 * mydtt-plus-spring-boot-starter测试验证应用
 */
@SpringBootApplication
@EnableDtt(
        scanBasePackages = {
                //"com.example.domain.dtt",
                "com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                "com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = true,
        scanBaseClasses = {
                //OmsB2bOrder.class,
                //DttPerson.class,
                //DttMember.class,
                //ExcelData.class
        }
)
@MapperScan(basePackages = {"com.example.mappper"})
public class MydttPlusApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlusApplicationDemo.class, args);
    }
}
