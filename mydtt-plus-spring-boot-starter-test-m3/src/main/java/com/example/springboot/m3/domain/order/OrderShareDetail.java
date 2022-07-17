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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单抵扣分摊明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderShareDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 使用类型 0 下单，1 退款
     */
    private Integer usageType;

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
    private Integer refundOrderId;

    /**
     * 退单号
     */
    private String refundOrderNo;

    /**
     * 支付交易单号
     */
    private String payNo;

    /**
     * 子订单id
     */
    private Integer orderItemId;

    /**
     * skuid
     */
    private String skuId;

    /**
     * 实购/实退商品数量
     */
    private Integer skuNum;

    /**
     * 0 商品分摊 1 运费分摊
     */
    private Integer shareType;

    /**
     * 分摊费用类型 2 礼品卡 3 优医币 4 邦指数 5 星喜积分 6 永城保险 7 国大保险 18 权益抵扣
     */
    private Integer shareBillType;

    /**
     * 分摊金额
     */
    private BigDecimal shareAmount;

    /**
     * 分摊主体数量 （如优医币数量，帮指数数量）
     */
    private BigDecimal shareQuantity;

    /**
     * 分摊主体, 礼品卡卡号
     */
    private String shareDomainKey;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
