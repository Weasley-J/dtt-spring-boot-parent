package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 规格表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemSpecDict implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 规格值数量
     */
    private Integer valueCount;

    /**
     * 状态 1 启用 0 禁用
     */
    private Integer specStatus;

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
