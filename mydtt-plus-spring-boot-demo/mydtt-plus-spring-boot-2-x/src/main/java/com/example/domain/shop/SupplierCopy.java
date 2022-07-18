package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 供应商管理
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierCopy implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 简称
     */
    private String abbrName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 是否自营 0 非自营 1 自营
     */
    private Integer selfFlag;

    /**
     * 资质照片1
     */
    private String qualificationOne;

    /**
     * 资质照片2
     */
    private String qualificationTwo;

    /**
     * 来源 1商 城 2疫苗 3药店云
     */
    private Integer source;

    /**
     * 平台佣金比例(%)
     */
    private BigDecimal commission;

    /**
     * 店铺分佣比列(%)
     */
    private BigDecimal supplierCommission;

    /**
     * 状态 0 禁用 1 启用
     */
    private Integer enable;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createUsername;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 父级经销商
     */
    private Integer parentId;

    /**
     * 入驻实体类型 0 连锁店 1门店 2医院
     */
    private Integer supplierType;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 客服电话
     */
    private String serviceTelephone;

    /**
     * 邦甸园商户id
     */
    private Integer bdySupplierId;

    /**
     * 纳税人识别号(个人为NULL)
     */
    private String customerCode;

    /**
     * 销货方id
     */
    private Integer invoiceTaxpayerId;

    /**
     * 商家类型 0 其他  1 MP  2 入仓  3 DSV
     */
    private Integer merchantType;

    /**
     * 包邮订单金额
     */
    private BigDecimal freeCarriageAmount;

    /**
     * logo图片
     */
    private String logoUrl;

    /**
     * 店铺简介
     */
    private String introduction;

    /**
     * 审核状态 0-未开户 1-审批中 2-审批成功 3-审批失败 4-待签约 5-签约审核中 6-签约失败
     */
    private Integer applyStatus;

    /**
     * 审核备注
     */
    private String applyRemark;

    /**
     * 快钱订单号
     */
    private String applyNo;

    /**
     * 快钱商户编码
     */
    private String merchantCode;

    /**
     * 快钱平台编码
     */
    private String memberCode;

    /**
     * 快钱商户标识
     */
    private String pfpmCode;

    /**
     * 业务标识 1保险 2云DTP 3一体化DTP 4国大保险 5永诚保险
     */
    private Integer businessFlag;

    /**
     * 是否支持保险业务 1:支持
     */
    private Integer bxFlag;

    /**
     * 是否支持云DTP业务 1:支持
     */
    private Integer dtpFlag;

    /**
     * o2o业务-省code码
     */
    private Integer o2oProvinceCode;

    /**
     * o2o业务-省名称
     */
    private String o2oProvince;

    /**
     * o2o业务-市code码
     */
    private Integer o2oCityCode;

    /**
     * o2o业务-市名称
     */
    private String o2oCity;

    /**
     * o2o业务-区code码
     */
    private Integer o2oDistrictCode;

    /**
     * o2o业务-区名称
     */
    private String o2oDistrict;

    /**
     * o2o业务-详细地址
     */
    private String o2oAddress;

    /**
     * 营业时间 HH:mm-HH:mm
     */
    private String businessHours;

    /**
     * 销售方式(用于药店云连锁店) 1直销 2代销
     */
    private Integer saleType;

    /**
     * 库存预警阈值
     */
    private Integer stockWarning;


}
