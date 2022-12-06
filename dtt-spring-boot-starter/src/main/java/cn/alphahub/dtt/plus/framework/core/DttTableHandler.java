package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.util.SpringUtil;
import cn.alphahub.dtt.plus.util.SystemUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper;
import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper.PrecisionConfigurationProperties;
import static cn.alphahub.dtt.plus.constant.Constants.NULL_STRING;
import static cn.alphahub.dtt.plus.entity.ContextWrapper.HighPrecisionDataHandler;

/**
 * 创建数据库建表语句上层接口
 *
 * @author weasley
 * @version 1.0.0
 */
@FunctionalInterface
public interface DttTableHandler<T> extends DttContext<T> {
    Logger logger = LoggerFactory.getLogger(DttTableHandler.class);
    /**
     * The maximum number of failed attempts to execute create table SQL
     */
    int CREATE_TABLE_RETRY_MAX_COUNT = 3;

    /**
     * create table
     *
     * @param parseFactory 数据模型解析结果
     * @return table statement
     */
    @Override
    String create(ParseFactory<T> parseFactory);

    /**
     * To handle the properties of model that parsed from factory
     *
     * @param parseFactory   The factory of model which has parsed
     * @param contextWrapper The wrapper class of DTT context
     * @implNote Here is the control logic that handles specific model properties，Delegate to the implementation class of the concrete RDB to implement, if necessary.
     */
    default void handlePropertiesOfModel(ParseFactory<T> parseFactory, ContextWrapper contextWrapper) {
    }

    /**
     * 批量操作所有建表语语句聚合
     *
     * @param modelSet 解析结果
     * @return all tables (ALl IN ONE)
     */
    default String bulkOps(Set<ParseFactory<T>> modelSet) {
        if (CollectionUtils.isEmpty(modelSet)) return null;
        return StringUtils.join(modelSet.parallelStream().map(this::create).collect(Collectors.toList()), SystemUtil.getLineSeparator());
    }

    /**
     * Handling enumeration type to concat string, If possible.
     *
     * @param mappingProperties  The properties of data type mapping
     * @param detail             Model metadata details
     * @param actuallyDbDataType The db data type from 'mappingProperties'
     */
    default void handleEnumerationTypeToString(Properties mappingProperties, ModelEntity.Detail detail, String actuallyDbDataType) {
        String enumValues = detail.getDatabaseDataType().substring(mappingProperties.get("Enum").toString().length());
        enumValues = enumValues.replace("('", "");
        enumValues = enumValues.replace("')", "");
        enumValues = enumValues.replace("','", ",");
        String filedComment = detail.getFiledComment();
        detail.setDatabaseDataType(actuallyDbDataType);
        detail.setFiledComment(filedComment + ", Enum type:" + enumValues);
    }

    /**
     * Deduce the number of decimals for high precision data types
     *
     * @param model The model be processed
     */
    default void deduceDecimalPrecision(ModelEntity model) {
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) return;
        HighPrecisionDataHandler pdh = SpringUtil.getBean(ContextWrapper.class).getHighPrecisionDataHandler();
        HighPrecisionDataMapper pdm = pdh.getHighPrecisionDataMapper();
        model.getDetails().forEach(detail -> {
            if (pdm.getHighPrecisionDataType().compareToIgnoreCase(detail.getJavaDataType()) == 0) {
                String dbDataType = detail.getDatabaseDataType();
                String inferDataType = "";
                if (CollectionUtils.isNotEmpty(pdh.getHighPrecisionDataConfigMap())) {
                    for (Map.Entry<String, PrecisionConfigurationProperties> entry : pdh.getHighPrecisionDataConfigMap().entrySet()) {
                        if (detail.getFiledName().toLowerCase().contains(entry.getKey())) {
                            inferDataType = detail.getDatabaseDataType() + "(" + entry.getValue().getIntegerLength() + "," + entry.getValue().getDecimalLength() + ")";
                            break;
                        }
                    }
                }
                if (!dbDataType.contains("(") && !dbDataType.contains(")")) {
                    String inferPrecision = dbDataType + "(" + pdm.getDefaultIntegerLength() + "," + pdm.getDefaultDecimalLength() + ")";
                    detail.setDatabaseDataType(StringUtils.defaultIfBlank(inferDataType, inferPrecision));
                }
            }
        });
    }

    /**
     * Change model properties to uppercase mode
     *
     * @param parseFactory The parse factory
     */
    default void modelPropertiesToUppercase(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        List<ModelEntity.Detail> originalDetails = model.getDetails();
        if (org.springframework.util.CollectionUtils.isEmpty(originalDetails)) {
            return;
        }
        List<ModelEntity.Detail> upperCaseDetails = new ArrayList<>(originalDetails.size());
        String modelName = model.getModelName().toUpperCase(Locale.ENGLISH);
        model.setModelName(modelName);
        for (ModelEntity.Detail detail : originalDetails) {
            String filedNameToUpperCase = detail.getFiledName().toUpperCase(Locale.ENGLISH);
            detail.setFiledName(filedNameToUpperCase);
            upperCaseDetails.add(detail);
        }
        model.setDetails(upperCaseDetails);
    }

    /**
     * Parse The template SQL to a SQL array composed of a single SQL
     *
     * @param rawSqlArray The array of table template SQL split with  ';'
     * @return A filtered SQL array composed of a single SQL(A pure SQL script array)
     */
    default String[] parseTemplateToPureSQLScripts(String[] rawSqlArray) {
        return Arrays.stream(rawSqlArray).map(sql -> {
            if (sql.startsWith(SystemUtil.getLineSeparator()))
                return StringUtils.substring(sql, SystemUtil.getLineSeparator().length());
            else return sql;
        }).collect(Collectors.toList()).stream().map(sql -> {
            if (sql.startsWith(SystemUtil.getLineSeparator()))
                return StringUtils.substring(sql, SystemUtil.getLineSeparator().length());
            else if (sql.endsWith(SystemUtil.getLineSeparator()))
                return StringUtils.removeEnd(sql, SystemUtil.getLineSeparator());
            else return sql;
        }).filter(StringUtils::isNoneBlank).toArray(String[]::new);
    }

    /**
     * Handle initial value for model
     *
     * @param detail model metadata detail
     */
    default void processInitialValue(ModelEntity.Detail detail) {
        if (StringUtils.isNoneBlank(detail.getInitialValue()) && !NULL_STRING.equalsIgnoreCase(detail.getInitialValue())) {
            detail.setInitialValue("'" + detail.getInitialValue() + "'");
        }
    }
}
