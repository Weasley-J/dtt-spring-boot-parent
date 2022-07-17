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
 * 发票订单商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InvoiceOrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * invoice_order主键
     */
    private Integer invoiceOrderid;

    /**
     * 权益包id
     */
    private Integer assetsPackageId;

    /**
     * skuId
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品总价格
     */
    private BigDecimal totalPrice;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品单位
     */
    private String goodsUnit;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
