package com.example.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class OmsEffectivePlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 生效平台id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规则id
     */
    private Integer ruleId;

    /**
     * 店铺id
     */
    private Integer supplierId;

    /**
     * 商品集合
     */
    private String skuIds;

    /**
     * 生效平台  0 全部平台  1 复星商城  2 京东  3 宝宝树  4 天猫   5 快手    6 抖音    9 星选
     */
    private Integer effectivePlatform;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;


}
