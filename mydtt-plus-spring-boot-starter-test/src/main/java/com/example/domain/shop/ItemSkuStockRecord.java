package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 库存记录表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemSkuStockRecord implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 门店ID
     */
    private Integer supplierId;

    /**
     * 1：库存查询 2：库存交易 41：库存锁定 42：库存释放
     */
    private Integer type;

    /**
     * 原始库存
     */
    private Integer orgStock;

    /**
     * 原始锁定库存
     */
    private Integer orgLockedStock;

    /**
     * 同步库存
     */
    private Integer synStock;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private String createUser;


}
