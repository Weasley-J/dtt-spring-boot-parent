package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.SysUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DttTableRunner {
    private static final Logger logger = LoggerFactory.getLogger(DttTableRunner.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * run create DDL statement
     *
     * @param writer DDL statement writer
     */
    @Transactional(rollbackFor = {Exception.class}, transactionManager = "defaultDataSourceTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public void execute(StringWriter writer) {
        if (logger.isDebugEnabled()) {
            logger.debug("数据库建表语句:{}{}", SysUtil.getLineSeparator(), writer);
        }
        jdbcTemplate.execute(writer.toString());
    }

    /**
     * run create DDL statement
     *
     * @param table 数据表
     */
    @Transactional(rollbackFor = {Exception.class}, transactionManager = "defaultDataSourceTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public void execute(String table) {
        if (logger.isDebugEnabled()) {
            logger.debug("数据库建表语句:{}{}", SysUtil.getLineSeparator(), table);
        }
        jdbcTemplate.execute(table);
    }
}
