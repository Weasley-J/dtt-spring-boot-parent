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
import java.time.LocalDateTime;

/**
 * <p>
 * OMS出入库表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderWms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号/退货单号
     */
    private String orderNo;

    /**
     * 对接仓库类型 1.出库 2.入库
     */
    private Integer wmsType;

    /**
     * 出入库单号
     */
    private String wmsOrderNo;

    /**
     * 仓库id
     */
    private String wmsWarehouseId;

    /**
     * 仓库名称
     */
    private String wmsWarehouseName;

    /**
     * 出入库状态 1.待出库 2.出库中 3.已出库 4.出库取消 11.待仓库收货 12.仓库已收货 13.仓库审核完成 14.入库取消
     */
    private Integer wmsStatus;

    /**
     * 出库入库完成时间
     */
    private LocalDateTime wmsFinishTime;

    /**
     * 推送第三方异常原因
     */
    private String pushExceptionReason;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 推送中宝状态 0.无需推送 1.待推送 2.推送成功 3.推送失败
     */
    private Integer pushZbStatus;

    /**
     * 订单类型 1:普通订单 2:b2b
     */
    private Integer orderType;

    /**
     * 是否代发 0:否 1：是
     */
    private Integer sendFlag;

    /**
     * 采购订单号
     */
    private String purchaseOrderNo;

    /**
     * 代发供应商
     */
    private String sendSupplierCode;

    /**
     * 代发供应商名称
     */
    private String sendSupplierName;

    /**
     * 采退单号
     */
    private String purchaseRefundNo;
    /**
     * 出库单取消原因
     */
    private String cancelReason;
}
