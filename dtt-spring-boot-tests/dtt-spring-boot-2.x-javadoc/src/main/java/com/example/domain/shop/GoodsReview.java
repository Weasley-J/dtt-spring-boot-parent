package com.example.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsReview implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 订单id
     */
    private Integer orderId;

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
     * 未评价 0，评价等级 1-5;1-2颗星为差评，3颗星为中评，4-5颗星为好评
     */
    private Integer reviewLevel;

    /**
     * 是否匿名评价 0,否;1,是
     */
    private Integer anonymity;

    /**
     * 评价图片
     */
    private String picUrl;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
