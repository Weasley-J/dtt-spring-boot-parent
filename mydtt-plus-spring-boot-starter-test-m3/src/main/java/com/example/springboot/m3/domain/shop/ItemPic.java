package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 商品图片表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemPic implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * item id
     */
    private Integer itemId;

    /**
     * 图片类型：1、展示图片 2、产品介绍 3、其他
     */
    private Integer picType;

    /**
     * 图片url
     */
    private String picUrl;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * out_sku_id
     */
    private String outSkuId;

    /**
     * 区域编码
     */
    private String areaCode;


}
