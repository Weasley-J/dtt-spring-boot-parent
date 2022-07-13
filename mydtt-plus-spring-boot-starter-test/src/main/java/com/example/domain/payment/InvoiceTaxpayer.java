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
import java.time.LocalDateTime;

/**
 * <p>
 * 销货方信息表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InvoiceTaxpayer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 销货方纳税人识别号
     */
    private String taxpayerCode;

    /**
     * 销货方纳税人名称
     */
    private String taxpayerName;


    /**
     * 销货方电话
     */
    private String taxpayerBankName;

    /**
     * 销货方开户银行
     */
    private String taxpayerBankAccount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private String taxpayerAddress;

    private String billingTaxName;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;


}
