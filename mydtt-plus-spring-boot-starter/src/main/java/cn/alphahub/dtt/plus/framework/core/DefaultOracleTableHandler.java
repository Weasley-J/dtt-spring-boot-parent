package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.OracleDataMapperProperties;
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
    private OracleDataMapperProperties oracleDataMapperProperties;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用oracle默认建表实现 {}", JacksonUtil.toJson(model));
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        //处理Oracle数据类型
        handlingOracleDataTypes(model);
        deduceDecimalPrecision(model);

        if (oracleDataMapperProperties.getEnableColumnUpperCase().equals(true)) toRootUpperCase(() -> model);

        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName))
            model.setDatabaseName("\"".concat(databaseName).concat("\"").concat("."));

        model.getDetails().forEach(detail -> {
            if (detail.getFiledComment().contains(";"))
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
        });

        String template = resolve(() -> model);

        String[] sqlArray = StringUtils.split(template, ";");
        String[] sqlTrimArray = parseTemplateSQLToArray(sqlArray);

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

    /**
     * Template SQL to  a SQL array composed of a single SQL
     *
     * @param sqlArray The array of TemplateSQL split with  ';'
     * @return A filtered SQL array composed of a single SQL
     */
    public String[] parseTemplateSQLToArray(String[] sqlArray) {
        return Arrays.stream(sqlArray).map(sql -> {
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
     * 处理Oracle数据类型
     * <ul>
     *     <li>Boolean</li>
     *     <li>Enum</li>
     * </ul>
     *
     * @param model 域模型信息
     */
    private void handlingOracleDataTypes(ModelEntity model) {
        for (ModelEntity.Detail detail : model.getDetails()) {
            if (Boolean.class.getSimpleName().equals(detail.getJavaDataType())) {
                detail.setInitialValue(Boolean.parseBoolean(detail.getInitialValue()) ? "1" : "0");
            }
            if (Enum.class.getSimpleName().equals(detail.getJavaDataType())) {
                ContextWrapper wrapper = SpringUtil.getBean(ContextWrapper.class);
                String actuallyDbDataType = wrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handlingEnumerationTypeToString(oracleDataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
            }
        }
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
     * @return Exists return true
     */
    protected boolean isTableExists(String tableName) {
        String sql = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + tableName + "'";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        if (null == result) return false;
        return result > 0;
    }
}
