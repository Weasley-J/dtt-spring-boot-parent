package com.example.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专场item
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpecialItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专场id
     */
    private Integer specialId;

    /**
     * 活动表id或许goods
     */
    private Integer itemId;

    /**
     * 状态类型 1 活动 2 专场 3 自选商品
     */
    private Integer itemType;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 专场主图
     */
    private String mainPic;


}
