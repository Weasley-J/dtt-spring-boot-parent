package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 促销活动的商品
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityPromotionGoods implements Serializable {

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
     * 规则id
     */
    private Integer ruleId;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 促销价
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private BigDecimal activityPrice;

    /**
     * 促销库存
     */
    private Integer activityStock;

    /**
     * 限购
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer limitPurchase;

    /**
     * 列表的主图
     */
    private String mainPic;

    /**
     * 促销使用库存
     */
    private Integer usedStock;

    /**
     * 是否失效 1 失效 0 不失效
     */
    private Integer invalidFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 商品分类
     */
    private Integer goodsKind;


}
