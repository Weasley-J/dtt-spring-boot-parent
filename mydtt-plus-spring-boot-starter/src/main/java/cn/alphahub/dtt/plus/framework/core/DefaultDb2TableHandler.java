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
public class DefaultDb2TableHandler extends DttRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDb2TableHandler.class);
    @Autowired
    private Db2DataMapperProperties db2DataMapperProperties;
    @Autowired
    private DefaultOracleTableHandler defaultOracleTableHandler;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用DB2默认建表实现 {}", JacksonUtil.toJson(model));
        if (CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        ContextWrapper contextWrapper = SpringUtil.getBean(ContextWrapper.class);
        model.getDetails().forEach(detail -> {
            if (Objects.equals(Enum.class.getSimpleName(), detail.getJavaDataType())) {
                String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                String enumValues = detail.getDatabaseDataType().substring(db2DataMapperProperties.getMappingProperties().get("Enum").toString().length());
                enumValues = enumValues.replace("('", "").replace("')", "").replace("','", ",");
                String filedComment = detail.getFiledComment();
                detail.setDatabaseDataType(actuallyDbDataType);
                detail.setFiledComment(filedComment + ", Enum type:" + enumValues);
            }
        });

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) model.setDatabaseName("\"" + databaseName + "\"" + ".");

        if (db2DataMapperProperties.getEnableColumnUpperCase().equals(true))
            defaultOracleTableHandler.modelToRootUpperCase(() -> model);

        String template = resolve(() -> model);

        String tableName = model.getDatabaseName() + "\"" + model.getModelName() + "\"";
        String[] sqlArray = defaultOracleTableHandler.parseTemplateSQLIntoSQLArray(StringUtils.split(template, ";"));
        for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
            logger.info("正在并发创建表,开始对表[{}]进行第[{}]次尝试建表,当前最大建表重试次数[{}]次", tableName, i, CREATE_TABLE_RETRY_MAX_COUNT);
            boolean update = defaultOracleTableHandler.batchUpdate(sqlArray);
            if (update) break;
        }

        return template;
    }
}
