package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 广告位配置附属表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class AdsenseConfigureItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 广告位id
     */
    private Integer adsenseId;

    /**
     * 类型 1-分类 2-商品
     */
    private Integer type;

    /**
     * 商品skuId
     */
    private String skuId;

    /**
     * 分类id
     */
    private Integer categoryId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
