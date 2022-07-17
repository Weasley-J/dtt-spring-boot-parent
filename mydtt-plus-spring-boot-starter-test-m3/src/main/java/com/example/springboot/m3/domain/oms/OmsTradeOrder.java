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
 * OMS订单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsTradeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 三方平台编号 0.无 1.复星商城 2.京东 3.宝宝树,4.天猫,5.快手,6.抖音,7.网易严选,8.口碑,9.星选
     */
    private Integer thirdPlatformId;

    /**
     * 三方订单号
     */
    private String thirdOrderNo;

    /**
     * 三方订单状态
     */
    private String thirdStatus;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 1.待出库 2.出库中 3.已出库 4.已取消 5.已完成 6.部分出库
     */
    private Integer status;

    /**
     * 订单类型0 默认，1 全球购，2 权益包，3 疫苗，4 o2o，5 连锁，6 云药房
     */
    private Integer orderType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 优惠总金额
     */
    private BigDecimal discountAmount;

    /**
     * 运费
     */
    private BigDecimal carriageAmount;

    /**
     * 订单应付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 抵扣金额
     */
    private BigDecimal deductionAmount;

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
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverTel;

    /**
     * 订单收货时间
     */
    private LocalDateTime receiverTime;

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

    /**
     * 乡镇
     */
    private String town;

    /**
     * 收货人详细地址
     */
    private String address;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 发货标识 0.平台自处理 1.WMS 2.外部供应商api 3.外部供应商线下 4.自提
     */
    private Integer deliveryFlag;

    /**
     * 三方发货标识
     */
    private Integer thirdDeliveryType;

    /**
     * 订单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 订单留言
     */
    private String postscript;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 系统来源0 商城，1疫苗，2三方订单，3DTP ,4:复联，5 国大 6听力师
     */
    private String systemId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 是否自营供应商 0 非自营 1 自营
     */
    private Integer selfFlag;

    /**
     * 商家类型 0 其他  1 MP  2 入仓  3 DSV
     */
    private Integer merchantType;

    /**
     * 供应商全称
     */
    private String supplierFullName;

    /**
     * 外部会员id
     */
    private String outMemberId;

    /**
     * 退款标识 0.无退款 1.有退款
     */
    private Integer refundFlag;

    /**
     * 异常标识 1.正常 2.状态异常 3.同步物流异常 4.暂停 5.物料编码缺失 6.发货调用失败 7.出库调用失败
     */
    private Integer exceptionFlag;

    /**
     * 审核状态 0.无需审核 1.待审核 2.已审核 3.待中宝审核
     */
    private Integer checkStatus;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 商城发货通知标志 0 未通知  1 已通知发货
     */
    private Integer deliverySendFlag;

    /**
     * 商城拆单标志 0 未拆单  1 已拆单
     */
    private Integer splitFlag;

    /**
     * 线下导入标识: 0 非线下Excel导入, 1 线下Excel导入
     */
    private Integer offlineImportFlag;

    /**
     * 开票类型 1.线上开票 2.线下开票
     */
    private Integer invoiceType;

    /**
     * 取消出库原因
     */
    private String cancelReason;

    private String selfLiftingCode;

    /**
     * 1 已核销，0未核销, -1无需核销
     */
    private Integer selfLiftingCodeStatus;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 仓库id
     */
    private String wmsWarehouseId;

    /**
     * 仓库名称
     */
    private String wmsWarehouseName;
    /**
     * 支付通道扣减金额（非现金）
     */
    private BigDecimal payDisAmount;

    /**
     * oms订单创建时间
     */
    private LocalDateTime omsCreateTime;

    /**
     * 单据类型 0-销售订单  1-补发订单
     */
    private Integer orderBillType;

    /**
     * 补发订单标志
     */
    private Integer reissuedFlag;

    /**
     * 补发订单原因
     */
    private String reissuedReason;

    /**
     * 补发订单原订单号
     */
    private String originOrderNo;
    /**
     * 补发订单原订单id
     */
    private Integer originOrderId;

    /**
     * 宝宝树店铺Id
     */
    private String bbsSupplierId;

    /**
     * 货主ID
     */
    private String merchantId;

    /**
     * 拼多多收货人手机号密文
     */
    private String pddReceiverTelEncrypt;

    /**
     * 拼多多收货人地址密文
     */
    private String pddReceiverAddressEncrypt;

}
