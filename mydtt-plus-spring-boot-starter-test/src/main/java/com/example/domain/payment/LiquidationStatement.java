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
 * 结算单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiquidationStatement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务来源0 商城，1疫苗
     */
    private Integer bizSource;

    /**
     * 结算单状态 0 待付款  1 付款中 2 付款操作完成 5 已取消
     */
    private Integer statementStatus;

    /**
     * 三方处理状态 0 未发起 1 处理中 2 完成
     */
    private Integer thirdBatchProcessStatus;

    /**
     * 明细笔数
     */
    private Integer statementDetailCount;

    /**
     * 付款成功笔数
     */
    private Integer detailSuccessCount;

    /**
     * 付款失败笔数
     */
    private Integer detailFailCount;

    /**
     * 付款异常笔数
     */
    private Integer detailErrorCount;

    /**
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 提交结算总金额
     */
    private BigDecimal totalAmount;

    /**
     * 结算成功金额
     */
    private BigDecimal statementSuccessAmount;

    /**
     * 出款账号
     */
    private String paymentAccountNo;


    /**
     * 出款方分行号
     */
    private Integer paymentBankBranchNo;

    /**
     * 用途
     */
    private String bizUsage;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 三方请求付款操作response结果
     */
    private String submitThirdResponse;

    /**
     * 三方状态处理查询状态返回结果，如：OPR 接收中
     */
    private String thirdProcessingStatusResponse;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
