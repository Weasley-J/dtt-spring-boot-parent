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
 * 账本记录表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationCapitalAccountBookRecord implements Serializable {

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
     * 记账流水号
     */
    private String accountTransactionNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品交易流水号
     */
    private String orderItemTransactionNo;

    /**
     * 费用类型：0 商品 1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券 12 优医币抵扣 13 帮指数抵扣 14 运费 ,15 佣金 ，16 结算 17 付款
     */
    private Integer billType;

    /**
     * 收支账户
     */
    private Integer liquidationCapitalAccountId;

    /**
     * 收支类型：0 收入 ，1 支出
     */
    private Integer capitalChangeType;

    /**
     * 变动资金额度
     */
    private BigDecimal changeAmount;

    /**
     * 账户快照余额
     */
    private BigDecimal snapshootCapitalAmount;

    /**
     * 结算付款状态 0 未付款 1 已付款, 2 付款中
     */
    private Integer settlePayStatus;

    /**
     * 业务幂等键(用于保证无重复记账)
     */
    private String bizPk;

    /**
     * 摘要
     */
    private String remark;

    /**
     * 操作人ID
     */
    private String operatorId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
