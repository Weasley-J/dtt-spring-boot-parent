package com.example.springboot.m3.domain.user;

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
 * 权益订单项
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益订单id
     */
    private Integer orderId;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 权益商品项状态：1 未核销 2 部分核销 3 已完成 4 已退款   6 作废（手动作废）  7 过期（超过有效期）
     */
    private Integer orderItemStatus;

    /**
     * 补尝权益id
     */
    private Integer reissueId;

    /**
     * 0 默认值 1 退款中
     */
    private Integer refundStatus;

    /**
     * 权益项类型： 1 问诊，2 商品（实物商品），3 优惠券，4 保险 5 服务商品
     */
    private Integer itemType;

    /**
     * 数量类型：1 自定义 2 不限次
     */
    private Integer numberType;

    /**
     * sku id
     */
    private String skuId;

    /**
     * coupon id
     */
    private Integer couponId;

    /**
     * 适配维度选择 1 指定医生 0 不指定医生
     */
    private Integer assignDoctor;

    /**
     * 关联医生id
     */
    private String doctorList;

    /**
     * 数量
     */
    private Integer itemNumber;

    /**
     * 核销数量
     */
    private Integer useNumber;

    /**
     * 作废数量
     */
    private Integer invalidNumber;

    /**
     * 权益包项id
     */
    private Integer itemId;

    /**
     * 权益项名称
     */
    private String subTitle;

    /**
     * 权益项描述
     */
    private String itemDesc;

    /**
     * 权益项价值 元
     */
    private BigDecimal itemVal;

    /**
     * 商品skuId对应的spu
     */
    private String skuItemId;

    /**
     * 权益项子类型：0 无 ，1 图文问诊， 2 视频问诊，3 苏可欣（保险），4 优立通（保险）， 5 疫苗服务，6 优惠券，7 实物商品，8 体检，9 检验检测，10 报告解读 ，11 医美服务，12 本地生活，13 宠物服务, 14 优立通（雪特），15 绿通
     */
    private Integer itemSubType;

    /**
     * 帮指数结算方式 0 默认无须结算 1 百分比 2 绝对值
     */
    private Integer bzsSettleType;

    /**
     * 帮指数结算值
     */
    private BigDecimal bzsSettleValue;

    /**
     * 单独维护权益有效期 0 不单独 1 单独
     */
    private Integer singleType;

    /**
     * 发放类型（履约类型）：0 直接发放，1 用户手动激活
     */
    private Integer grantType;

    /**
     * 时间类型：0 无，1 固定时间 2 自发放后多少天有效，默认：0
     */
    private Integer timeType;

    /**
     * 自发放后多少天内有效
     */
    private Integer days;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 权益分发外部系统关联
     */
    private String refNo;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 权益项跳转连接，当前场景只取item地址或sku地址跳转
     */
    private String jumpUrl;

    /**
     * 权益跳转其他业务链接的JSON字符串，如:h5,微信小程序等，json字符规范:{"key1":"url1","key2":"url2"}；例如：{"h5":"https://www.abc.com","weChatMiniProgram":"https://www.def.com"}
     */
    private String businessUrl;

    /**
     * 购买人id
     */
    private String userId;

    /**
     * 购买人手机号
     */
    private String userTel;

    /**
     * 购买者用户名
     */
    private String userName;

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
     * 渠道id
     */
    private String globalChannelId;

}
