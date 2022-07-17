package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 广告位配置
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class AdsenseConfigure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 广告名称
     */
    private String adsenseName;

    /**
     * 广告图
     */
    private String adsensePic;

    /**
     * 广告位类型 1 - 弹窗类型  2 - 通用类型 3 - 定制类型
     */
    private Integer adsenseType;

    /**
     * 类型 ： 1- 启用 ，0- 禁用
     */
    private Integer status;

    /**
     * 跳转类型 0-不跳转 1-自定义url跳转 2-跳转到端内活动 3-跳转到类目
     */
    private Integer jumpType;

    /**
     * 跳转url
     */
    private String jumpUrl;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最近操作人
     */
    private String updater;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
