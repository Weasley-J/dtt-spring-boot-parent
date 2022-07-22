package com.example.domain.payment;

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
 * 税收分类编码表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InvoiceCatalogCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 后台类目ID（三级）
     */
    private Integer categoryId;

    /**
     * 商品分类编码
     */
    private String catalogCode;

    /**
     * 税收分类名称
     */
    private String catalogName;

    /**
     * 税率 只能为0、 0.03、0.04、0.06、0.10、0.11、0.16、0.17
     */
    private BigDecimal taxRate;

    /**
     * 零税率标识 1:免税,2:不征税,3:普通零税率
     */
    private Integer zeroTaxRate;

    /**
     * 优惠政策标识 0:不使用 1:使用
     */
    private Integer preferentialPolicy;

    /**
     * 政策标识名称
     */
    private String preferentialName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者名
     */
    private String updateId;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;


}
