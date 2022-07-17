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
 * OMS b2b退单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsB2bOrderRefund implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退货单号
     */
    private String refundNo;

    /**
     * 是否整单退 1:是 0:否
     */
    private Integer wholeRefund;

    /**
     * 代发标志 0-否 1-是
     */
    private Integer issuingFlag;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 仓库名称
     */
    private String warehouseName;

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
     * 售后状态 1.待下发仓库 2.待仓库收货 3.仓库已收货 4.仓库收货完成 5.退货取消 6完成(针对代发订单,直接完成)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 运费
     */
    private BigDecimal carriageAmount;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付方式 1.对现结 2.货到付款
     */
    private Integer payType;

    /**
     * 原订单收货地址合并省市区
     */
    private String address;

    /**
     * 客户名称
     */
    private String buyerName;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverTel;

    /**
     * 退单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 退单原因
     */
    private String cancelReason;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
