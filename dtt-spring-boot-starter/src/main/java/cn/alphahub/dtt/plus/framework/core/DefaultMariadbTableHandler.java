package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.MariadbDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * mariadb默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultMariadbTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultMariadbTableHandler.class);
    @Autowired
    private MariadbDataMapperProperties mariadbDataMapperProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        if (logger.isInfoEnabled())
            logger.info("使用mariadb默认建表实现 {}", JacksonUtil.toJson(parseFactory.getModel()));
        ModelEntity model = parseFactory.getModel();
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }
        model.getDetails().parallelStream().forEach(detail -> processInitialValue(detail, DatabaseType.MARIADB));
        deduceDecimalPrecision(model);
        logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));
        if (StringUtils.isNoneBlank(model.getDatabaseName())) {
            String databaseName = model.getDatabaseName();
            databaseName = "`" + databaseName + "`";
            model.setDatabaseName(databaseName);
        }
        Map<String, Object> contextMap = new LinkedHashMap<>();
        contextMap.put("defaultEngine", mariadbDataMapperProperties.getDefaultEngine());
        contextMap.put("defaultCharset", mariadbDataMapperProperties.getDefaultCharset());
        contextMap.put("defaultCollate", mariadbDataMapperProperties.getDefaultCollate());
        String template = resolve(() -> model, new VelocityContext(contextMap));
        execute(template);
        return template;
    }
}
