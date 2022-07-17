package com.example.springboot.m3.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
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

/**
 * <p>
 * 平台物流运费模板
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarriageTemplatePlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运费模板id
     */
    private Integer templateId;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 基本运费⾦额
     */
    private BigDecimal baseCarriageAmount;

    /**
     * 免运费阈值
     */
    private BigDecimal freeCarriageAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
