package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.util.SysUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 创建数据库建表语句上层接口
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
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

}
