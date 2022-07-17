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
 * 账单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationBill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务来源0 商城，1疫苗
     */
    private Integer bizSource;

    /**
     * 账单状态 0 待结算  1 结算中 2 已驳回 3 结算成功 4 结算失败
     */
    private Integer billStatus;

    /**
     * 外部系统账单编号（幂等健）
     */
    private String outBillNo;

    /**
     * 主体ID
     */
    private String subjectId;

    /**
     * 主体名称
     */
    private String subjectName;

    /**
     * 收款人姓名
     */
    private String beneficiaryName;

    /**
     * 收方账号
     */
    private String beneficiaryAccountNumber;

    /**
     * 收方开户行
     */
    private String beneficiaryKhh;

    /**
     * 收方开户行地址
     */
    private String beneficiaryKhhAddress;

    /**
     * 账单月份
     */
    private String billMonth;

    /**
     * 明细笔数
     */
    private Integer billDetailCount;

    /**
     * 账单金额
     */
    private BigDecimal billTotalAmount;

    /**
     * 账单成时间
     */
    private LocalDateTime billTime;

    /**
     * 驳回原因
     */
    private String rejectReason;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
