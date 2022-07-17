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
 *
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsDrugNameList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 本地关联表id
     */
    private Integer localId;

    /**
     * 本地关联表父级id
     */
    private Integer parentId;

    /**
     * 类型 1-药品白名单 2-sku黑名单
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
