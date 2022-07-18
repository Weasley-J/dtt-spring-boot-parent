package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品库存与价格
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SkuStock implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 外部商品编码(规格编码)
     */
    private String outSkuId;

    /**
     * 门店级别sku_id
     */
    private String shopSkuId;

    /**
     * itemId
     */
    private Integer itemId;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 锁定库存
     */
    private Integer lockedStock;

    /**
     * 店铺id
     */
    private Integer supplierId;

    /**
     * 电商1上架 0下架
     */
    private Integer onshelf;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 操作⼈
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

}
