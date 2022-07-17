package com.example.springboot.m3.domain.oms;

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
 * 退款单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsThirdRefundPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 退款单号
     */
    private String refundNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 1 待退款 2 退款关闭  6 退款成功
     */
    private Integer status;

    /**
     * 退单原因
     */
    private String cancelReason;

    /**
     * 拒绝原因
     */
    private String rejectiveReason;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 1:创建退单 2，取消退单 3，退单成功
     */
    private Integer pushStatus;

    /**
     * 1:待审核 2，审核成功 3，审核失败
     */
    private Integer supplierRefundCheck;

    /**
     * 审核原因
     */
    private String checkReason;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
