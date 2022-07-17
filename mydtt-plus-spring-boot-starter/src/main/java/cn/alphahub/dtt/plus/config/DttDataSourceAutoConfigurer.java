package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源连接信息配置
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DataSourceProperties.class})
public class DttDataSourceAutoConfigurer {

    @RefreshScope
    @ConditionalOnClass(DataSourceProperties.class)
    @Bean(name = {"defaultHikariDataSource"})
    public HikariDataSource defaultHikariDataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    /**
     * default jdbc template
     *
     * @param dataSource default hikari data source
     * @return defaultJdbcTemplate
     */
    @Bean(name = {"defaultJdbcTemplate"})
    @DependsOn({"defaultHikariDataSource"})
    public JdbcTemplate defaultJdbcTemplate(@Qualifier(value = "defaultHikariDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * default data source transaction manager
     *
     * @param dataSource default hikari data source
     * @return defaultDataSourceTransactionManager
     */
    @Bean(name = {"defaultDataSourceTransactionManager"})
    @DependsOn({"defaultHikariDataSource", "defaultJdbcTemplate"})
    public DataSourceTransactionManager defaultDataSourceTransactionManager(@Qualifier(value = "defaultHikariDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
