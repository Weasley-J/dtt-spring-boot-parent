package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 资源位主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-14
 */
@Data

public class PromotionResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 资源位所载页面
     */
    private String resourcesSite;

    /**
     * 资源类型 1:顶部轮播  2:专区 3:金刚位 4:推荐分类5：首页弹框 6首页头部大促 7首页秒杀团购板块 8首页悬浮块
     */
    private Integer resourcesType;

    /**
     * 是否可下线 0:否 1:是
     */
    private Integer offlineStatus;

    /**
     * 是否禁用 0:否 1:是
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
