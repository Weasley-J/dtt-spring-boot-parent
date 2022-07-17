package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品关键词审核表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */
@Data

public class ItemKeywordsApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 商品详情审核表id
     */
    private Integer itemApplyId;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
