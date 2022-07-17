package com.example.springboot.m3.domain.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: changyongchang.
 * @email: chang_y_c@163.com
 * @date: 2022/02/25 11:10
 * 商品标签表
 */
@Getter
@Setter
@NoArgsConstructor

public class ItemTag implements Serializable {


    private Integer id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 状态：0:启用 1：禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
