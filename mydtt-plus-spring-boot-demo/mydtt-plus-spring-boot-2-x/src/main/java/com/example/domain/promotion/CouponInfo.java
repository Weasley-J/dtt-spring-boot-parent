package com.example.domain.promotion;

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
 * 优惠券主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CouponInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券金额
     */
    private BigDecimal couponAmount;

    /**
     * 优惠券类型 1 满减劵 2 折扣券 3 现金券
     */
    private Integer couponType;

    /**
     * 优惠券平台类型 1:店铺券 2:平台券
     */
    private Integer couponPlatform;

    /**
     * 店铺id
     */
    private Integer supplierId;

    /**
     * 模块 1商城 2问诊
     */
    private Integer couponModule;

    /**
     * 优惠券发放数量
     */
    private Integer couponNum;

    /**
     * 不限数量 0 不限 1 限制
     */
    private Integer couponUnlimited;

    /**
     * 每个用户限领的张数
     */
    private Integer couponUserLimit;

    /**
     * 领劵时间
     */
    private LocalDateTime deliverBeginTime;

    /**
     * 领劵时间
     */
    private LocalDateTime deliverEndTime;

    /**
     * 生效时间类型 1指定日期 2 顺延n天
     */
    private Integer effectType;

    /**
     * 生效开始时间
     */
    private LocalDateTime effectBeginTime;

    /**
     * 生效结束时间
     */
    private LocalDateTime effectEndTime;

    /**
     * 生效顺延天数
     */
    private Integer prolongDays;

    /**
     * 领取后生效间隔
     */
    private Integer effectInternal;

    /**
     * 折扣比例
     */
    private BigDecimal discountPrecent;

    /**
     * 优惠券满减限制
     */
    private BigDecimal couponRestrictAmount;

    /**
     * 佣金点数比例
     */
    private BigDecimal commissionRate;

    /**
     * 优惠券可使用商品类型：0 全场通用 1 指定商品 2 排除指定商品
     */
    private Integer couponGoodsType;

    /**
     * 使用限制 1无限制 2科室 3医生
     */
    private Integer useRestrict;

    /**
     * 医生限制ids
     */
    private String doctorList;

    /**
     * 1--指定
     */
    private Integer specifiedPersonsPackage;

    /**
     * 优惠券状态：1 未开始 2 进行中  3 已结束
     */
    private Integer couponStatus;

    /**
     * 审核状态：1 待审核 2 审核通过 3 驳回
     */
    private Integer auditStatus;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;

    /**
     * 审核者用户名
     */
    private String auditUsername;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 剩余数量
     */
    private Integer surplusNum;

    /**
     * 领券方式 1领券 2推送
     */
    private Integer deliverWay;

    /**
     * 微信小程序跳转路径
     */
    private String wxUrl;

    /**
     * h5跳转路径
     */
    private String h5Url;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者名
     */
    private String creatorName;


}
