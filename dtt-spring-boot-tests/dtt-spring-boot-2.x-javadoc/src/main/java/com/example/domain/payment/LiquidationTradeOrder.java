package com.example.domain.payment;

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
 * 清算订单表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationTradeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付交易单号
     */
    private String payNo;

    /**
     * 系统来源0 商城，1疫苗
     */
    private String orderSource;

    /**
     * 支付类型：0 支付，1 退款
     */
    private Integer payType;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退单号
     */
    private String refundOrderNo;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 三方流水号
     */
    private String thirdTransactionNo;

    /**
     * 支付方式code：ALI_PAY,WECHAT_PAY
     */
    private String payChannelCode;

    /**
     * 支付或退款成功时间
     */
    private LocalDateTime paySuccessTime;

    /**
     * 订单类型0 默认，1 全球购，2 权益包，3 疫苗
     */
    private Integer orderType;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 优惠总金额
     */
    private BigDecimal discountAmount;

    /**
     * 运费
     */
    private BigDecimal carriageAmount;

    /**
     * 订单应付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 抵扣金额
     */
    private BigDecimal deductionAmount;

    /**
     * 抵扣优医币
     */
    private Integer healthCoin;

    /**
     * 抵扣邦指数
     */
    private Integer bangCoin;

    /**
     * 结算状态 0 未结算 1 已结算
     */
    private Integer settleStatus;

    /**
     * 是否自营 0 非自营 1 自营
     */
    private Integer settleType;

    /**
     * 结算金额
     */
    private BigDecimal settleAmount;

    /**
     * 结算时间
     */
    private LocalDateTime settleTime;

    /**
     * 结算付款状态 0 未付款 1 已付款, 2 付款中
     */
    private Integer settlePayStatus;

    /**
     * 结算付款时间
     */
    private LocalDateTime settlePayTime;

    /**
     * 订单是否发生交易成功 0 未 1 产生交易成功
     */
    private Integer orderSuccessFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
