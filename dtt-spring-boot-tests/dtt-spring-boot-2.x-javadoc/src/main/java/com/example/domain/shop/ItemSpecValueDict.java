package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 规格值表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemSpecValueDict implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 规格ID
     */
    private Integer specId;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 删除状态，  0 未删除 1 已删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
