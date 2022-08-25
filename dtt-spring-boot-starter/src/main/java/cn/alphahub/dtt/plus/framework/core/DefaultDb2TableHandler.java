package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.Db2DataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * DB2默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultDb2TableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Db2DataMapperProperties db2DataMapperProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用DB2默认建表实现 {}", JacksonUtil.toJson(model));
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        deduceDecimalPrecision(model);

        handlePropertiesOfModel(() -> model, SpringUtil.getBean(ContextWrapper.class));

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) model.setDatabaseName("\"" + databaseName + "\"" + ".");

        if (db2DataMapperProperties.getEnableColumnUpperCase().equals(true)) modelPropertiesToUppercase(() -> model);

        String template = resolve(() -> model);

        String[] pureSqlArray = parseTemplateToPureSQLScripts(StringUtils.split(template, ";"));

        Arrays.asList(pureSqlArray).forEach(sql -> {
            boolean success = false;
            for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
                try {
                    //If the field comment is too long, it will cause rollback and cannot be submitted in batches
                    execute(sql);
                    success = true;
                } catch (Exception e) {
                    logger.warn("{}", e.getMessage());
                }
                if (success) break;
            }
        });

        return template;
    }

    @Override
    public void handlePropertiesOfModel(ParseFactory<ModelEntity> parseFactory, ContextWrapper contextWrapper) {
        parseFactory.getModel().getDetails().forEach(detail -> {
            if (Objects.equals(Enum.class.getSimpleName(), detail.getJavaDataType())) {
                String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handleEnumerationTypeToString(db2DataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
            }
            if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'")) {
                detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
            }
            if (detail.getFiledComment().contains("\\.")) {
                detail.setFiledComment(detail.getFiledComment().replace("\\.", " "));
            }
            if (detail.getFiledComment().contains(";")) {
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
            }
        });
    }
}
