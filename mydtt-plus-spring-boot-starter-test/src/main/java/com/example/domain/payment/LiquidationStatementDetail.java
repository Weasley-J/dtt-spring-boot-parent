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
 * 结算单明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationStatementDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 结算单表ID
     */
    private Integer liquidationStatementId;

    /**
     * 账单表ID
     */
    private Integer liquidationBillId;

    /**
     * 业务来源0 商城，1疫苗
     */
    private Integer bizSource;

    /**
     * 三方处理状态 0 未发起 1 处理中 2 完成
     */
    private Integer thirdDetailProcessStatus;

    /**
     * 结算状态 0 未发起 1 处理中 2 结算成功 3 结算失败  4 异常
     */
    private Integer statementDetailStatus;

    /**
     * 交易流水号
     */
    private String transactionSerialNumber;

    /**
     * 结算通道:G 普通,Q 快速,R 实时-超网,输入空时默认为Q快速;
     */
    private String statementChannel;

    /**
     * 三方明细状态处理查询状态返回结果，如：BNK，WRF	银行处理中
     */
    private String thirdProcessingStatusResponse;

    /**
     * 三方明细处理结果，如：S	成功	银行支付成功
     */
    private String thirdProcessingResultResponse;

    /**
     * 异常手动处理 0 未操作 1 结算成功 2 结算失败
     */
    private Integer manualChangeStatus;

    /**
     * 异常手动处理备注
     */
    private String manualChangeRemark;

    /**
     * 回执单url
     */
    private String receiptFileUrl;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 操作人
     */
    private String updateUser;


}
