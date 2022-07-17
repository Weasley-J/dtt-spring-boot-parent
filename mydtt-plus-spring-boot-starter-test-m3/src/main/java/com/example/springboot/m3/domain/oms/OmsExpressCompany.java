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
import java.time.LocalDateTime;

/**
 * <p>
 * OMS物流公司表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsExpressCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物流公司code（快递100）
     */
    private String expressCode;

    /**
     * 物流公司名称
     */
    private String expressCompany;

    /**
     * 物流公司code（wms）
     */
    private String expressCodeWms;

    /**
     * wms面单类型
     */
    private String wmsWayBill;

    /**
     * wms面单类型值
     */
    private String wmsWayBillValue;

    /**
     * 宝宝树物流公司code
     */
    private String bbsExpressCode;

    /**
     * 宝宝树物流公司名称
     */
    private String bbsExpressCompany;

    /**
     * 京东物流公司code
     */
    private String jdExpressCode;

    /**
     * 京东物流公司名称
     */
    private String jdExpressCompany;

    /**
     * 天猫物流公司code
     */
    private String tmExpressCode;

    /**
     * 天猫物流公司名称
     */
    private String tmExpressCompany;

    /**
     * 机构code
     */
    private String orgCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 云健康，云药房相通快递统一id
     */
    private Integer omsCompanyUnique;

    /**
     * 是否启用 1-启用 0-不启用
     */
    private Integer enableFlag;

    /**
     * 拼多多快递编码
     */
    private String pddExpressCode;

    /**
     * 拼多多快递公司名称
     */
    private String pddExpressCompany;

    /**
     * 拼多多快递id
     */
    private Integer pddExpressId;
}
