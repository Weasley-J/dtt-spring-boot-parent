package com.example.springboot.m3.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 全球购订单信息表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderGlobalBuy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 海关清单编号
     */
    private String customsBillNo;

    /**
     * 单据状态: 0 默认，1 处理中，2 已放行，3 清关异常
     */
    private Integer billStatus;

    /**
     * 支付通关状态 0 未提交 1 未申报，2 申报中，3 申报成功， 4 申报失败
     */
    private Integer payCustomStatus;

    /**
     * 外部业务单据状态code
     */
    private String outStatusCode;

    /**
     * 外部业务单据状态描述
     */
    private String outStatusDesc;

    /**
     * 外部业务单据状态时间
     */
    private LocalDateTime outStatusDate;

    /**
     * 外部核放单据状态code
     */
    private String outDistStatusCode;

    /**
     * 外部核放单据状态描述
     */
    private String outDistStatusDesc;

    /**
     * 外部核放单据状态时间
     */
    private LocalDateTime outDistStatusDate;

    /**
     * 首次推送时间
     */
    private LocalDateTime firstPushDate;

    /**
     * 最后推送时间
     */
    private LocalDateTime lastPushDate;

    /**
     * 收货人实名
     */
    private String receiverRealName;

    /**
     * 收货人身份证
     */
    private String receiverIdCard;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 链路状态 0 -未执行支付  1-支付推送   2-支付推送失败 3- 支付查询 4-查询失败  5- 物流单号获取  6-物流单号获取失败
     * 7- 物流单推送海关  8-物流单推送海关失败   9-订单推送  10-订单推送失败 11-订单查询  12- 订单查询失败
     * 100-推送成功
     */
    private Integer linkStatus;

    /**
     * 链路入参数据
     */
    private String linkContent;

    /**
     * 当前链路服务名称
     */
    private String linkServiceName;


}
