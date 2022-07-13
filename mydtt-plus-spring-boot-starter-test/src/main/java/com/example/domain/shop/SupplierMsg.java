package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商家消息表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierMsg implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 消息类型 1:通知 2:消息
     */
    private Integer messageType;

    /**
     * 消息标题
     */
    private String messageTitle;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 1:未读 2:已读
     */
    private Integer messageStatus;

    /**
     * 跳转类型 0:无 1:页面 2:弹层
     */
    private Integer jumpType;

    /**
     * 跳转页面 1:开发票 2:新订单 3:库存预警商品
     */
    private Integer jumpPage;

    /**
     * 跳转参数
     */
    private String jumpParam;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除状态 0 未删除 1删除
     */
    private Integer deleteFlag;


}
