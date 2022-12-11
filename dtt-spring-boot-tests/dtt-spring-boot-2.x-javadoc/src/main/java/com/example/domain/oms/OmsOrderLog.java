package com.example.domain.oms;

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
 * oms订单处理日志
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 出库单号/采购单号
     */
    private String wmsOrderNo;

    /**
     * 处方编号
     */
    private String presNumber;

    /**
     * 补发单号
     */
    private String reissuedNo;

    /**
     * 退货单号
     */
    private String refundNo;

    /**
     * 日志节点 1:创建订单,2:推送中宝审方,3:接收审方结果,4:出库单推送WMS,5:接收出库结果,6:调用平台发货,7:出库取消 8
     */
    private Integer logPoint;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;


}
