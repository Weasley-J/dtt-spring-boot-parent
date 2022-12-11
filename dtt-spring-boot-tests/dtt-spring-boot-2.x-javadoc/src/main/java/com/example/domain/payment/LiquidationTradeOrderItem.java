package com.example.domain.payment;

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
 * 清算子订单表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationTradeOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 清算订单表ID
     */
    private Integer liquidationTradeOrderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退单号
     */
    private String refundOrderNo;

    /**
     * 商品交易流水号（每次落库生成，退款基于原始的）
     */
    private String orderItemTransactionNo;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * SKUID
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品
     */
    private Integer goodsKind;

    /**
     * 商品类型:0 默认，1 全球购，2医生端权益，3消费端权益，4 疫苗
     */
    private Integer goodsType;

    /**
     * 商品总金额：零售价 * 数量
     */
    private BigDecimal totalAmount;

    /**
     * 商品交易金额（实际付款分摊的金额）
     */
    private BigDecimal tradeAmount;

    /**
     * 平台佣金率
     */
    private BigDecimal platformCommissionRatio;

    /**
     * 平台佣金
     */
    private BigDecimal platformCommissionAmount;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * item内部项类型：0默认商品，1运费
     */
    private Integer itemInternalType;
}
