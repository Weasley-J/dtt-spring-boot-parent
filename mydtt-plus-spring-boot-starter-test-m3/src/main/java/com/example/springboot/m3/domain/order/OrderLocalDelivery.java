package com.example.springboot.m3.domain.order;

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
import java.time.LocalTime;

/**
 * <p>
 * 同城配送信息
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderLocalDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单商品id
     */
    private Integer orderItemId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 配送员姓名
     */
    private String deliverymanName;

    /**
     * 配送员电话
     */
    private String deliverymanTel;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiverTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 配送服务方：0 商户，1 美团
     */
    private Integer deliveryServiceProvider;

    /**
     * 配送服务包code
     */
    private String deliveryServiceCode;

    /**
     * 配送状态：0 待商家接单，1 待骑手接单，2 待骑手取货，3 配送中，4 已完成，5 订单异常，6 已取消
     */
    private Integer deliveryStatus;

    /**
     * 配送异常信息
     */
    private String deliveryException;

    /**
     * 预计送达时间
     */
    private LocalTime predictDeliveryTime;

    /**
     * 配送单号
     */
    private Long deliveryNum;

    /**
     * 配送外部订单id
     */
    private String deliveryOuterId;


}
