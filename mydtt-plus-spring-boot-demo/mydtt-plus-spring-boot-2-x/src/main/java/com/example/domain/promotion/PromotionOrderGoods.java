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
 * 订单关联的促销活动的商品信息
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PromotionOrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 10 店铺券 11 平台券 0国大保险 12.永诚保险
     */
    private Integer activityType;

    /**
     * 活动表id
     */
    private Integer activityId;

    /**
     * 大会员id
     */
    private String outMemberId;

    /**
     * 规则id
     */
    private Integer ruleId;

    /**
     * 条件ID
     */
    private String conditionId;

    /**
     * 优惠券活动表id
     */
    private Integer couponId;

    /**
     * 优惠券号
     */
    private String couponNo;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 赠品及换购商品sku id
     */
    private String giveSkuId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 赠品和换购商品数量
     */
    private Integer giveGoodsNum;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 促销价
     */
    private BigDecimal activityPrice;

    /**
     * 促销优惠总金额
     */
    private BigDecimal discountAmount;

    /**
     * 1:未生效 2:已锁定 3:已失效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
