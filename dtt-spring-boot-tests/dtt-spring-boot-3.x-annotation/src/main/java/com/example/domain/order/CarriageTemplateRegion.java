package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 区域模板内容
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarriageTemplateRegion implements Serializable {

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
    @NotBlank(message = "区域不能为空")
    private String regionName;

    /**
     * 基本运费金额
     */
    @NotNull(message = "运费金额不能为空")
    @Min(value = 0, message = "运费金额不能小于0")
    private BigDecimal baseCarriageAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
