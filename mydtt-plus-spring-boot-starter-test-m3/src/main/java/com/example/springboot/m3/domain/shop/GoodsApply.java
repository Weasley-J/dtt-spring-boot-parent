package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品入库申请表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

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
     * 商品状态：1 启用 2 禁用
     */
    private Integer goodsStatus;

    /**
     * OTC类别 1 甲类OTC 2 乙类OTC
     */
    private Integer otcType;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 国药准字
     */
    private String medicineStandard;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 医生开处方 1 可以开处方 0 不可以开处方
     */
    private Integer enableRx;

    /**
     * 处方药类型
     */
    private Integer rxType;

    /**
     * 显示方式 0 不显示 1 线上
     */
    private Integer showType;

    /**
     * 药品名
     */
    private String drugName;

    /**
     * 是否万邦药 0 不是， 1 是
     */
    private Integer wbDrug;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它
     */
    private Integer goodsKind;

    /**
     * 医疗批注号
     */
    private String medicalNo;

    /**
     * 佣金点数
     */
    private BigDecimal commission;

    /**
     * 列表的主图
     */
    private String mainPic;

    /**
     * 外部部门
     */
    private String outDept;

    /**
     * 外部sku id
     */
    private String outSkuId;

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
     * 邦指数
     */
    private BigDecimal bangPrice;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 审核状态: 1 审核中 2 审核通过 3 拒绝 4 待审核
     */
    private Integer auditStatus;

    /**
     * 审核人
     */
    private String auditUsername;

    /**
     * 审核拒绝原因
     */
    private String auditReason;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;


}
