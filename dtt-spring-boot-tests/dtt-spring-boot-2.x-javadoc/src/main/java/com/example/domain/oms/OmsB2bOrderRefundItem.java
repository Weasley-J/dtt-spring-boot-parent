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
 * OMS b2b退单子表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsB2bOrderRefundItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 退货单id
     */
    private Integer orderRefundId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * oms_b2b_order_item主键id
     */
    private Integer orderItemId;

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
     * 生产时间
     */
    private LocalDateTime productionTime;

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
     * 退货数量
     */
    private Integer refundStockNum;

    /**
     * 实际入库数量
     */
    private Integer refundRealStockNum;

    /**
     * 供应商id(代发)
     */
    private String supplierId;

    /**
     * 供应商名称（代发）
     */
    private String supplierName;

    /**
     * 供应商全称（代发）
     */
    private String supplierFullName;

    /**
     * 商品条码(代发)
     */
    private String barCode;

    /**
     * 批准文号(代发)
     */
    private String approvalNumber;

    /**
     * 生产厂家(代发)
     */
    private String manufacturer;

    /**
     * 简写(代发)
     */
    private String abbrName;

    /**
     * 物料分类
     */
    private String classification;

    /**
     * 规格型号（代发）
     */
    private String goodsSpec;

    /**
     * 包装规格(代发)
     */
    private String packingSpec;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

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


}
