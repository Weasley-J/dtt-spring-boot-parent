package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PromotionGoodsImprotFail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * skuid
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 促销库存
     */
    private Integer activityStock;

    /**
     * 促销价
     */
    private BigDecimal activityPrice;

    /**
     * 限购
     */
    private Integer limitPurchase;

    /**
     * 失败原因
     */
    private String remark;

    /**
     * 是否删除标志
     */
    private Integer deleteFlag;


}
