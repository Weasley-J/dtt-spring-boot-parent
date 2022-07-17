package com.example.springboot.m3.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单问诊记录
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderInquiry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 处方类型：0后置，1前置，2后置IM
     */
    private Integer inquiryType;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 处方id
     */
    private String prescriptionId;

    /**
     * 处方编号
     */
    private String presNumber;

    /**
     * 审核流：0 默认一审，1 二审，2 中宝二审 3 国大二审
     */
    private Integer checkFlow;

    /**
     * 中宝审核状态 0：待审核， 1：成功， -1：失败，2：审核中，3: 调用中宝接口失败
     */
    private Integer zbCheckStatus;

    /**
     * 中宝审核消息
     */
    private String zbCheckMsg;

    /**
     * 审核状态 0：待审核 1：成功 -1：失败 2：审核中
     */
    private Integer checkStatus;

    /**
     * 审核消息
     */
    private String checkMsg;

    /**
     * 问诊结果(图片)
     */
    private String resultImg;

    /**
     * 问诊结果(pdf)
     */
    private String resultPdf;

    /**
     * 用药人档案id(对接互联网医院的)
     */
    private String patientId;

    /**
     * 用药人姓名
     */
    private String patientName;

    /**
     * 用药人身份证
     */
    private String patientIdCard;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别 0：未知 1：男，2：女
     */
    private Integer gender;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
