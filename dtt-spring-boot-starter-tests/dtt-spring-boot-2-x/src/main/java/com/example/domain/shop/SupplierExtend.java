package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 商家扩展信息
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierExtend implements Serializable {

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
     * 经营范围
     */
    private String businessScope;

    /**
     * 营业执照类型 1-统一社会信用代码  2-营业执照注册号 3 非营业执照（含事业单位法人证等）4 事业单位法人证书 5 民办非企业单位登记证书 6 社会团体法人登记证书 7 其他
     */
    private Integer businessLicenseType;

    /**
     * 证照图片
     */
    private String certificatePicUrl;

    /**
     * 证照有效起始时间
     */
    private LocalDate certificateValidStartTime;

    /**
     * 证照有效结束时间
     */
    private LocalDate certificateValidEndTime;

    /**
     * 证照编码
     */
    private String certificateCode;

    /**
     * 企业全称
     */
    private String enterpriseFullName;

    /**
     * 企业类型 1-有限责任公司 2-股份有限公司 3-私营合伙企业 4-私营独资企业 5-个体工商户 6-非公司企业法人
     */
    private Integer enterpriseType;

    /**
     * 入驻邮箱
     */
    private String inboundEmail;

    /**
     * 经营地址-省code码
     */
    private Integer businessAddressProvinceCode;

    /**
     * 经营地址-市code码
     */
    private Integer businessAddressCityCode;

    /**
     * 经营地址-区code码
     */
    private Integer businessAddressDistrictCode;

    /**
     * 经营地址-省名称
     */
    private String businessAddressProvince;

    /**
     * 经营地址-市名称
     */
    private String businessAddressCity;

    /**
     * 经营地址-区名称
     */
    private String businessAddressDistrict;

    /**
     * 经营地址-详细地址名称
     */
    private String businessAddressDetail;

    /**
     * 经营地址-经度
     */
    private String businessAddressLng;

    /**
     * 经营地址-纬度
     */
    private String businessAddressLat;

    /**
     * 经营场所内照片
     */
    private String businessLocationPicUrl;

    /**
     * 经营场所门头照片
     */
    private String businessLocationHeadPicUrl;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 法人手机号
     */
    private String legalMobileNumber;

    /**
     * 法人身份证号码
     */
    private String legalIdCardNumber;

    /**
     * 法人身份证有效期起始时间
     */
    private LocalDate legalIdCardValidStartTime;

    /**
     * 法人身份证有效期结束时间
     */
    private LocalDate legalIdCardValidEndTime;

    /**
     * 法人身份证正面照片
     */
    private String legalIdCardFrontPicUrl;

    /**
     * 法人身份证反面照片
     */
    private String legalIdCardBackPicUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
