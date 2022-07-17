package com.example.springboot.m3.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单关联的促销活动的商品信息
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PromotionOrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    /**
     * 活动类型,1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券
     */
    private Integer activityType;

    /**
     * 活动表id
     */
    private Integer activityId;

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
     * 商品数量
     */
    private Integer goodsNum;

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
     * 创建时间
     */
    private LocalDateTime createTime;


}
