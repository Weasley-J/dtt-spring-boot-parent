package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 预商品库sku表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemSkuApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * itemId
     */
    private Integer itemApplyId;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 规格描述
     */
    private String skuSpec;

    /**
     * 包装规格
     */
    private String packingSpec;

    /**
     * 外部商品编码(规格编码)
     */
    private String outSkuId;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 规格图片
     */
    private String picUrl;

    /**
     * 权益包ID
     */
    private String assetPackageId;

    /**
     * 权益卡ID
     */
    private String assetCardId;

    /**
     * 邦指数
     */
    private BigDecimal bangPrice;

    /**
     * 留存比例 X%
     */
    private BigDecimal retainPercent;

    /**
     * 关系比例 X%
     */
    private BigDecimal relatePercent;

    /**
     * 收益类型 1-收益值 2-收益比列
     */
    private Integer earningsType;

    /**
     * 收益
     */
    private BigDecimal earnings;


    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 是否需要收货地址 0-不需要 1-需要
     */
    private Integer deliveryAddressRequired;

    /**
     * 跳转链接
     */
    private String skuUrl;

    /**
     * 税收分类编码
     */
    private String taxCode;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 零税率标识 1:免税 2:不征税 3:普通零税率
     */
    private Integer zeroTaxMark;

    /**
     * 优惠政策标识 1:使用 0:不使用
     */
    private Integer policyTaxMark;

    /**
     * 政策标识名称
     */
    private String policyName;

    /**
     * 部门编号
     */
    private String departmentNo;

    /**
     * 是否组合商品 1是 0否
     */
    private Integer assortedFlag;


}
