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

/**
 * <p>
 * 运费模板
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarriageTemplate implements Serializable {

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
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 商家后台
     */
    private Integer platformId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 免运费阈值
     */
    private BigDecimal freeCarriageAmount;

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
     * 模板类型 1:云药房模板 2:O2O配送 3:物流配送
     */
    private Integer templateType;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

}
