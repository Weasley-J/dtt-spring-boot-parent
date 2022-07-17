package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 外部商品同步记录
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-28
 */
@Data

public class GoodsOuter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */

    private Long id;

    /**
     * 外部渠道code 1：京东
     */
    private Integer outerCode;

    /**
     * 外部渠道名称
     */
    private String outerName;

    /**
     * 外部商品sku
     */
    private String outerSkuId;

    /**
     * 商城零售价
     */
    private BigDecimal mallRetailPrice;

    /**
     * 商城进货价
     */
    private BigDecimal mallPurchasePrice;

    /**
     * goods同步状态 0待同步 1成功 -1失败
     */
    private Integer syncFlag;

    /**
     * body
     */
    private String body;

    /**
     * 版本
     */
    private String version;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
