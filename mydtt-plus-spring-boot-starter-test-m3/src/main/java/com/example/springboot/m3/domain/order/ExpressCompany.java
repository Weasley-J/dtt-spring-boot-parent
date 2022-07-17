package com.example.springboot.m3.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 物流公司
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpressCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物流公司code
     */
    private String expressCode;

    /**
     * 物流公司名称
     */
    private String expressCompany;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 快递网物流公司code
     */
    private String comCodeKdw;

    /**
     * 快递100物流公司ID
     */
    private String comCodeKdyb;

    /**
     * 是否默认 0默认 1 不默认(用于第三方模糊匹配重复的场景)
     */
    private Integer defaultFlag;

    /**
     * oms快递公司id
     */
    private Integer omsExpressCompanyId;

}
