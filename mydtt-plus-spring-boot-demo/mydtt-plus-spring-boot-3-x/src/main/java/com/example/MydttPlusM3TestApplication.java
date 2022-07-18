package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mydtt-plus-spring-boot-starter test below springboot 3.0.0-x
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlusM3TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydttPlusM3TestApplication.class, args);
    }

}
