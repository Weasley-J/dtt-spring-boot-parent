package com.example.springboot.m3.domain.promotion;

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
 * 活动动作规则表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityActionRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 适用行为类型 1:特价秒杀 2:加购特价 3:减免 4:折扣 5:赠送商品
     */
    private Integer actionRuleType;

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
