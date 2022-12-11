package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品展示类目表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 运营后台类目名称
     */
    private String name;

    /**
     * 类目级别 1 一级类目 2 二级类目
     */
    private Integer level;

    /**
     * 类目图片
     */
    private String picUrl;

    /**
     * 是否金刚位 0 不是 1 是金刚位
     */
    private Integer kingKongFlag;

    /**
     * 金刚位图片
     */
    private String kingKongUrl;

    /**
     * 是否推荐 0 不推荐 1 推荐
     */
    private Integer recommendFlag;

    /**
     * 推荐图片
     */
    private String recommendUrl;

    /**
     * 父类类目
     */
    private Integer parentId;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 是否有商品 0 没有， 1 有
     */
    private Integer hasGoods;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 供应商id
     */
    private Integer supplierId;


}
