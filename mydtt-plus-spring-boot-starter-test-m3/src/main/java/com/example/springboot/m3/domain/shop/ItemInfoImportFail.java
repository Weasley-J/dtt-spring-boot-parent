package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品库导入失败数据
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemInfoImportFail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */

    private Integer id;

    /**
     * 内容
     */
    private String failContent;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 备注
     */
    private String remark;


}
