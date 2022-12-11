package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 库存交易表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemSkuStockTrade implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 门店ID
     */
    private Integer supplierId;

    /**
     * 单据类型 1 销售出库单 2 采购退供应商出库单 3 调拨出库单 4 采购入库单 5 退换货入库单 6 批发出库单 7 库存转换单 8调拨入库单 100 其他；	交易类型 1收货 2取消收货 3上架 4出库 5损溢 6移库 7转换 8转移 9冻结释放 10返拣 11加工；41锁定 42释放 43扣减
     */
    private Integer type;

    /**
     * 交易数量
     */
    private Integer stock;

    /**
     * 来源编码
     */
    private String sourceNo;

    /**
     * 来源唯一编码
     */
    private String sourceId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
