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
 * 支付订单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单来源：0 无 1 商城系统 3 云HIS门诊缴费  4 云HIS充值
     */
    private Integer orderSource;

    /**
     * 支付类型：0 支付，1 退款
     */
    private Integer payType;

    /**
     * 支付方式code：ALI_PAY,WECHAT_PAY
     */
    private String channelCode;

    /**
     * 支付调用方式：WX_JSAPI,WX_MWEB
     */
    private String payTradeType;

    /**
     * 处理状态，0 待支付，1 支付成功，2 支付失败 ，3 处理中, 4 支付关闭
     */
    private Integer payStatus;

    /**
     * 支付交易单号
     */
    private String payNo;

    /**
     * 商品订单或者退单合并单号
     */
    private String combineNo;

    /**
     * 商品订单或者退单合并金额
     */
    private BigDecimal combineAmount;
//    private BigDecimal tradeTotalAmount;

    /**
     * 三方流水号
     */
    private String thirdTransactionNo;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 父pay_no
     */
    private String parentPayNo;

    /**
     * app_id
     */
    private String appId;

    /**
     * 三方商户id
     */
    private String thirdMerchantId;

    /**
     * 支付或退款成功时间
     */
    private LocalDateTime successTime;

    /**
     * 付款提交人
     */
    private String submitUserId;

    /**
     * 支付超时时间
     */
    private LocalDateTime payTimeOut;

    /**
     * 商品描述
     */
    private String goodsDescription;

    /**
     * 支付成功跳转地址
     */
    private String redirectUrl;

    /**
     * openid
     */
    private String openId;

    /**
     * 请求ip
     */
    private String requestIp;

    /**
     * 配置id
     */
    private Integer payChannelConfigId;

    /**
     * 支付返回body
     */
    private String payResponse;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * appScheme
     */
    private String appScheme;

    /**
     * POS机设备号
     */
    private String posSn;

    /**
     * 全局活动码
     **/
    private String globalActivityId;

    /**
     * 全局推广渠道码
     **/
    private String globalChannelId;

    /**
     * 重试次数
     */
    private Integer refundRetryCount;


    //url
    private String unifiedOrderPayUrl;

    //请求参数
    private String unifiedOrderRequest;

    //响应参数
    private String unifiedOrderResponse;


    /**
     * 0  不分账(不走分账)  1 已受理  2 分账完成
     * 修改成：0  不分账(不走分账)  1 走分账
     */
    private Integer shardingStatus;

    /**
     * 分账周期
     */
    private String shardingPeriod;

    /**
     * 默认 0  1 同步  2 异步
     */
    private Integer shardingPattern;


    /**
     * 子支付类型 0 普通付款 1 主动退款  2订单关闭退款
     */
    private Integer subPayType;

    /**
     * 业务系统通知状态  0:未通知 1:通知成功 2 通知失败
     */
    private Integer notifyStatus;

    /**
     * 结算状态：0 默认 1 结算成功
     */
    private Integer thirdSettlerStatus;


}
