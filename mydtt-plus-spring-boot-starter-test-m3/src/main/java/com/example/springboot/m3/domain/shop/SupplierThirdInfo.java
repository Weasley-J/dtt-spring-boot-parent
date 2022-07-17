package com.example.springboot.m3.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商户三方信息表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierThirdInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户表主键
     */
    @TableId(value = "supplier_id", type = IdType.INPUT)
    private Integer supplierId;

    /**
     * 三方商户编码
     */
    private String thirdCode;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 机构编码
     */
    private String organizationCode;

    /**
     * 机构名称
     */
    private String organizationName;

    /**
     * 三方门店状态 0 关闭 1 营业 2 停业
     */
    private Integer status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 仓库id 废弃 使用item_info.warehouse_code
     */
    private String wmsWarehouseId;

//    /**
//     * 仓库名称
//     */
//    private String wmsWarehouseName;


    /**
     * 处方是否需要二审 0:不需要  1：需要
     */
    private Integer inquiryReview;

    /**
     * 是否支持代发 0否 1是
     */
    private Integer sendFlag;

    /**
     * 仓库名称 废弃 使用item_info.warehouse_name
     */
    private String wmsWarehouseName;


}
