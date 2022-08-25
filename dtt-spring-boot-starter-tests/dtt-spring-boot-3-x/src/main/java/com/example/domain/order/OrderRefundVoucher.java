package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单退款凭证关联表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderRefundVoucher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 退款凭证管理
     */
    private String refundVoucherUrl;

    /**
     * 退单号
     */
    private String refundNo;

    /**
     * 系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康
     */
    private String systemId;

    /**
     * 业务平台（jd，tm,zy）
     */
    private String servicePlatform;

    /**
     * 业务渠道（渠道id）
     */
    private String serviceChannel;

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
