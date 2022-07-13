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
 * 医生维度结账单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IndexStatementDoctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医生维度账单id（子单号）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 结算单号
     */
    private String statementNo;

    /**
     * 医生id
     */
    private Long doctorId;

    /**
     * 医生名字
     */
    private String doctorName;

    /**
     * 类型金额统计字符串
     */
    private String businessTotalStr;

    /**
     * 提交结算金额
     */
    private BigDecimal submitAmount;

    /**
     * 结算成功金额
     */
    private BigDecimal successfulAmount;

    /**
     * 提交时间
     */
    private LocalDateTime submitTime;

    /**
     * 结算时间
     */
    private LocalDateTime settlementTime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 是否已结算 0：未结算 （默认） 1：结算成功   2：结算失败
     */
    private Integer status;

    /**
     * 结算备注
     */
    private String settlementRemarks;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除(0:未删除,1:已删除)
     */
    private Integer isDel;


}
