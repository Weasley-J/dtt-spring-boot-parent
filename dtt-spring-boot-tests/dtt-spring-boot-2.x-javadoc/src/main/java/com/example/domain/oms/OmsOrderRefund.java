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
 * OMS退单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderRefund implements Serializable {

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
     * 退货单号
     */
    private String refundNo;

    /**
     * 退单类型 1.退货
     */
    private Integer refundType;

    /**
     * 三方平台编号 0.无 1.复星商城 2.京东 3.宝宝树
     */
    private Integer thirdPlatformId;

    /**
     * 三方订单号
     */
    private String thirdOrderNo;

    /**
     * 三方退单号
     */
    private String thirdRefundNo;

    /**
     * 售后状态 1.待填退货物流 2.待仓库收货 3.仓库已收货 4.仓库收货完成 5.退货取消
     */
    private Integer status;

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
     * 原订单收货地址合并省市区
     */
    private String address;

    /**
     * 买家用户ID
     */
    private String buyerId;

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
     * 外部sku id
     */
    private String outSkuId;

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
     * 外部会员id
     */
    private String outMemberId;

    /**
     * 渠道部门
     */
    private String departmentChannel;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;
}
