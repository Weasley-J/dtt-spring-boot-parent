package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 商品运费模板
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsCarriageTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运费模板名称
     */
    private String templateName;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 配送类型 0:自定义配送 1:全国配送
     */
    private Integer carriageType;

    /**
     * 全国默认运费
     */
    private BigDecimal carriageAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    @TableField("create_userId")
    private Integer createUserid;

    /**
     * 创建者
     */
    private String createUsername;

    /**
     * 模板类型 1:b2c 2:O2O配送 3:自提
     */
    private Integer templateType;

    /**
     * 有效状态 0:无效
     */
    private Integer templateStatus;

    /**
     * 起始距离(单位 米)
     */
    private Double startDistance;

    /**
     * 结束距离(单位 米)
     */
    private Double endDistance;

    /**
     * 开始配送时间
     */
    private LocalTime startTime;

    /**
     * 最后结束时间
     */
    private LocalTime endTime;

}
