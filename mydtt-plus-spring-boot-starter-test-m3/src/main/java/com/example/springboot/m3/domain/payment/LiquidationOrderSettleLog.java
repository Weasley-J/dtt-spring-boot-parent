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
 * 结算付款记录表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationOrderSettleLog implements Serializable {

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
     * 账本记录表ID
     */
    private Integer liquidationCapitalAccountBookRecordId;

    /**
     * 收支类型：0 支出，1 收入
     */
    private Integer capitalChangeType;

    /**
     * 变动资金额度
     */
    private BigDecimal changeAmount;

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
