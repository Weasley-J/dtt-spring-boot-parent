package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 供应商配送服务
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierDeliveryService implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 配送服务方：0 商家，1 美团
     */
    private Integer deliveryServiceProvider;

    /**
     * 服务codes，多个code用,号分割
     */
    private String deliveryServiceCodes;

    /**
     * 开始配送时间
     */
    private LocalTime startTime;

    /**
     * 结束配送时间
     */
    private LocalTime endTime;

    /**
     * 门店营业时间，HH:mm-HH:mm
     */
    private String businessHours;

    /**
     * 支付类型，0 账期支付，1 余额支付，多种类型用","分割
     */
    private String payTypes;

    /**
     * 审核状态，0 待审核，1 审核驳回，2 审核通过，3 创建成功，4 上线可发单
     */
    private Integer checkStatus;

    /**
     * 驳回原因
     */
    private String rejectMessage;

    /**
     * 开启关闭状态：0 关闭，1 开启
     */
    private Integer openStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人名称
     */
    private String createUsername;

    /**
     * 是否删除，0 否，1 是
     */
    private Integer isDel;


}
