package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.SysUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.StringWriter;

/**
 * 执行数据库建表语句
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/11
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DttRunner {
    private static final Logger logger = LoggerFactory.getLogger(DttRunner.class);

    @Autowired(required = false)
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate defaultJdbcTemplate;

    /**
     * run create DDL statement
     */
    @Transactional(rollbackFor = {Exception.class}, transactionManager = "defaultDataSourceTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public void execute(StringWriter writer) {
        final Logger jdbcLogger = LoggerFactory.getLogger(JdbcTemplate.class);
        if (logger.isInfoEnabled() && !jdbcLogger.isDebugEnabled()) {
            logger.info("数据库建表语句: {} {}", SysUtil.getLineSeparator(), writer);
        }
        defaultJdbcTemplate.execute(writer.toString());
    }
}
