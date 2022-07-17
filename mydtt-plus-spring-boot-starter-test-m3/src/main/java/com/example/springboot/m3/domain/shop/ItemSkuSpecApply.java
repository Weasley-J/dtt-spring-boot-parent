package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 预商品库sku规格表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemSkuSpecApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 预商品库sku表主键
     */
    private Integer skuApplyId;

    /**
     * 规格表主键
     */
    private Integer specId;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 规格值表主键
     */
    private Integer specValueId;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 规格图片
     */
    private String picUrl;


}
