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
 * 订单支付
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderPaymentLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 支付状态: 1 待支付，2 支付成功 3 支付失败
     */
    private Integer paymentStatus;

    /**
     * 付款时间
     */
    private LocalDateTime paymentDate;

    /**
     * 订单交易流水号
     */
    private String orderTransactionNumber;

    /**
     * 交易流水号
     */
    private String transactionNumber;

    /**
     * 收付类型0现金，1虚拟
     */
    private Integer payType;

    /**
     * 收付子类型
     */
    private String payTradeType;

    /**
     * 收付代码（支付类型代码）
     */
    private String payWayCode;

    /**
     * 收付名称（支付类型名称）
     */
    private String payWayName;

    /**
     * 本次支付金额
     */
    private BigDecimal payAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * POS机设备号
     */
    private String posSn;

    /**
     * 付款总金额
     */
    private BigDecimal combineAmount;
}
