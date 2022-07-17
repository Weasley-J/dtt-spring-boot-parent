package com.example.springboot.m3.domain.user;

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
 * 虚拟钱币使用记录表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualMoneyUseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 虚拟钱币表ID
     */
    private Integer virtualMoneyId;

    /**
     * 大会员系统的会议id
     */
    private String outMemberId;

    /**
     * 虚拟币类型：1 优医币，2：邦指数，默认：1
     */
    private Integer virtualType;

    /**
     * 虚拟币来源（使用平台：1 商城，2 优医邦在线, 3 邦甸员，默认：1）
     */
    private Integer sourceType;

    /**
     * 虚拟金币核销方式（1 下单发放， 2 下单抵扣，3 退款订单追回 4 取消订单归还，5 优医邦在线邀请好友， 6 问诊使用, 7 数据迁移，8 用户充值，9 邦甸员导入，10 取消问诊退还，11 其他，12 其他核销方式加币, 13 退款订单归还，默认：1 ）
     */
    private Integer creditType;

    /**
     * 虚拟币核销方式描述信息
     */
    private String creditTypeDesc;

    /**
     * 虚拟金币数量（抵扣金额/发放金额）
     */
    private BigDecimal virtualValue;

    /**
     * 来源流水
     */
    private String sourceNumber;

    /**
     * 原始来源流水
     */
    private String originalSourceNumber;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
