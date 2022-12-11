package com.example.domain.order;

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
 * 订单关联促销表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * order表id
     */
    private Integer orderId;

    /**
     * 外部促销id，由促销系统提供
     */
    private String promotionId;

    /**
     * 促销类型，由促销系统提供0优惠券，1活动，2国大保险，3永诚保险，4积分，5优惠码
     */
    private Integer promotionType;

    /**
     * 促销名称，由促销系统提供
     */
    private String promotionName;

    /**
     * 促销优惠金额
     */
    private BigDecimal promotionDiscountAmount;

    /**
     * 促销描述信息，由促销系统提供
     */
    private String promotionDescription;

    /**
     * 促销券码，由促销系统提供
     */
    private String promotionNo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 促销平台
     */
    private Integer platformId;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 优惠券平台类型 默认1:店铺券，2:平台券
     */
    private Integer couponPlatform;

    /**
     * 促销子类型 优惠券类型 1 满减劵 2 折扣券 3 现金券, 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 0国大保险 12永诚保险 13健康积分 14优惠码
     */
    private Integer promotionSubType;

    /**
     * 促销子类型名称
     */
    private String promotionSubTypeName;


}
