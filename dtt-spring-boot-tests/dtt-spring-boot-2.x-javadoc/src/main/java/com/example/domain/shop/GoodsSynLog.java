package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品同步表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsSynLog implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 外部skuId
     */
    private String outSkuId;

    /**
     * 供应商类型 1阿康 2康爱多 3 国药 4自营
     */
    private Integer supplierType;

    /**
     * 0 未同步或失败 1成功 2库存同步失败 3库存同步成功
     */
    private Integer isSuccess;

    /**
     * 备注或失败原因
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
