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
 * 权益包子项
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsPackageItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益项名称
     */
    private String subTitle;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 权益项类型：1 问诊，2 商品（实物商品），3 优惠券，4 保险，5 服务商品，6 线下就诊，7 线下履约
     */
    private Integer itemType;

    /**
     * 权益项子类型：0 无 ，1 图文问诊， 2 视频问诊，3 苏可欣，4 并发症保险(优立通)， 5 疫苗服务，6 优惠券，7 实物商品，8 体检，9 居家回检，10 报告解读，11 医美服务，12 本地生活，13 宠物服务, 14 CKD疾病进展险(优立通-雪特)，15 绿通，16 SVIP权益，17 核酸检测，18 家医图文问诊，19 家医电话问诊，20 陪诊，21挂号绿通，22 口腔护理
     */
    private Integer itemSubType;

    /**
     * 权益包项id
     */
    private Integer itemId;

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
     * 商品skuId
     */
    private String skuId;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 数量类型：1 自定义 2 不限次
     */
    private Integer numberType;

    /**
     * 数量（特殊值：number_type为2填-1）
     */
    private Integer itemNumber;

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
     * 帮指数结算方式：0 无须结算，1 百分比， 2 绝对值，默认：0
     */
    private Integer bzsSettleType;

    /**
     * 帮指数结算值
     */
    private BigDecimal bzsSettleValue;

    /**
     * 权益项状态：1 启用（上架），0 禁用（下架），默认：1
     */
    private Integer status;

    /**
     * 权益项跳转连接，当前场景只取item地址或sku地址跳转
     */
    private String jumpUrl;

    /**
     * 权益跳转其他业务链接的JSON字符串，如:h5,微信小程序等，json字符规范:{"key1":"url1","key2":"url2"}；例如：{"h5":"https://www.abc.com","weChatMiniProgram":"https://www.def.com"}
     */
    private String businessUrl;

    /**
     * 创建时间
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


}
