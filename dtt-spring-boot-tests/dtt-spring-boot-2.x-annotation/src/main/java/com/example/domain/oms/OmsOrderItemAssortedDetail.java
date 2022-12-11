package com.example.domain.oms;

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
 * oms订单组合商品明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderItemAssortedDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号;主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单唯一编号;订单主键
     */
    private Integer orderId;

    /**
     * 商品唯一编号;订单商品主键
     */
    private Integer itemId;

    /**
     * 订单号;订单号
     */
    private String orderNo;

    /**
     * SPU编号;goods id
     */
    private Integer goodsId;

    /**
     * 商品系统item_id
     */
    private Integer goodsItemId;

    /**
     * 主品SKUID
     */
    private String skuId;

    /**
     * 子品sku id
     */
    private String sonSkuId;

    /**
     * 名称;商品名称
     */
    private String goodsName;

    /**
     * 规格;商品规格
     */
    private String goodsSpec;

    /**
     * 单位;商品单位：盒、袋
     */
    private String goodsUnit;

    /**
     * 主图;列表的主图
     */
    private String mainPic;

    /**
     * 数量;商品数量
     */
    private Integer goodsNum;

    /**
     * 零售价;零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价;进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 总金额;商品金额
     */
    private BigDecimal totalAmount;

    /**
     * 分摊金额;商品分摊金额
     */
    private BigDecimal shareAmount;

    /**
     * 是否主品;是否主品 0否,1是
     */
    private Integer assortedFlag;

    /**
     * 创建时间;创建时间
     */
    private LocalDateTime createTime;


}
