package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 京东订单信息
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderJdInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电商订单id
     */
    private Integer orderId;

    /**
     * 电商订单号
     */
    private String orderNo;

    /**
     * 京东父单id
     */
    private String pOrderId;

    /**
     * 京东订单id
     */
    private String jdOrderId;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 订单总金额（不包含运费）
     */
    private BigDecimal orderPrice;

    /**
     * 订单税额
     */
    private BigDecimal orderTaxPrice;

    /**
     * 订单状态。0为取消订单  1为有效。
     */
    private Integer orderState;

    /**
     * 物流状态。0 是新建  1是妥投   2是拒收
     */
    private Integer state;

    /**
     * 预占确认状态。0没确认预占;1已确认预占
     */
    private Integer submitState;

    /**
     * 京东订单状态 1.新单;2.等待支付;3.等待支付确认;4.延迟付款确认;5.订单暂停;6.店长最终审核;7.等待打印;8.等待出库;9.等待打包;10.等待发货;11.自提途中;12.上门提货;13.自提退货;14.确认自提;16.等待确认收货;17.配送退货;18.货到付款确认;19.已完成;21.收款确认;22.锁定;29.等待三方出库;30.等待三方发货;31.等待三方发货完成
     */
    private Integer jdOrderState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单完成时间
     */
    private LocalDateTime finishTime;


}
