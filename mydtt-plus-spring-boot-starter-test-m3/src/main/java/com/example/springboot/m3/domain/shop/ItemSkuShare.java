package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品库sku分享码表
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemSkuShare implements Serializable {


    private Integer id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 商户id
     */
    private Integer supplierId;

    /**
     * 分享链接url
     */
    private String shareUrl;

    /**
     * 分享二维码图片
     */
    private String shareImg;

    /**
     * 是否删除 1:删除
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
