package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品图片
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsPic implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * 图片类型：1、展示图片 2、产品介绍 3、其他
     */
    private Integer picType;

    /**
     * 图片url
     */
    private String picUrl;

    private String outSkuId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 区域编码
     */
    private String areaCode;


}
