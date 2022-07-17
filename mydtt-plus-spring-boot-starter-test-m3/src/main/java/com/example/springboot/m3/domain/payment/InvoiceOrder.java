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
 * 开票订单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InvoiceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开票订单编号
     */
    private String invoiceNo;

    /**
     * 关联订单库订单编号
     */
    private String orderNo;

    /**
     * 开票来源:1-复星商城，2-oms
     */
    private Integer invoiceSource;

    /**
     * 三方平台编号 0.无 1.复星商城 2.京东 3.宝宝树
     */
    private Integer thirdPlatformId;

    /**
     * 销货方id
     */
    private Integer invoiceTaxpayerId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 订单类型 1:蓝票订单 2:红票订单
     */
    private Integer orderType;

    /**
     * 发票类型 1:电子发票 2:上传发票
     */
    private Integer invoiceType;

    /**
     * 发票抬头类型 1:个人 2:企业
     */
    private Integer invoiceTitle;

    /**
     * 发票抬头
     */
    private String customerName;

    /**
     * 纳税人识别号(个人为NULL)
     */
    private String customerCode;

    /**
     * 纳税人邮箱
     */
    private String customerEmail;

    /**
     * 税价合计金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 开票订单状态, 1:待开票 2:开票中 3:开票成功 4:开票失败 5:已冲红(作废) 6:冲红中 7:作废
     */
    private Integer invoiceStatus;

    /**
     * pdf地址
     */
    private String pdfUrl;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 发票代码
     */
    private String originalCode;

    /**
     * 失败code
     */
    private String failCode;

    /**
     * 冲红原因或者失败原因
     */
    private String reason;

    /**
     * 订单库退单号
     */
    private String refundOrderNo;

    /**
     * 邮件发送状态 0未发送 1已发送
     */
    private Integer sendFlag;

    /**
     * 开票时间
     */
    private LocalDateTime billingInvoiceTime;

    /**
     * 关联的开票订单号
     */
    private String blueInvoiceNo;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 1:全退 2:部分退
     */
    private Integer partRefund;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者名
     */
    private String creatorName;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;


}
