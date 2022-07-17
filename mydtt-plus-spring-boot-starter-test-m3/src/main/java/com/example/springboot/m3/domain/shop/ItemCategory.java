package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品后台类目表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemCategory implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 后台类目名称
     */
    private String categoryName;

    /**
     * 类目级别 1 一级类目 2 二级类目 3 三级
     */
    private Integer level;

    /**
     * 父类类目
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 状态 1 启用 0 禁用
     */
    private Integer categoryStatus;

    /**
     * 状态 0:未配置,1:已配置
     */
    private Integer taxSetStatus;

    /**
     * 操作人
     */
    private String operatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
