package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
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
public class DefaultMysqlTableHandler implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultMysqlTableHandler.class);

    @Autowired
    private DefaultTemplateExecutor tableExecutor;
    @Autowired
    private DefaultTemplateResolver templateResolver;

    /**
     * Create table
     *
     * @param parseFactory Data Model Analysis Results
     */
    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        if (logger.isDebugEnabled()) logger.debug("使用mysql默认建表实现 {}", JacksonUtil.toJson(parseFactory.getModel()));
        ModelEntity model = parseFactory.getModel();
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        if (logger.isInfoEnabled()) {
            logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));
        }

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) databaseName = "`" + databaseName + "`";
        model.setDatabaseName(databaseName);

        String template = templateResolver.resolve(() -> model);
        tableExecutor.execute(template);
        return template;
    }
}
