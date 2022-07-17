package com.example.springboot.m3.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 分页插件配置
 *
 * @author Weasley J
 * @link https://mp.baomidou.com/guide/page.html
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis plus 支持的数据库类型,主要用于分页方言
     */
    private final DbType dbType = DbType.MYSQL;

    /**
     * 最新版分页配置
     *
     * @return MybatisPlusInterceptor实例
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(dbType));
        return interceptor;
    }
}
