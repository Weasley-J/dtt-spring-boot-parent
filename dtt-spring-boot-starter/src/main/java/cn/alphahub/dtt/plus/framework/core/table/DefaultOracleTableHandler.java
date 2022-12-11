package cn.alphahub.dtt.plus.framework.core.table;

import cn.alphahub.dtt.plus.config.DttMybatisAutoConfiguration;
import cn.alphahub.dtt.plus.config.datamapper.OracleDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttAggregationRunner;
import cn.alphahub.dtt.plus.framework.core.DttTableHandler;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Oracle默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({OracleDataMapperProperties.class})
public class DefaultOracleTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultOracleTableHandler.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private OracleDataMapperProperties oracleDataMapperProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用oracle默认建表实现 {}", JacksonUtil.toJson(model));
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName))
            model.setDatabaseName("\"".concat(databaseName).concat("\"").concat("."));

        handlePropertiesOfModel(() -> model, applicationContext.getBean(ContextWrapper.class));

        deduceDecimalPrecision(model);

        if (oracleDataMapperProperties.getEnableColumnUpperCase().equals(true)) modelPropertiesToUppercase(() -> model);

        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));

        String template = resolve(() -> model);

        String[] sqlTrimArray = parseTemplateToPureSQLScripts(StringUtils.split(template, ";"));

        String tableName = model.getDatabaseName() + "\"" + model.getModelName() + "\"";
        boolean dropTableBeforeCreate = InitDttHandler.getEnableDtt().dropTableBeforeCreate();
        boolean tableExists = isTableExists(model.getModelName());
        if (dropTableBeforeCreate && tableExists) {
            // int DROP_TABLE_MAX_RETRY_COUNT = 2
            dropTableWithRetry(tableName);
        }

        String[] pureSQLArray = Arrays.stream(sqlTrimArray).filter(sql -> !sql.startsWith("DROP")).toArray(String[]::new);
        for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
            logger.info("开始对表[{}]进行第[{}]次尝试建表,当前最大建表重试次数[{}]次", tableName, i, CREATE_TABLE_RETRY_MAX_COUNT);
            boolean updated = this.batchUpdate(pureSQLArray);
            if (updated) break;
        }

        return template;
    }

    @Override
    public void handlePropertiesOfModel(ParseFactory<ModelEntity> parseFactory, ContextWrapper contextWrapper) {
        ModelEntity model = parseFactory.getModel();
        for (ModelEntity.Detail detail : model.getDetails()) {
            if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'")) {
                detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
            }
            if (Boolean.class.getSimpleName().equals(detail.getJavaDataType())) {
                detail.setInitialValue(Boolean.parseBoolean(detail.getInitialValue()) ? "1" : "0");
            }
            if (Enum.class.getSimpleName().equals(detail.getJavaDataType())) {
                String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handleEnumerationTypeToString(oracleDataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
            }
            if (detail.getFiledComment().contains(";")) {
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
            }
        }
    }

    /**
     * Drop table with retry two times
     *
     * @param tableName The name of Table
     */
    private void dropTableWithRetry(String tableName) {
        try {
            jdbcTemplate.execute("DROP TABLE " + tableName + " PURGE");
        } catch (DataAccessException e) {
            logger.warn("{}", e.getMessage());
            try {
                jdbcTemplate.execute("DROP TABLE " + tableName);
            } catch (DataAccessException ex) {
                logger.warn("{}", e.getMessage());
            }
        }
    }

    /**
     * Batch update pure sql array
     *
     * @param sql pure sql array
     * @return failure, success
     */
    public boolean batchUpdate(String... sql) {
        try {
            batchExecute(sql);
            return true;
        } catch (DataAccessException e1) {
            logger.warn("{}", e1.getMessage());
            return false;
        }
    }

    /**
     * Get table exists or not
     *
     * @param tableName The name of table
     * @return if exists return true
     */
    protected boolean isTableExists(String tableName) {
        DttMybatisAutoConfiguration config = applicationContext.getBean(DttMybatisAutoConfiguration.class);
        DatabaseProperty dbProperty = applicationContext.getBean(DatabaseProperty.class);
        List<String> sqlScripts = config.getQueryTableExistsSqlScripts(tableName, dbProperty.getDatabaseType());
        for (String sql : sqlScripts) {
            try {
                Integer exists = jdbcTemplate.queryForObject(sql, Integer.class);
                if (null != exists && exists > 0) {
                    return true;
                }
            } catch (DataAccessException ignored) {
                //No dump
            }
        }
        return false;
    }
}
