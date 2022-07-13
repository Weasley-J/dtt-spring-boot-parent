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
 * 活动条件商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 条件规则id
     */
    private Integer conditionRuleId;

    /**
     * 动作规则id
     */
    private Integer actionRuleId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 促销价
     */
    private BigDecimal activityPrice;

    /**
     * 促销库存
     */
    private Integer activityStock;

    /**
     * 促销使用库存
     */
    private Integer usedStock;

    /**
     * 限购
     */
    private Integer limitPurchase;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
