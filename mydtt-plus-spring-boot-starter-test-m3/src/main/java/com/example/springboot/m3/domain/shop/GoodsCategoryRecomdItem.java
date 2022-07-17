package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 类目推荐商品item表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor
public class GoodsCategoryRecomdItem implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 推荐位id
     */
    private Integer catRecommendId;

    /**
     * itemId
     */
    private Integer itemId;

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


}
