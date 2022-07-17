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
 * 京东退单主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderJdRefund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 京东订单id
     */
    private String jdOrderId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退单id
     */
    private Integer refundId;

    /**
     * 退单号
     */
    private String refundNo;

    /**
     * 订单商品id
     */
    private Integer orderItemId;

    /**
     * 商城sku
     */
    private String mallSkuId;

    /**
     * 京东sku
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 退单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 10退货，20换货，30维修
     */
    private Integer customerExpect;

    /**
     * 退单状态 10申请中待审核；20审核完成待收货；30收货完成待处理；40处理完成（如需退款则等待退款）；50待用户确认，60用户确认完成，70取消
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 收货地址合并省市区
     */
    private String address;

    /**
     * 买家用户ID
     */
    private Integer buyerId;

    /**
     * 购买者用户名
     */
    private String buyerName;

    /**
     * 购买者电话
     */
    private String buyerTel;

    /**
     * 退单原因
     */
    private String cancelReason;


}
