package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商户线下优惠白名单
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierOfflineDiscountWhitelist implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 商户id
     */
    private Integer supplierId;

    /**
     * 商户名称
     */
    private String supplierName;

    /**
     * 国大门店编码
     */
    private String gdSupplierCode;

    /**
     * 店员手机号
     */
    private String tel;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
