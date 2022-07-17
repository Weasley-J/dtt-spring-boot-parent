package com.example.springboot.m3.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * @Description:
 * @Author: 魏朝阳
 * @CreateDate: 2021/9/16 15:29
 * @UpdateDate: 2021/9/16 15:29
 */
@Data
public class NearPharmacyDto {
    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 简称
     */
    private String abbrName;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 距离
     */
    private Double distance;
    /**
     * logo图片
     */
    private String logoUrl;
    /**
     * 1:b2c 2:O2O配送 3:自提
     */
    private String templateType;
    /**
     * 店铺经度
     */
    private double lng;

    /**
     * 店铺纬度
     */
    private double lat;

    /**
     * 起始距离(单位 米)
     */
    private BigDecimal startDistance;

    /**
     * 结束距离(单位 米)
     */
    private BigDecimal endDistance;

    /**
     * 开始配送时间
     */
    private LocalTime startTime;

    /**
     * 最后结束时间
     */
    private LocalTime endTime;
}
