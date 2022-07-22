package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dtt Runner integrates Executor and Resolver to provide the ability for the database to implement Class
 *
 * @author weasley
 * @version 1.1.0
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DttRunner {

    @Autowired
    private DefaultTemplateExecutor templateExecutor;

    @Autowired
    private DefaultTemplateResolver templateResolver;

    /**
     * Resolve template
     *
     * @param parseFactory The analysis results  of model
     * @return table statement
     */
    public String resolve(ParseFactory<ModelEntity> parseFactory) {
        return templateResolver.resolve(parseFactory);
    }

    /**
     * Execute table statement
     *
     * @param table table statement
     */
    public void execute(String table) {
        templateExecutor.execute(table);
    }

    /* Batch update pure sql array
     *
     * @param sql pure sql array
     * @return failure, success
     */
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public void batchExecute(String... sql) throws DataAccessException {
        templateExecutor.batchExecute(sql);
    }
}
