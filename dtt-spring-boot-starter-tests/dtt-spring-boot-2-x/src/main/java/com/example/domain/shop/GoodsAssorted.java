package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 组合商品表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsAssorted implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 主品SKUID
     */
    private String skuId;

    /**
     * 子品SKUID
     */
    private String sonSkuId;

    /**
     * 物料编码
     */
    private String materialId;

    /**
     * 子品数量
     */
    private Integer quantity;

    /**
     * 类型: 1-商城,2-OMS
     */
    private Integer type;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最近操作人
     */
    private String updater;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;


}
