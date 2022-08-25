package com.example.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品分账配置表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsSharingConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 分类 1 - 类目  2 -商品 3- 店铺 4-联锁
     */
    private Integer configType;

    /**
     * 连锁店
     */
    private Integer multipleSupplierId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 一级类目
     */
    private String outCategoryOne;

    /**
     * 二级类目
     */
    private String outCategoryTwo;

    /**
     * 三级类目
     */
    private String outCategoryThree;

    /**
     * 规则比例，json数组: 例如[{"supplier_id":1,"proportion":10}]
     */
    private String ruleProportion;

    /**
     * 唯一幂等键 supplier_id + multiple_supplier_id + sku_id + out_category_three
     */
    private String idempotentId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最近操作人
     */
    private String updater;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
