package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品通用名黑名单
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemCommonNameBlacklist implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 通用名名称
     */
    private String commonName;

    /**
     * 状态 0 未删除 1 删除
     */
    private Integer deleteFlag;

    /**
     * 操作人
     */
    private String operatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
