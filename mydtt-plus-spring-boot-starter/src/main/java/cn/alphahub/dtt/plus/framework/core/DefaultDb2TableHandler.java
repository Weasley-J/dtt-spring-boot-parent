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
    private static final Logger logger = LoggerFactory.getLogger(DefaultDb2TableHandler.class);
    @Autowired
    private Db2DataMapperProperties db2DataMapperProperties;
    @Autowired
    private DefaultOracleTableHandler defaultOracleTableHandler;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用DB2默认建表实现 {}", JacksonUtil.toJson(model));
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        deduceDecimalPrecision(model);

        ContextWrapper contextWrapper = SpringUtil.getBean(ContextWrapper.class);
        model.getDetails().forEach(detail -> {
            if (Objects.equals(Enum.class.getSimpleName(), detail.getJavaDataType())) {
                String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handlingEnumerationTypeToString(db2DataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
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

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) model.setDatabaseName("\"" + databaseName + "\"" + ".");

        if (db2DataMapperProperties.getEnableColumnUpperCase().equals(true))
            defaultOracleTableHandler.toRootUpperCase(() -> model);

        String template = resolve(() -> model);

        String[] pureSqlArray = defaultOracleTableHandler.parseTemplateSQLToArray(StringUtils.split(template, ";"));

        Arrays.asList(pureSqlArray).forEach(sql -> {
            boolean success;
            for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
                try {
                    //If the field comment is too long, it will cause rollback and cannot be submitted in batches
                    execute(sql);
                    success = true;
                } catch (Exception e) {
                    logger.warn("{}", e.getMessage());
                    success = false;
                }
                if (success) break;
            }
        });

        return template;
    }

}
