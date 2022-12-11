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
 * 结算单明细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IndexStatementDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结算单明细主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 结算单号（必填）
     */
    private Long subOrderNo;

    /**
     * 明细id
     */
    private Long detailId;

    /**
     * 医生id
     */
    private Long doctorId;

    /**
     * 医生名字
     */
    private String doctorName;

    /**
     * 结算金额
     */
    private BigDecimal amount;

    /**
     * 业务标识
     * 0:问诊 1:商品 2:平台服务包 3:问诊权益 4:自定义服务包 5:医生拉新 6:医生备案
     */
    private String business;

    /**
     * 结算状态 0：未结算 （默认） 1：结算成功   2：结算失败
     */
    private Integer status;

    /**
     * 提交时间
     */
    private LocalDateTime submitTime;

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
