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
 *
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SkuPromotionPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * skuID
     */
    private String skuId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 库存
     */
    private Integer promotionStock;

    /**
     * 活动开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 活动结束时间
     */
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 这个商家参加的最优活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 10 店铺券 11 平台券 0国大保险
     */
    private Integer activityType;

    /**
     * 这个商家参加的所有活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 10 店铺券 11 平台券 0国大保险
     */
    private String activityTypes;
}
