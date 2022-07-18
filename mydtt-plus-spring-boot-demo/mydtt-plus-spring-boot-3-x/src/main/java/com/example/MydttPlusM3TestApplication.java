package com.example;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter test below springboot 3.0.0-x
 */
@EnableDtt
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper.dtt"})
public class MydttPlusM3TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydttPlusM3TestApplication.class, args);
    }

}
