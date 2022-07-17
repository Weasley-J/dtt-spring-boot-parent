package com.example.springboot.m3.domain.payment;

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
 * 支付子订单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SubPayOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付单id
     */
    private Integer payOrderId;

    /**
     * 订单来源：0 无 1 商城系统 3 云HIS门诊缴费  4 云HIS充值
     */
    private Integer orderSource;

    /**
     * 交易支付单号
     */
    private String payNo;

    /**
     * 商品或订单号或退单号
     */
    private String tradeOrderNo;

    /**
     * 退款单对应的原单号
     */
    private String originalTradeOrderNo;

    /**
     * 商品订单应付或退款金额
     */
    private BigDecimal tradeAmount;

    /**
     * 供应商id
     */
    private String supplierId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单总金额
     */
    private BigDecimal tradeTotalAmount;


}
