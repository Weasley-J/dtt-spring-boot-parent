package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品上下架审核
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class GoodsOnshelfApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 审核状态: 1 待审核 2 审核通过 3 拒绝
     */
    private Integer auditStatus;

    /**
     * 审核人
     */
    private String auditUsername;

    /**
     * 审核拒绝原因
     */
    private String auditReason;

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


}
