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
 * 账单明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationBillDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账单表ID
     */
    private Integer liquidationBillId;

    /**
     * 业务来源0 商城，1疫苗
     */
    private Integer bizSource;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 业务单号：履约单号
     */
    private String bizNo;

    /**
     * 业务状态，接种状态
     */
    private String bizStatus;

    /**
     * 业务结算状态，1 待结算 2 可结算 3 结算中 4 已结算
     */
    private String bizSettleStatus;

    /**
     * 结算价格
     */
    private BigDecimal settlementAmount;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userTel;

    /**
     * 证件类型 ID_CARD: 身份证号
     */
    private String credentialsType;

    /**
     * 证件号码
     */
    private String credentialsNo;

    /**
     * 业务名称，商品名称
     */
    private String bizName;

    /**
     * 业务属性0：接种针次
     */
    private String bizAttr0;

    /**
     * 核销时间
     */
    private LocalDateTime verificationTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
