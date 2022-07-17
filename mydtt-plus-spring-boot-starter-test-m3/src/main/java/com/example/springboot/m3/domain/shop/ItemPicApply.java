package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品图片申请表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemPicApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * item id
     */
    private Integer itemApplyId;

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


}
