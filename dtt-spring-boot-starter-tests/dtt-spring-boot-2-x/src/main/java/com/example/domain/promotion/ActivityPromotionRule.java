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
 * 满减活动规则
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityPromotionRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动表id
     */
    private Integer activityId;

    /**
     * 活动类型：1 满减 2 满打折 3 秒杀活动 4 满优 5 特价
     */
    private Integer activityType;

    /**
     * 开始时间
     */
    private LocalDateTime seckillBeginTime;

    /**
     * 结束时间
     */
    private LocalDateTime seckillEndTime;

    /**
     * 持续时间 分钟
     */
    private Integer seckillDuration;

    /**
     * 订单满多少金额
     */
    private BigDecimal orderAmount;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 折扣比例
     */
    private BigDecimal discountPrecent;

    /**
     * 优惠金额
     */
    private BigDecimal promotionAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
