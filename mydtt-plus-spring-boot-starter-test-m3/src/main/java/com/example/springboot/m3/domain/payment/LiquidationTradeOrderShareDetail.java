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
 * 清算订单分摊明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationTradeOrderShareDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 清算订单表ID
     */
    private Integer liquidationTradeOrderId;

    /**
     * 清算子订单表ID
     */
    private Integer liquidationTradeOrderItemId;

    /**
     * 分摊主体：0 平台 1 商家
     */
    private Integer shareSubject;

    /**
     * 费用类型：0 商品 1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券 12 优医币抵扣 13 帮指数抵扣 14 运费 ,15 佣金 ，16 结算 17 付款 18 权益抵扣
     */
    private Integer shareItemType;

    /**
     * 分摊项目ID
     */
    private String shareItemId;

    /**
     * 分摊项目金额
     */
    private BigDecimal shareItemAmount;

    /**
     * 商品交易流水号（每次落库生成，退款基于原始的）
     */
    private String orderItemTransactionNo;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
