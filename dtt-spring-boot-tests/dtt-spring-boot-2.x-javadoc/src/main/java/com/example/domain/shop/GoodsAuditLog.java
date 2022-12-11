package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品审核日志表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-30
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class GoodsAuditLog implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 外部skuId
     */
    private String outSkuId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核人
     */
    private String auditUsername;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
