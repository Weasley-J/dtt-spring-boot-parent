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
 * 支付提现表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayWithdraw implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 提现流水号
     */
    private String withdrawTradeNo;

    /**
     * 三方流水号
     */
    private String thirdOrderNo;

    /**
     * 商户ID
     */
    private String supplierId;

    /**
     * 商户快钱UID
     */
    private String pfpmCode;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行户名
     */
    private String bankAccountName;

    /**
     * 提现状态:0、已提交;1、提现成功;2、提现失败;3、受理成功
     */
    private Integer withdrawStatus;

    /**
     * 提现重试次数
     */
    private Integer withdrawRetryCount;

    /**
     * 提现失败原因
     */
    private String withdrawFailReason;

    /**
     * 三方状态:0、未知;1、成功;2、失败;3、已受理
     */
    private Integer thirdStatus;

    /**
     * 提现金额
     */
    private BigDecimal withdrawAmout;

    /**
     * 提现手机号码
     */
    private String withdrawTel;

    /**
     * 提现提交人
     */
    private String withdrawUser;

    /**
     * 平台账号
     */
    private String memberCode;

    /**
     * 提现接口请求参数
     */
    private String thirdSubmitRequestData;

    /**
     * 提现接口响应参数
     */
    private String thirdSubmitResponseData;

    /**
     * 补偿查询JOB请求参数
     */
    private String thirdQueryRequestData;

    /**
     * 补偿查询JOB响应参数
     */
    private String thirdQueryResponseData;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 支行全称（用户新增银行信息）
     */
    private String bankBranchFullName;

    /**
     * 开户行-区code码（用户新增银行信息）
     */
    private Integer bankDistrictCode;
    /**
     * 唯一幂等键
     */
    private String idempotentId;

    /**
     * 提现类型：0、非跨境；1、跨境
     */
    private Integer withdrawType;

}
