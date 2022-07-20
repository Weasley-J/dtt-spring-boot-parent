package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.util.SysUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

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
        if (CollectionUtils.isEmpty(modelSet)) {
            return null;
        }
        return StringUtils.join(modelSet.parallelStream().map(this::create).collect(Collectors.toList()), SysUtil.getLineSeparator());
    }
}
