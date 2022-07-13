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
 * 活动条件规则表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityConditionRule implements Serializable {

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
     * 条件类型：1:用户 2:行为
     */
    private Integer ruleType;

    /**
     * 适用行为类型 1:购买 2:浏览
     */
    private Integer conditionRuleType;

    /**
     * 1:全场通用 2:指定商品 3:排除商品
     */
    private Integer activityGoodsType;

    /**
     * 购买数量最小值
     */
    private Integer buyMinNum;

    /**
     * 购买数量最大值
     */
    private Integer buyMaxNum;

    /**
     * 购买最小金额
     */
    private BigDecimal buyMinAmount;

    /**
     * 购买最大金额
     */
    private BigDecimal buyMaxAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
