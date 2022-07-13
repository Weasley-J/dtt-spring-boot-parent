package com.example.domain.user;

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
 * 权益订单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 购买人id
     */
    private String buyerId;

    /**
     * 权益商品项状态：0 未激活  1 未核销 2 部分核销 3 已完成 4 已退款   6 作废（手动作废） 7 过期（超过有效期）
     */
    private Integer orderStatus;

    /**
     * 0 默认值 1 退款中
     */
    private Integer refundStatus;

    /**
     * 0 权益包订单，1 实体卡订单 2 虚拟卡订单  4 实体卡激活  5 电子卡激活  6 礼品卡  7 礼品卡实体卡   8 权益包升级  100006.基因检测发放 100007.体检发放 100008.苏可欣发放
     */
    private Integer orderSubType;

    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * skuId
     */
    private String skuId;

    /**
     * 购买者用户名
     */
    private String buyerName;

    /**
     * 购买人手机号
     */
    private String buyerTel;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者身份证
     */
    private String patientIdCard;

    /**
     * 患者手机号
     */
    private String patientTel;

    /**
     * 收货人手机号
     */
    private String receiverTel;

    /**
     * 权益包帮指数
     */
    private BigDecimal bzsValue;

    /**
     * 权益包帮指数留存比例
     */
    private BigDecimal bzsLiveRatio;

    /**
     * 权益包帮指数关系比例
     */
    private BigDecimal bzsRelationRatio;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 权益包名称
     */
    private String packageName;

    /**
     * 权益包描述
     */
    private String packageDesc;

    /**
     * 时间类型：0 无，1 固定时间 2 自发放后多少天有效，默认：0
     */
    private Integer timeType;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 自发放后多少天内有效
     */
    private Integer days;

    /**
     * 订单号
     */
    private String refOrderNo;

    /**
     * 权益卡模板id
     */
    private Integer assetsCardTemplateId;

    /**
     * 权益卡实例id
     */
    private Integer assetsCardInstanceId;

    /**
     * 0 未读 1 已读
     */
    private Integer isRead;

    /**
     * 源服务包模板id
     */
    private String originalPackageTemplateId;

    /**
     * 收付代码（支付类型代码）
     */
    private String payWayCode;

    /**
     * 收付名称（支付类型名称）
     */
    private String payWayName;

    /**
     * 下单时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 权益包图片
     */
    private String packageImage;

    /**
     * 源服务包实例id
     */
    private String originalPackageInstanceId;

    /**
     * 组id
     */
    private String groupId;

    /**
     * 卡激活方式 0 手动激活 1 购买系统自动激活
     */
    private Integer packageActivateType;

    /**
     * 可共享次数
     */
    private Integer shareCount;

    /**
     * 三方订单号（复联）
     */
    private String thirdOrderNo;


    /**
     * 订单唯一键，存储类型：订单号-1
     */
    private String refOrderNoNum;

    /**
     * 渠道id
     */
    private String globalChannelId;
}
