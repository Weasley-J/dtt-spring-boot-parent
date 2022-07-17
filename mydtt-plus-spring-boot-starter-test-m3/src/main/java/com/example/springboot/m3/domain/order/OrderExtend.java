package com.example.springboot.m3.domain.order;

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
 * 订单附加信息表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 保障服务id
     */
    private String insuranceServiceId;

    /**
     * 保障服务code
     */
    private String insuranceServiceCode;

    /**
     * 保障服务名称
     */
    private String insuranceServiceName;

    /**
     * 支付跳转链接
     */
    private String payUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 核销码
     */
    private String selfLiftingCode;

    /**
     * 1 已核销，0为核销
     */
    private Integer selfLiftingCodeStatus;

    /**
     * 三方订单号(复联)
     */
    private String thirdOrderNo;

    /**
     * 听力师id
     */
    private String audiologistOutMemberId;

    /**
     * 听力师订单类型 0推荐订单 1代下订单
     */
    private Integer orderAudiologistType;

    /**
     * 三方商户编码
     */
    private String thirdCode;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 店铺每日订单序号
     */
    private Integer daySerialNumber;

    /**
     * 处方是否需要二审 0:不需要  1：需要
     */
    private Integer inquiryReview;

    /**
     * 自提预留手机号
     */
    private String reservedMobile;

}
