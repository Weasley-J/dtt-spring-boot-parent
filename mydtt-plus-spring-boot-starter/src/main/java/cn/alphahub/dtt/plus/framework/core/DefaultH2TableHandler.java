package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.H2DataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * DB2默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultH2TableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private H2DataMapperProperties h2DataMapperProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用H2默认建表实现:{}", JacksonUtil.toJson(model));
        if (null == model || ObjectUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName))
            databaseName = "\"PUBLIC\".\"" + databaseName + "\".";
        else
            databaseName = "\"PUBLIC\".";
        model.setDatabaseName(databaseName);

        deduceDecimalPrecision(model);
        handlePropertiesOfModel(() -> model, null);
        if (h2DataMapperProperties.getEnableColumnUpperCase().equals(true)) modelPropertiesToUppercase(() -> model);
        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));

        String template = resolve(() -> model, new VelocityContext());
        String[] pureSqlArray = parseTemplateToPureSQLScripts(StringUtils.split(template, ";"));
        Arrays.asList(pureSqlArray).forEach(sql -> {
            int success = 0;
            for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
                try {
                    execute(sql);
                    success = 1;
                } catch (Exception e) {
                    logger.warn("{}", e.getMessage());
                }
                if (success == 1) break;
            }
        });

        return template;
    }

    @Override
    public void handlePropertiesOfModel(ParseFactory<ModelEntity> parseFactory, ContextWrapper contextWrapper) {
        parseFactory.getModel().getDetails().forEach(detail -> {
            if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'"))
                detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
            if (detail.getFiledComment().contains(";"))
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
        });
    }
}
