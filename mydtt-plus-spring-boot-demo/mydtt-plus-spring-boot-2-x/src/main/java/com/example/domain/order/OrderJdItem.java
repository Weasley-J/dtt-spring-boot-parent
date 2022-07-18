package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 京东订单商品信息
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderJdItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电商订单id
     */
    private Integer orderId;

    /**
     * 电商订单号
     */
    private String orderNo;

    /**
     * 京东订单号(order_jd_info中jd_order_id)
     */
    private String jdOrderId;

    /**
     * 京东sku
     */
    private String skuId;

    /**
     * 商城sku
     */
    private String mallSkuId;

    /**
     * 京东3级类目id
     */
    private Integer category;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 购买商品数量(原始购买数量)
     */
    private Integer goodsNum;

    /**
     * 商品类型  0 普通、1 附件、2 赠品、3延保
     */
    private Integer goodsType;

    /**
     * 主商品ID
     */
    private String goodsOid;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
