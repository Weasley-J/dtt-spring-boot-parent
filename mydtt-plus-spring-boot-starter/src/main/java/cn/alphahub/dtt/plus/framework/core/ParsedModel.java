package cn.alphahub.dtt.plus.framework.core;

/**
 * Parse Result
 *
 * @param <T> Result
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface ParsedModel<T> {
    /**
     * 获取表结构元数据解析结果
     *
     * @return 表结构元数据解析结果
     */
    T getModel();
}
