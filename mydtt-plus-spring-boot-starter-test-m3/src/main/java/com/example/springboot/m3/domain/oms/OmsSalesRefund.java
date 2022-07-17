package com.example.springboot.m3.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 第三方平台销售退单主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsSalesRefund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 三方平台编号 0.无 1.复星商城 2.京东 3.宝宝树,4.天猫,5.京东,6.快手,7.抖音,8.网易严选,9.星选
     */
    private Integer thirdPlatformId;

    /**
     * OMS订单id
     */
    private Integer orderId;

    /**
     * OMS订单号
     */
    private String orderNo;

    /**
     * 三方订单号,可能为拆单接口返回的单号
     */
    private String thirdOrderNo;

    /**
     * 三方退单号
     */
    private String thirdRefundNo;

    /**
     * Wms退货单号
     */
    private String wmsRefundOrderNo;

    /**
     * 1:其他,2:待退款,3:退款关闭,4:退款成功
     */
    private Integer status;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 原订单收货地址合并省市区
     */
    private String address;

    /**
     * 收货人手机号
     */
    private String receiverMobile;

    /**
     * 第三方客户账号
     */
    private String thirdBuyerId;

    /**
     * 问题描述
     */
    private String questionDesc;

    /**
     * 退单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 退单原因
     */
    private String cancelReason;

    /**
     * 补充原因
     */
    private String supplementReason;

    /**
     * 拒绝原因
     */
    private String rejectiveReason;

    /**
     * 审核者姓名
     */
    private String approveName;

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
     * 复星sku_id
     */
    private String skuId;

    /**
     * 外部sku_id
     */
    private String outSkuId;

    /**
     * 第三方sku_id
     */
    private String thirdSkuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
