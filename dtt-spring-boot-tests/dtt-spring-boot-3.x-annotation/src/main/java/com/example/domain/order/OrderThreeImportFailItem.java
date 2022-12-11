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
 * 三方订单批次失败详细表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderThreeImportFailItem implements Serializable {

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
     * 渠道售价
     */
    private BigDecimal channelProductPrice;

    /**
     * 复星skuId
     */
    private String skuId;

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
     * 行数
     */
    private Integer lineNo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 失败原因
     */
    private String failMessage;

    /**
     * 复星订单号
     */
    private String orderNo;

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
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
