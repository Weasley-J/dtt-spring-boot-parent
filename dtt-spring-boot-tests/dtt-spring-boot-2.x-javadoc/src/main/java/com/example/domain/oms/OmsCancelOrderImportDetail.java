package com.example.domain.oms;

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
 * oms线下导入订单取消明细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsCancelOrderImportDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 导入批次号
     */
    private Integer batchId;

    /**
     * 平台订单编号
     */
    private String thirdOrderNo;

    /**
     * 三方平台编号 同订单主表
     */
    private Integer thirdPlatformId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 收货人电话
     */
    private String receiverTel;

    /**
     * 收货人详细地址
     */
    private String receiverAddress;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 导入行json
     */
    private String importRowJson;

    /**
     * 取消结果 0.待处理 1.处理成功 2.部分处理成功 3.处理失败
     */
    private Integer status;

    /**
     * 失败原因
     */
    private String failureDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 0 未删除,1已删除
     */
    private Integer delFlag;


}
