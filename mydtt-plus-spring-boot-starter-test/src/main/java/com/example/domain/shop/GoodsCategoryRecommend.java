package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品类目表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-13
 */
@Data


public class GoodsCategoryRecommend implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 推荐类型 1 金刚位 2 推荐（严选）
     */
    private Integer recommendType;

    /**
     * 跳转类型 0-不跳转 1-自定义url跳转 2-跳转到类目 3-跳转到端内活动
     */
    private Integer jumpType;

    /**
     * 前台类目id
     */
    private Integer categoryId;

    /**
     * 前台类目 前台类目id(为0时表示自定义名称)
     */
    private String categoryName;

    /**
     * 前台类目级别 1 一级类目 2 二级类目
     */
    private Integer categoryLevel;

    /**
     * 图片
     */
    private String picUrl;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 删除标志 1 已删除 0 未删除
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
     * 操作人
     */
    private String operatorName;

    /**
     * 供应商id(与supplier一致)
     */
    private Integer supplierId;

    /**
     * 跳转链接
     */
    private String jumpUrl;

}
