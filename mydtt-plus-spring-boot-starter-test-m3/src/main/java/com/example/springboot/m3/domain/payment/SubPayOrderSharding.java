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
 * 支付子订单分账明细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SubPayOrderSharding implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 子订单id,或者连锁店id或者医院id
     */
    private Integer subPayOrderId;

    /**
     * 订单来源：0 无 1 商城系统 3 云HIS门诊缴费  4 云HIS充值
     */
    private Integer orderSource;

    /**
     * 供应商id
     */
    private String supplierId;

    private String pattern;
    private String subjectId;


    /**
     * 商户uid
     */
    private String merchantUid;

    /**
     * 分摊金额
     */
    private BigDecimal shardingAmount;

    /**
     * 分摊比例
     */
    private BigDecimal platformShardingRatio;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间，非常重要，不要随便修改
     */
    private LocalDateTime createTime;


}
