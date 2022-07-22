package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 运费模板内容
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarriageTemplateContent implements Serializable {

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
     * 大区名称
     */
    private String regionName;

    /**
     * 基本运费金额
     */
    private BigDecimal baseCarriageAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
