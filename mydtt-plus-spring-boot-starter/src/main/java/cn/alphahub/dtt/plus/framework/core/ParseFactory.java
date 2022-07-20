package cn.alphahub.dtt.plus.framework.core;

/**
 * Parse result
 *
 * @param <T> Result
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface ParseFactory<T> {
    /**
     * 获取表结构元数据解析结果
     *
     * @return 表结构元数据解析结果
     */
    T getModel();
}
