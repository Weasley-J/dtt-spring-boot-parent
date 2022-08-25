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
import java.time.LocalDateTime;

/**
 * <p>
 * 订单操作日志
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日志编号
     */
    private String logNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退单编号
     */
    private String refundNo;

    /**
     * 接口url
     */
    private String url;

    /**
     * traceId
     */
    private String traceId;

    /**
     * 操作渠道 1.C端 2.E端 3.B端
     */
    private Integer operationChannel;

    /**
     * 操作类型 1.发货 2.创建退单 3.同意退货申请 4.确认退单 5.拒绝退单 6.订单列表导出
     */
    private Integer operationType;

    /**
     * 操作入参
     */
    private String operationReq;

    /**
     * 操作结果 1.成功 2.失败
     */
    private Integer operationResult;

    /**
     * 操作人
     */
    private String creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
