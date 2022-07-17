package com.example.springboot.m3.domain.oms;

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
 * OMS出入库明细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderWmsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号/退货单号
     */
    private String orderNo;

    /**
     * 订单商品id
     */
    private Integer orderItemId;

    /**
     * 出入库单id
     */
    private Integer wmsOrderId;

    /**
     * 出入库单号
     */
    private String wmsOrderNo;

    /**
     * 对接仓库类型 1.出库写入 2.入库 3.出库回调
     */
    private Integer wmsType;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 规格编码
     */
    private String outSkuId;

    /**
     * 应发数量
     */
    private Integer quantity;

    /**
     * 实发数量
     */
    private Integer realQuantity;

    /**
     * 物流公司code
     */
    private String expressCode;

    /**
     * 物流公司名称
     */
    private String expressCompany;

    /**
     * 快递单号
     */
    private String invoiceNo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * wms供应商id（出库回调返回）
     */
    private String wmsSupplierId;

    /**
     * 采购价格（出库回调返回）
     */
    private BigDecimal purchasePrice;

    /**
     * 交易数量（出库回调返回）
     */
    private Integer transactionQty;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 单个商品实付金额
     */
    private BigDecimal actuallyPaidSingleAmount;

    /**
     * 实付总金额
     */
    private BigDecimal actuallyPaidTotalAmount;


    /**
     * 渠道部门
     */
    private String departmentChannel;
}
