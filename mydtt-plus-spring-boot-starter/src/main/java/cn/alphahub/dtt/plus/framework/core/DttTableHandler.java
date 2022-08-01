package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.util.SysUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper;
import static cn.alphahub.dtt.plus.entity.ContextWrapper.HighPrecisionDataHandler;

/**
 * 创建数据库建表语句上层接口
 *
 * @author weasley
 * @version 1.0.0
 */
@FunctionalInterface
public interface DttTableHandler<T> extends DttContext<T> {
    /**
     * The maximum number of failed attempts to execute create table SQL
     */
    int CREATE_TABLE_RETRY_MAX_COUNT = 3;
    /**
     * The size of batch
     */
    int BATCH_SIZE = 20;

    /**
     * create table
     *
     * @param parseFactory 数据模型解析结果
     * @return table statement
     */
    @Override
    String create(ParseFactory<T> parseFactory);

    /**
     * 批量操作所有建表语语句聚合
     *
     * @param modelSet 解析结果
     * @return all tables (ALl IN ONE)
     */
    default String bulkOps(Set<ParseFactory<T>> modelSet) {
        if (CollectionUtils.isEmpty(modelSet)) return null;
        return StringUtils.join(modelSet.parallelStream().map(this::create).collect(Collectors.toList()), SysUtil.getLineSeparator());
    }

    /**
     * Handling enumeration type to concat string, If possible.
     *
     * @param mappingProperties  The properties of data type mapping
     * @param detail             Model metadata details
     * @param actuallyDbDataType The db data type from 'mappingProperties'
     */
    default void handlingEnumerationTypeToString(Properties mappingProperties, ModelEntity.Detail detail, String actuallyDbDataType) {
        String enumValues = detail.getDatabaseDataType().substring(mappingProperties.get("Enum").toString().length());
        enumValues = enumValues.replace("('", "");
        enumValues = enumValues.replace("')", "");
        enumValues = enumValues.replace("','", ",");
        String filedComment = detail.getFiledComment();
        detail.setDatabaseDataType(actuallyDbDataType);
        detail.setFiledComment(filedComment + ", Enum type:" + enumValues);
    }

    /**
     * Split array to batch list
     *
     * @param sqlArray  The given array
     * @param batchSize How many pieces in a batch
     * @return A split list
     */
    default List<String[]> splitArrayToBatchList(String[] sqlArray, int batchSize) {
        if (ObjectUtils.isEmpty(sqlArray)) return Collections.emptyList();
        if (sqlArray.length <= batchSize) {
            List<String[]> list = new ArrayList<>();
            list.add(sqlArray);
            return list;
        }

        int integerPart = sqlArray.length / batchSize;
        int integerParts = integerPart * batchSize;
        int remainder = sqlArray.length % batchSize;

        int count = 0;

        List<String[]> splitList = new ArrayList<>(remainder == 0 ? integerPart : integerPart + 1);

        List<String[]> temp = new ArrayList<>(integerParts);
        for (int i = 0; i < integerPart; i++) {
            temp.clear();
            String[] batch = new String[batchSize];
            for (int j = 0; j < batchSize; j++) {
                batch[j] = sqlArray[count];
                count++;
            }
            temp.add(batch);
            splitList.addAll(temp);
        }

        String[] batch = new String[remainder];
        for (int i = 0; i < remainder; i++) {
            batch[i] = sqlArray[count];
            count++;
        }

        temp = new ArrayList<>(remainder);
        temp.add(batch);
        splitList.addAll(temp);

        return splitList;
    }

    /**
     * Deduce the number of decimals for high precision data types
     *
     * @param model The model be processed
     */
    default void deduceDecimalPrecision(ModelEntity model) {
        if (null == model || CollectionUtils.isEmpty(model.getDetails())) return;

        HighPrecisionDataHandler precisionDataHandler = SpringUtil.getBean(ContextWrapper.class).getHighPrecisionDataHandler();
        HighPrecisionDataMapper precisionDataMapper = precisionDataHandler.getHighPrecisionDataMapper();

        model.getDetails().forEach(detail -> {
            if (precisionDataMapper.getHighPrecisionDataType().compareToIgnoreCase(detail.getJavaDataType()) == 0) {
                String dbDataType = detail.getDatabaseDataType();
                String inferDataType = "";
                if (CollectionUtils.isNotEmpty(precisionDataHandler.getHighPrecisionDataConfigMap())) {
                    for (Map.Entry<String, DttProperties.HighPrecisionDataMapper.PrecisionConfigurationProperties> entry : precisionDataHandler.getHighPrecisionDataConfigMap().entrySet()) {
                        if (detail.getFiledName().toLowerCase().contains(entry.getKey())) {
                            inferDataType = detail.getDatabaseDataType() + "(" + entry.getValue().getIntegerLength() + "," + entry.getValue().getDecimalLength() + ")";
                            break;
                        }
                    }
                }
                String inferDbDataTypeWithDefaultPrecision = dbDataType + "(" + precisionDataMapper.getDefaultIntegerLength() + "," + precisionDataMapper.getDefaultDecimalLength() + ")";
                detail.setDatabaseDataType(StringUtils.defaultIfBlank(inferDataType, inferDbDataTypeWithDefaultPrecision));
            }
        });
    }

}
