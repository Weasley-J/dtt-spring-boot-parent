package com.example.domain.order;

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
 * 退单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderRefund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退单号
     */
    private String refundNo;

    /**
     * 1 退款 2 退货 3 退货退款
     */
    private Integer refundType;

    /**
     * 1 待退款 2 退款关闭 3 商家审核 4 商品寄回 5 商家确认退款 6 退款成功 7 退货待审核
     */
    private Integer status;

    /**
     * 1 线下E端 2 线上C端 3 线下B端
     */
    private Integer channel;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 运费退款金额
     */
    private BigDecimal refundCarriageAmount;

    /**
     * 非现金支付退款金额
     */
    private BigDecimal refundPayDisAmount;

    /**
     * 收货地址合并省市区
     */
    private String address;

    /**
     * 买家用户ID
     */
    private Integer buyerId;

    /**
     * 购买者用户名
     */
    private String buyerName;

    /**
     * 购买者电话
     */
    private String buyerTel;

    /**
     * item id
     */
    private Integer itemId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 连锁店id
     */
    private Integer chainShopId;

    /**
     * 连锁店名称
     */
    private String chainShopName;

    /**
     * 门店id
     */
    private Integer retailShopId;

    /**
     * 门店名称
     */
    private String retailShopName;

    /**
     * 供应商全称
     */
    private String supplierFullName;

    /**
     * 收付代码（支付类型代码）
     */
    private String payWayCode;

    /**
     * 收付名称（支付类型名称）
     */
    private String payWayName;

    /**
     * 退单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 退单原因
     */
    private String cancelReason;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 支付交易单号
     */
    private String payNo;

    /**
     * 三方流水号
     */
    private String thirdTransactionNo;

    /**
     * 补充原因
     */
    private String supplementReason;

    /**
     * 拒绝原因
     */
    private String rejectiveReason;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 大会员系统的会员id
     */
    private String outMemberId;

    /**
     * 退单归还抵扣金额
     */
    private BigDecimal returnDeductionAmount;

    /**
     * 退单归还抵扣金额（优医币，邦指数）
     */
    private BigDecimal returnDeductionScoreAmount;

    /**
     * 退单归还抵扣金额（礼品卡）
     */
    private BigDecimal returnDeductionCardAmount;

    /**
     * 退单归还抵扣优医币
     */
    private Integer returnHealthCoin;

    /**
     * 退单归还抵扣邦指数
     */
    private Integer returnBangCoin;

    /**
     * 退货物流方式 1.无退货物流 2.原运单退回 3.新运单退回
     */
    private Integer expressMethod;

    /**
     * 快递单号
     */
    private String invoiceNo;

    /**
     * 物流公司code
     */
    private String expressCode;

    /**
     * 退款图片凭证
     */
    private String pictureUrl;


}
