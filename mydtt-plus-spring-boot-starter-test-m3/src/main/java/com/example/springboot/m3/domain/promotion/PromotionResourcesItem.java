package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 资源位详情表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PromotionResourcesItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源位id
     */
    private Integer promotionResourcesId;

    /**
     * 资源图片
     */
    private String resourceImageUrl;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 跳转类型 0:不跳转 1:跳转 2:端内活动
     */
    private Integer jumpType;

    /**
     * 跳转链接
     */
    private String jumpUrl;

    /**
     * 删除状态， 下架即删除 0 上架 1 下架  2待上架
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

    private Integer platformId;

    /**
     * 资源位所载页面
     */
    private String resourcesSite;

    /**
     * 弹出框名称
     */
    private String resourcesName;

    /**
     * 弹框展示开始时间
     */
    private LocalDateTime startTime;

    /**
     * 弹框展示结束时间
     */
    private LocalDateTime endTime;

    /**
     * 是否登录 0 否  1 是
     */
    private Integer isLogin;

    /**
     * 展示次数 0 一次 1无限次
     */
    private Integer showCounts;

    /**
     * 是否清楚缓存 0 否 1是
     */
    private Integer clearCache;

    /**
     * 关闭条件 0 手动 1 自动
     */
    private Integer closeTerm;

    /**
     * 自动关闭时间(1-10秒)
     */
    private Integer autoCloseTime;

    /**
     * 供应商id(与supplier一致)
     */
    private Integer supplierId;

    /**
     * 背景图片
     */
    private String backgroudUrl;

    /**
     * 资源图片2
     */
    private String resourceImage2Url;

    /**
     * 跳转类型 0:不跳转 1:跳转 2:端内活动
     */
    private Integer jump2Type;

    /**
     * 资源图片2跳转链接
     */
    private String jump2Url;

}
