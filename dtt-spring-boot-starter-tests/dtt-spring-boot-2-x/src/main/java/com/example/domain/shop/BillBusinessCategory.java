package com.example.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 快钱经营类目表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class BillBusinessCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 经营类目编码
     */
    @TableId(value = "category_code", type = IdType.AUTO)
    private Integer categoryCode;

    /**
     * 经营类目名称
     */
    private String categoryName;

    /**
     * 类目级别 1-行业大类 2-行业小类
     */
    private Integer level;

    /**
     * 父类类目
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
