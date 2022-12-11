package com.example.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回对象
 *
 * @author weasley
 * @version 1.0
 * @date 2022/6/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageWrapper<T> implements Serializable {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 列表实体数据
     */
    private List<T> list;

    /**
     * 获取空的初始化
     *
     * @param pageNum
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> PageWrapper<T> instance(int pageNum, int pageSize) {
        PageWrapper<T> wrapper = new PageWrapper<>();
        wrapper.setPageSize(pageSize);
        wrapper.setPageNum(pageNum);
        return wrapper;
    }

    /**
     * 判断当前页是否还有数据，用于优化减少查询list
     *
     * @return
     */
    public boolean hadData() {
        return (long) (pageNum - 1) * pageSize < total;
    }
}
