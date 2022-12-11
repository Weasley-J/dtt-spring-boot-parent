package com.example.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * OMS B2B订单商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsB2bOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

//    /**
//     * 第三方平台子订单编号,若没有拆单为第三方平台订单编号
//     */
//    private String thirdOrderItemNo;

    /**
     * 外部商品编码
     */
    private String outSkuId;

    /**
     * 外部商品名称
     */
    private String outSkuName;

    /**
     * wms批次号
     */
    private String wmsBatchNo;

    /**
     * 有效期止
     */
    private LocalDateTime endTime;

    /**
     * 生产批次号
     */
    private String productBatchNo;

    /**
     * 库存数量
     */
    private Integer stockNum;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 销售价格
     */
    private BigDecimal retailPrice;

    /**
     * 出库数量
     */
    private Integer outStockNum;

    /**
     * 生产时间
     */
    private LocalDateTime productionTime;

    /**
     * 供应商id
     */
    private String supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商全称
     */
    private String supplierFullName;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 批准文号
     */
    private String approvalNumber;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 物料分类
     */
    private String classification;

    /**
     * 简写
     */
    private String abbrName;

    /**
     * 规格型号
     */
    private String goodsSpec;

    /**
     * 包装规格
     */
    private String packingSpec;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 税额
     */
    private BigDecimal taxAmount;

    /**
     * 不含税单价
     */
    private BigDecimal taxExcludedUnitPrice;

    /**
     * 采购价
     */
    private BigDecimal purchasePrice;

}
