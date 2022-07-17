package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 快钱签约
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierBillContract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 供应商ID
     */
    private Integer supplierId;

    /**
     * 签约订单号
     */
    private String applyId;

    /**
     * 0：待签约；1：签约成功；2 签约拒绝；3 快钱账户待激活 4.合同生成，待转 PDF 6.签约中 7.签约失败 -1.未生成合同
     */
    private Integer signStatus;

    /**
     * 签约时间
     */
    private LocalDateTime submitDate;

    /**
     * 合同有效期起始时间
     */
    private LocalDateTime startDate;

    /**
     * 合同有效期截止时间
     */
    private LocalDateTime endDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
