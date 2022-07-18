package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品导入失败数据表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-26
 */
@Data

public class GoodsImportFail implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 简称
     */
    private String abbrName;

    /**
     * 外部sku id
     */
    private String outSkuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * skuId
     */
    private String skuId;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品单位：盒、袋
     */
    private String goodsUnit;

    /**
     * OTC类别 1 甲类OTC 2 乙类OTC
     */
    private Integer otcType;

    /**
     * 国药准字
     */
    private String medicineStandard;

    /**
     * 医疗批注号
     */
    private String medicalNo;

    /**
     * 外部部门
     */
    private String outDept;

    /**
     * 一级类目
     */
    private String outCategoryOne;

    /**
     * 二级类目
     */
    private String outCategoryTwo;

    /**
     * 三级类目
     */
    private String outCategoryThree;

    /**
     * 商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它
     */
    private Integer goodsKind;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 佣金点数
     */
    private BigDecimal commission;

    /**
     * 失败原因
     */
    private String remark;


    private Integer deleteFlag;

    private Integer drugId;

    private BigDecimal bangPrice;

    /**
     * 0,运营后台 1,商家后台
     */
    private Integer importType;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 留存比例
     */
    private BigDecimal retainPercent;

    /**
     * 关系比例
     */
    private BigDecimal relatePercent;

    /**
     * itemId
     */
    private Integer itemId;


}
