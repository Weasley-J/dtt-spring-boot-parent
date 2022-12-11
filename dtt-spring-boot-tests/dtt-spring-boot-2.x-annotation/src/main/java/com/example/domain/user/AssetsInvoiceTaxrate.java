package com.example.domain.user;

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
 * 服务包项税率配置表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsInvoiceTaxrate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务包id
     */
    private Integer packageId;

    /**
     * 权益包项ID
     */
    private Integer itemId;

    /**
     * 名称
     */
    private String serviceName;

    /**
     * 商品税收分类编码
     */
    private String catalogCode;

    /**
     * 商品税收分类简称
     */
    private String catalogAbbrName;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 开票金额占比
     */
    private BigDecimal amountRate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;


}
