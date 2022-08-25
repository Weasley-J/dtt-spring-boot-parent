package com.example.domain.user;

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
 * 虚拟钱币规则表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualMoneyRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则名称（如：xx商城的金币优惠规则，xx商城的积分规则，xx平台的云币优惠规则）
     */
    private String ruleName;

    /**
     * 平台id: 0 无; 1 普通会员; 2 医生-优医邦; 3 药店（邦甸园）; 默认：0
     */
    private Integer platformId;

    /**
     * 虚拟币来源（使用平台：1 商城、默认：1）
     */
    private Integer sourceType;

    /**
     * 虚拟币类型（0 积分  1 优医币，默认：0）
     */
    private Integer virtualType;

    /**
     * 虚拟币发放比例（发放平台的授予用户的比例）
     */
    private BigDecimal grantRatio;

    /**
     * 虚拟币兑换比例（兑换成货币的比例）
     */
    private BigDecimal exchangeRatio;

    /**
     * 有效期开始时间
     */
    private LocalDateTime effectStartTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime effectEndTime;

    /**
     * 是否启用（0 禁用，1  启用, 默认：1）
     */
    private Integer enable;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
