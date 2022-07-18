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
 * 开票订单临时表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InvoiceOrderTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联订单库订单编号
     */
    private String orderNo;

    /**
     * 发票抬头类型 1:个人 2:企业
     */
    private Integer invoiceTitle;

    /**
     * 发票抬头
     */
    private String customerName;

    /**
     * 纳税人识别号(个人为NULL)
     */
    private String customerCode;

    /**
     * 纳税人邮箱
     */
    private String customerEmail;

    /**
     * 发票类型：1:电子票 2:商家票
     */
    private Integer invoiceOrderType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
