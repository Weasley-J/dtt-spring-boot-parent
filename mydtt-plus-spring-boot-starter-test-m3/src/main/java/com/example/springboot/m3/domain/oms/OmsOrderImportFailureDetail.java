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
 * oms线下导入订单失败明细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderImportFailureDetail implements Serializable {

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
     * sku id
     */
    private String skuId;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 解析完毕订单信息json 字符串
     */
    private String orderDetailJsonStr;

    /**
     * 失败原因
     */
    private String failureDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
