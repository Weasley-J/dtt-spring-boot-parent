package cn.alphahub.dtt.plus.framework.core.table;

import cn.alphahub.dtt.plus.config.datamapper.MysqlDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttAggregationRunner;
import cn.alphahub.dtt.plus.framework.core.DttTableHandler;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * mysql默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultMysqlTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultMysqlTableHandler.class);
    @Autowired
    private MysqlDataMapperProperties mysqlDataMapperProperties;

    /**
     * Create table
     *
     * @param parseFactory Data Model Analysis Results
     */
    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        if (logger.isDebugEnabled())
            logger.debug("使用mysql默认建表实现 {}", JacksonUtil.toJson(parseFactory.getModel()));
        ModelEntity model = parseFactory.getModel();
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        model.getDetails().forEach(detail -> processInitialValue(detail, DatabaseType.MYSQL));
        deduceDecimalPrecision(model);

        if (logger.isInfoEnabled()) {
            logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));
        }

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) databaseName = "`" + databaseName + "`";
        model.setDatabaseName(databaseName);

        VelocityContext context = new VelocityContext();
        context.put("defaultEngine", mysqlDataMapperProperties.getDefaultEngine());
        context.put("defaultCharset", mysqlDataMapperProperties.getDefaultCharset());
        context.put("defaultCollate", mysqlDataMapperProperties.getDefaultCollate());
        String template = resolve(() -> model, context);
        execute(template);
        return template;
    }
}
