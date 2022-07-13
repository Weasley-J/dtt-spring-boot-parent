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
 * 三方订单批次成功详细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderThreeImportSuccessItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 渠道店铺名称
     */
    private String channelStoreName;

    /**
     * 渠道订单号
     */
    private String channelOrderNo;

    /**
     * 渠道商品名称
     */
    private String channelProductName;

    /**
     * 复星skuId
     */
    private String skuId;

    /**
     * 渠道售价
     */
    private BigDecimal channelProductPrice;

    /**
     * 下单数量
     */
    private Integer orderQuantity;

    /**
     * 下单人昵称
     */
    private String nickName;

    /**
     * 下单人手机号
     */
    private String phone;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 实付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 支付方式
     */
    private String paymentMethod;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 行数
     */
    private Integer lineNo;

    /**
     * 复星订单号
     */
    private String orderNo;

    /**
     * 1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功
     */
    private Integer status;

    /**
     * 退款标识 0.无退款 1.有退款
     */
    private Integer refundFlag;

    /**
     * 复星商品名称
     */
    private String fosunGoodsName;

    /**
     * 复星供应商名称
     */
    private String fosunSupplierName;

    /**
     * 商品分类
     */
    private String fosunGoodKind;

    /**
     * 商品规格
     */
    private String fosunGoodsSpec;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否匹配为正式订单是否匹配为正式订单，0未匹配，1匹配，2全部作废，3部分作废
     */
    private Integer matchFlag;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 订单导入状态0未导入，1导入
     */
    private Integer orderImportStatus;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 短信发送标识 0 否 1 是
     */
    private Integer smsFlag;


}
