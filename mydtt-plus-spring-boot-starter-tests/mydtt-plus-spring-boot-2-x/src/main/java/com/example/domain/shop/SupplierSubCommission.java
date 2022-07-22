package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 店铺关联分佣比例表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierSubCommission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 主商户
     */
    private Integer supplierId;

    /**
     * 关联商户
     */
    private Integer relateSupplierId;

    /**
     * 分佣比例(%)
     */
    private BigDecimal commission;

    /**
     * 删除状态 0 未删除 1删除
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
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 连锁店平台分账比例
     */
    private BigDecimal superPlatformCommission;

    /**
     * 当前店铺分账比例
     */
    private BigDecimal supplyCommission;

    /**
     * 0 多关联店铺   1 连锁
     */
    private BigDecimal supplyType;


}
