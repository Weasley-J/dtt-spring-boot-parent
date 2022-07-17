package com.example.springboot.m3.domain.user;

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
 * 卡片表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsCardInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 卡模板id
     */
    private Integer assetsCardTemplateId;

    /**
     * 制卡批次id
     */
    private Integer assetsCardMakeRecordId;

    /**
     * 卡基础类型 0 常规卡 1 礼品卡
     */
    private Integer baseType;

    /**
     * 0 实体卡，1 电子卡
     */
    private Integer cardType;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 卡密
     */
    private String cardKey;

    /**
     * 0 待激活 1 已激活 2 已失效（过期）  4 已作废（退款）  6 已作废（手动）  7 待分发 8 已锁定（下单锁定）
     */
    private Integer cardStatus;

    /**
     * 卡面值
     */
    private BigDecimal cardFaceAmount;

    /**
     * 0 默认值 1 退款中
     */
    private Integer refundStatus;

    /**
     * 锁定源 0 下单锁定
     */
    private String lockSource;

    /**
     * 卡锁定唯一编号（如订单号）
     */
    private String lockNo;

    /**
     * 绑定用户id
     */
    private String bindOutMemberId;

    /**
     * 绑定用户手机号(锁定人)
     */
    private String bindUserTel;

    /**
     * 绑定时间
     */
    private LocalDateTime bindTime;

    /**
     * 激活有效期开始时间
     */
    private LocalDateTime activateBeginTime;

    /**
     * 激活有效期结束时间
     */
    private LocalDateTime activateEndTime;

    /**
     * 激活时间
     */
    private LocalDateTime activateTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
