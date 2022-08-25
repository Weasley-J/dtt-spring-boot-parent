package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 商家账户信息
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 商家id
     */
    private Integer supplierId;

    /**
     * 结算账户类型 0 企业 1 法人 2 授权人 3对公授权人
     */
    private Integer accountType;

    /**
     * 账户类别：1、进件；2、提现
     */
    private Integer accountCategory;


    /**
     * 经营类目编码
     */
    private Integer billCategoryCode;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 支行全称
     */
    private String bankBranchFullName;

    /**
     * 开户行-省code码
     */
    private Integer bankProvinceCode;

    /**
     * 开户行-市code码
     */
    private Integer bankCityCode;

    /**
     * 开户行-区code码
     */
    private Integer bankDistrictCode;

    /**
     * 开户行-省名称
     */
    private String bankProvinceName;

    /**
     * 开户行-市名称
     */
    private String bankCityName;

    /**
     * 开户行-区名称
     */
    private String bankDistrictName;

    /**
     * 开户凭证有效起始时间
     */
    private LocalDate openPeriodBeginTime;

    /**
     * 开户凭证有效结束时间
     */
    private LocalDate openPeriodEndTime;

    /**
     * 开户凭证图片
     */
    private String accountOpenVoucherPicUrl;

    /**
     * 银行预留手机号
     */
    private String reservedTel;

    /**
     * 提现手机号码
     */
    private String withdrawTel;

    /**
     * 提现账户预留金额
     */
    private BigDecimal withdrawReserveAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
