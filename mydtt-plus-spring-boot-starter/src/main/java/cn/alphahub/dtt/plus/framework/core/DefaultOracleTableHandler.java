package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.alphahub.dtt.plus.util.SysUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.DataTypeMappingProperties;

/**
 * Oracle默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DttProperties.class, DataTypeMappingProperties.class})
public class DefaultOracleTableHandler extends DttRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultOracleTableHandler.class);
    /**
     * Oracle maximum number of failed attempts to execute create table SQL
     */
    private static final int CREATE_TABLE_RETRY_MAX_COUNT = 3;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DttProperties dttProperties;
    @Autowired
    private DataTypeMappingProperties dataTypeMappingProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用oracle默认建表实现 {}", JacksonUtil.toJson(model));
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        for (ModelEntity.Detail detail : model.getDetails()) {
            if (Boolean.class.getSimpleName().equals(detail.getJavaDataType())) {
                detail.setInitialValue(Boolean.parseBoolean(detail.getInitialValue()) ? "1" : "0");
            } else if (Enum.class.getSimpleName().equals(detail.getJavaDataType())) {
                ContextWrapper wrapper = SpringUtil.getBean(ContextWrapper.class);
                String databaseDataType = detail.getDatabaseDataType();
                String actuallyDbDataType = wrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                String enumValues = databaseDataType.substring(dataTypeMappingProperties.getOracle().get("Enum").toString().length());
                enumValues = enumValues.replace("('", "");
                enumValues = enumValues.replace("')", "");
                enumValues = enumValues.replace("','", ",");
                String filedComment = detail.getFiledComment();
                detail.setDatabaseDataType(actuallyDbDataType);
                detail.setFiledComment(filedComment.concat(", Enum type:").concat(enumValues));
                break;
            }
        }

        if (dttProperties.getEnableOracleColumnUpperCase().equals(true)) toRootUpperCase(() -> model);

        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName))
            model.setDatabaseName("\"".concat(databaseName).concat("\"").concat("."));

        String template = resolve(() -> model);

        String[] sqlArray = StringUtils.split(template, ";");
        String[] sqlTrimArray = Arrays.stream(sqlArray).map(sql -> {
            if (sql.startsWith(SysUtil.getLineSeparator()))
                return StringUtils.substring(sql, SysUtil.getLineSeparator().length());
            else return sql;
        }).collect(Collectors.toList()).stream().map(sql -> {
            if (sql.startsWith(SysUtil.getLineSeparator()))
                return StringUtils.substring(sql, SysUtil.getLineSeparator().length());
            else if (sql.endsWith(SysUtil.getLineSeparator()))
                return StringUtils.removeEnd(sql, SysUtil.getLineSeparator());
            else return sql;
        }).filter(StringUtils::isNoneBlank).toArray(String[]::new);

        String tableName = model.getDatabaseName() + "\"" + model.getModelName() + "\"";
        boolean dropTableBeforeCreate = InitDttHandler.getEnableDtt().dropTableBeforeCreate();
        boolean tableExists = isTableExists(model.getModelName());
        if (dropTableBeforeCreate && tableExists) {
            // int DROP_TABLE_MAX_RETRY_COUNT = 2
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

        String[] pureSQLArray = Arrays.stream(sqlTrimArray).filter(sql -> !sql.startsWith("DROP")).toArray(String[]::new);
        for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
            logger.warn("开始对表'{}'进行第'{}'次尝试建表,当前最大建表重试次数:'{}'", tableName, i, CREATE_TABLE_RETRY_MAX_COUNT);
            boolean updated = this.batchUpdate(pureSQLArray);
            if (updated) break;
        }

        return template;
    }


    /**
     * To root upper case
     *
     * @param parseFactory The parse factory
     */
    public void toRootUpperCase(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        List<ModelEntity.Detail> details = model.getDetails();
        if (CollectionUtils.isEmpty(details)) {
            return;
        }
        List<ModelEntity.Detail> upperCaseDetails = new ArrayList<>(details.size());
        String modelName = model.getModelName().toUpperCase(Locale.ROOT);
        model.setModelName(modelName);
        for (ModelEntity.Detail detail : details) {
            String filedNameToUpperCase = detail.getFiledName().toUpperCase(Locale.ROOT);
            detail.setFiledName(filedNameToUpperCase);
            upperCaseDetails.add(detail);
        }
        model.setDetails(upperCaseDetails);
    }

    /**
     * Batch update pure sql array
     *
     * @param pureSQLArray pure sql array
     * @return failure, success
     */
    public boolean batchUpdate(String[] pureSQLArray) {
        try {
            jdbcTemplate.batchUpdate(pureSQLArray);
            return true;
        } catch (DataAccessException e) {
            logger.warn("{}", e.getMessage());
            return false;
        }
    }

    /**
     * Get table exists or not
     *
     * @param tableName The name of table
     * @return Exists return true
     */
    private boolean isTableExists(String tableName) {
        String sql = "SELECT COUNT(*) FROM USER_TABLES " + "WHERE TABLE_NAME = '" + tableName + "'";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        if (null == result) {
            return false;
        }
        return result > 0;
    }
}
