package com.example.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 预商品库全球购附属表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemSkuExtendApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 对应sku主键
     */
    @TableId(value = "id", type = IdType.INPUT)
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
     * 商品用途编号
     */
    private String usageCode;

    /**
     * 原产国编码
     */
    private String originalCountry;

    /**
     * HS编码
     */
    private String hsCode;


}
