package com.example.domain.order;

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
 * o2o运费模板
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarriageTemplateShop implements Serializable {

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
     * 距离
     */
    private BigDecimal distance;

    /**
     * 基本运费额
     */
    private BigDecimal baseCarriageAmount;

    /**
     * 开始配送时间
     */
    private String startTime;

    /**
     * 最后结束时间
     */
    private String endTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 配送服务方：0 商户，1 美团
     */
    private Integer deliveryServiceProvider;

    /**
     * 配送服务包code
     */
    private String deliveryServiceCode;

}
