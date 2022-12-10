package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品类目映射
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsCategoryMapping implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 科室
     */
    private String outDept;

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
     * 一级类目
     */
    private Integer categoryOne;

    /**
     * 一级类目名称
     */
    private String categoryOneName;

    /**
     * 二级类目
     */
    private Integer categoryTwo;

    /**
     * 二级类目名称
     */
    private String categoryTwoName;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 删除状态 0 未删除 1 已删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
