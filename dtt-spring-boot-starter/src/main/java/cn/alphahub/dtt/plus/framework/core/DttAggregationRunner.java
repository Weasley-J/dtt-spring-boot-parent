package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

/**
 * Dtt aggregation runner integrates Executor and Resolver to provide the ability for the database to implement Class
 *
 * @author weasley
 * @version 1.1.0
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DttAggregationRunner {

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
     * Resolve template
     *
     * @param parseFactory The factory of parsed object
     * @param context      The context of Velocity
     * @return table statement
     */
    public String resolve(ParseFactory<ModelEntity> parseFactory, VelocityContext context) {
        return templateResolver.resolve(parseFactory, context);
    }

    /**
     * Execute table statement
     *
     * @param table table statement
     */
    public void execute(String table) {
        templateExecutor.execute(table);
    }

    /**
     * Batch update pure sql array
     *
     * @param sql pure sql array
     */
    public void batchExecute(String... sql) throws DataAccessException {
        templateExecutor.batchExecute(sql);
    }
}
