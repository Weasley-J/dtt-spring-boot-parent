package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品关键词
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsKeywords implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
