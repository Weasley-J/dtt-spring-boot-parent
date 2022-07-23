package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dtt Executor
 * <p>
 * To execute table DDL statement
 *
 * @author weasley
 * @version 1.0
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultTemplateExecutor implements DttTemplateHandler<Void> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultTemplateExecutor.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public void execute(String table) {
        if (StringUtils.isBlank(table)) {
            logger.warn("Database table creation statement must be not null");
            return;
        }
        jdbcTemplate.execute(table);
    }

    /**
     * Batch update pure sql array
     *
     * @param sql pure sql array
     */
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public void batchExecute(String... sql) throws DataAccessException {
        jdbcTemplate.batchUpdate(sql);
    }

}
