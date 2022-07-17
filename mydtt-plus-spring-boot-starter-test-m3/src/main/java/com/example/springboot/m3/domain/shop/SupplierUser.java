package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 供应商用户管理
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-25
 */
@Data

public class SupplierUser implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0 禁用 1 启用
     */
    private Integer enable;

    /**
     * 账号类型 1 门店账号 0 连锁店账号'
     */
    private Integer userType;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createUsername;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
