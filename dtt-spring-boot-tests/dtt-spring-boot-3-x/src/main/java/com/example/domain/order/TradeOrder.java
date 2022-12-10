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
 * 订单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TradeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    /**
     * 父单号（多订单提交生成新父单号，单订单提交与订单号一致）
     */
    private String parentOrderNo;

    /**
     * 1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功
     */
    private Integer status;

    /**
     * 订单类型0 默认，1 全球购，2 权益包，3 疫苗，4 o2o，5 连锁，6 云药房 7 连锁供应链
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
     * 支付通道扣减金额（非现金）
     */
    private BigDecimal payDisAmount;

    /**
     * 运费
     */
    private BigDecimal carriageAmount;

    /**
     * 订单应付金额
     */
    private BigDecimal paymentAmount;

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
     * 收货人详细地址
     */
    private String address;

    /**
     * 评价状态 0 未评价 1 已评价
     */
    private Integer evaluationStatus;

    /**
     * 评价时间
     */
    private LocalDateTime evaluationTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 订单完成时间
     */
    private LocalDateTime finishedTime;

    /**
     * 是否匿名
     */
    private Integer anonymous;

    /**
     * 订单留言
     */
    private String postscript;

    /**
     * 取消订单原因
     */
    private String cancelReason;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

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
     * 是否老系统：1 是  0  否
     */
    private Integer originalSystem;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 抵扣金额
     */
    private BigDecimal deductionAmount;

    /**
     * 抵扣金额（优医币，邦指数）
     */
    private BigDecimal deductionScoreAmount;

    /**
     * 抵扣金额（礼品卡）
     */
    private BigDecimal deductionCardAmount;

    /**
     * 抵扣优医币
     */
    private Integer healthCoin;

    /**
     * 抵扣邦指数
     */
    private Integer bangCoin;

    /**
     * 大会员系统的会员id
     */
    private String outMemberId;

    /**
     * 渠道来源
     */
    private String channelSource;

    /**
     * 终端类型 h5InWx，h5，wxMiniApp
     */
    private String endpoint;

    /**
     * 外部参数（根据外部需求放入）
     */
    private String externalValue;

    /**
     * 退款标识 0.无退款 1.有退款
     */
    private Integer refundFlag;

    /**
     * 订单取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康
     */
    private String systemId;

    /**
     * 业务平台 0 星苗自营、1天猫、2京东、3百度、4腾讯、5其他、7快手、6抖音、8网易严选、9口碑、10 医鹿
     */
    private String servicePlatform;

    /**
     * 业务渠道（渠道id）
     */
    private String serviceChannel;

    /**
     * 订单备注，仅供后台使用，无业务交互
     */
    private String orderComment;

    /**
     * 订单备注时间，编辑备注覆盖
     */
    private LocalDateTime commentTime;

    /**
     * 全局活动id
     */
    private String globalActivityId;

    /**
     * 全局渠道id
     */
    private String globalChannelId;

    /**
     * 权益订单子类型：0 默认，1 普通权益包，2 实体卡，3 电子卡，4 实体卡激活权益包，
     * 5 电子卡激活权益包 6 礼品卡电子卡 7 礼品卡实体卡   8 权益包升级，9三方权益订单  100006.基因检测发放 100007.体检发放 100008.苏可欣发放
     */
    private Integer assetsType;

    /**
     * 0默认物流，1o2o在线配送，2自提
     */
    private Integer deliveryType;

    /**
     * 商家类型 0 其他  1 MP  2 入仓  3 DSV
     */
    private Integer merchantType;

    /**
     * 是否自营供应商 0 非自营 1 自营
     */
    private Integer selfFlag;

    /**
     * 业务标识 1保险 2云DTP 3一体化DTP
     */
    private Integer businessFlag;

    /**
     * 收货地址纬度
     */
    private BigDecimal receiverLat;

    /**
     * 收货地址经度
     */
    private BigDecimal receiverLng;

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
     * 终端类型
     * 1.小程序原生页面 2.ios原生的页面 3.android原生的页面 4.h5页面在微信小程序里打开 5.h5页面在微信浏览器中打开，不包括微信小程序 6.不在上述情况下的值
     */
    private Integer clientType;

    /**
     * 应用名称
     */
    private String deviceName;

    /**
     * 是否参与分销 0否,1是 （分销信息见order_extend）
     */
    private Integer distributionFlag;


}
