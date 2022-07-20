package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

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
}
