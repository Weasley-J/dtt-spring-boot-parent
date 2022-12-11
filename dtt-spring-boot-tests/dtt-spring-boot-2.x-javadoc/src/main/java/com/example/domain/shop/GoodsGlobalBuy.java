package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 全球购商品扩展表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsGlobalBuy implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * itemNo=货号=料号=SKU
     */
    private String itemNo;

    /**
     * 备案商品料号=序号：itemRecoreNo
     */
    private String itemRecoreNo;

    /**
     * 规格型号
     */
    private String gmodel;

    /**
     * 产销国(地区)
     */
    private String country;

    /**
     * 申报计量单位
     */
    private String uit;

    /**
     * 法定计量单位
     */
    private String unitCus1;

    /**
     * 第二法定计量单位
     */
    private String unitCus2;

    /**
     * 法定数量
     */
    private BigDecimal qty1;

    /**
     * 第二法定数量
     */
    private BigDecimal qty2;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
