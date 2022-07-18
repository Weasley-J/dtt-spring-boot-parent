package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品上下架
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsOnshelf implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * goods id
     */
    private Integer goodsId;

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
     * 是否推荐 0 不推荐 1 推荐
     */
    private Integer recommendFlag;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 是否露出 1露出 0 不露出
     */
    private Integer showFlag;

    /**
     * 连锁店ID
     */
    private Integer supplierId;

    /**
     * 商详也是否可购买 0 否 1 是
     */
    private Integer buyFlag;

    /**
     * 删除状态， 下架即删除 0 上架 1 下架
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateUser;


}
