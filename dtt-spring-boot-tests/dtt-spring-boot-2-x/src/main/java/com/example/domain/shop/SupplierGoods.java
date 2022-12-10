package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 云药房上架非本店商品关联表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * itemId
     */
    private Integer itemId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 操作人
     */
    private String updateUser;

    /**
     * 供应商来源 1商 城 2疫苗 3药店云(冗余supplier表)
     */
    private Integer supplierSource;

    /**
     * 上下架 1 上架 0 下架 (仅仅用于代销类的上下架管理)
     */
    private Integer onshelf;

    /**
     * 上架 一级类目 (与goods_onshelf表同步)
     */
    private Integer catgOne;

    /**
     * 上架 一级类目名称 (与goods_onshelf表同步)
     */
    private String catgOneName;

    /**
     * 上架 二级类目 (与goods_onshelf表同步)
     */
    private Integer catgTwo;

    /**
     * 上架 二级类目名称 (与goods_onshelf表同步)
     */
    private String catgTwoName;
}
