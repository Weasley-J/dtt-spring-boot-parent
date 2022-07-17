package com.example.springboot.m3.domain.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 延迟发货
 *
 * @author: xuyongsheng
 * @date: 2021/11/03
 **/
@Data
public class OrderBatchShipReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单商品
     */
    private List<OrderExpress> orderExpressList;

    /**
     * 快递100物流公司ID
     */
    private String comCodeKdyb;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 快递单号
     */
    private String invoiceNo;
}
