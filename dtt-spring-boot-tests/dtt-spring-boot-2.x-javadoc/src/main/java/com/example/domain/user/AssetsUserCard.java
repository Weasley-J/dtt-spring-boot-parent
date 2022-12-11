package com.example.domain.user;

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
 * 用户卡
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsUserCard implements Serializable {

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
     * assets_card_instance表id
     */
    private Integer assetsCardInstanceId;

    /**
     * 0 常规卡 1 礼品卡
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
     * 0 待激活 1 已激活 2 已失效（过期）   4 已作废（退款）  5转增失效 6 已作废（手动） 9 已使用（面额全部使用或权益全部核销）
     */
    private Integer cardStatus;

    /**
     * 卡面值
     */
    private BigDecimal cardFaceAmount;

    /**
     * 卡剩余面值（前端展示金额=surplus_amount-lock_amount）
     */
    private BigDecimal surplusAmount;

    /**
     * 锁定金额
     */
    private BigDecimal lockAmount;

    /**
     * 0 默认值 1 退款中
     */
    private Integer refundStatus;

    /**
     * 绑定用户id
     */
    private String bindOutMemberId;

    /**
     * 绑定用户手机号
     */
    private String bindUserTel;

    /**
     * 是否可以转增 0 否 1 可以
     */
    private Integer canShift;

    /**
     * 当前卡是否已经转增 0 否 1 是
     */
    private Integer cardShifted;

    /**
     * 是否是原始卡 0 转增卡  1 原始卡
     */
    private Integer originCard;

    /**
     * 原始卡是否转增过 0 否 1 是
     */
    private Integer originCardShift;

    /**
     * 绑定时间
     */
    private LocalDateTime bindTime;

    /**
     * 使用有效期开始时间
     */
    private LocalDateTime useBeginTime;

    /**
     * 使用有效期结束时间
     */
    private LocalDateTime useEndTime;

    /**
     * 激活有效期开始时间
     */
    private LocalDateTime activateBeginTime;

    /**
     * 激活有效期结束时间
     */
    private LocalDateTime activateEndTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * 渠道id
     */
    private String globalChannelId;
}
