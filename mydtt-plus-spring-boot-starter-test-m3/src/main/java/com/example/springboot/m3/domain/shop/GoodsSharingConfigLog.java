package com.example.springboot.m3.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品分账配置表操作日志
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsSharingConfigLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    private Integer sharingConfigId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 连锁店
     */
    private Integer multipleSupplierId;

    /**
     * 分类 1 - 类目  2 -商品
     */
    private Integer configType;

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
     * 类型 ： 0-新增  ，1- 删除 2-编辑
     */
    private Integer status;

    /**
     * 最近操作人
     */
    private String updater;

    private LocalDateTime createTime;


}
