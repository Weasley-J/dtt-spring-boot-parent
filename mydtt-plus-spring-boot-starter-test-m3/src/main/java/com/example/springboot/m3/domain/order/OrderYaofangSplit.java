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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 药房网订单分单表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderYaofangSplit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 原订单id
     */
    private Integer originalOrderId;

    /**
     * 原订单号
     */
    private String originalOrderNo;

    /**
     * 分单订单号
     */
    private String splitOrderNo;

    /**
     * 处方类型：0后置，1前置
     */
    private Integer inquiryType;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 外部skuId
     */
    private String outSkuId;

    /**
     * 快递单号
     */
    private String invoiceNo;

    /**
     * 物流公司code
     */
    private String expressCode;

    /**
     * 物流公司名称
     */
    private String expressCompany;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiverTime;

    /**
     * 处方id
     */
    private String prescriptionId;

    /**
     * 处方审核状态 0：待审核 1：成功 -1：失败 2：审核中
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
     * 医生名字
     */
    private String doctorName;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 用药人姓名
     */
    private String patientName;

    /**
     * 用药人身份证
     */
    private String patientIdCard;

    /**
     * 用药人图片信息
     */
    private String patientPhoto;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别 0：未知 1：男，2：女
     */
    private Integer gender;

    /**
     * 监护人姓名
     */
    private String guardName;

    /**
     * 监护人身份证
     */
    private String guardIdCard;

    /**
     * 与本人关系（直接存字符串）
     */
    private String relation;

    /**
     * 其他病史,多个逗号分隔
     */
    private String medicalHistory;

    /**
     * 线下确诊疾病,多个逗号分隔
     */
    private String illnessOffline;

    /**
     * 线下确诊疾病id,多个逗号分隔
     */
    private String illnessOfflineId;

    /**
     * 曾用过本次药品 0：否 1：是
     */
    private Integer usedBefore;

    /**
     * 有不良反应 0：否 1：是
     */
    private Integer adverseReaction;

    /**
     * 线下医院就诊过 0：否 1：是
     */
    private Integer treatmentOffline;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 问诊开处方调用结果
     */
    private String prescribeResult;

    /**
     * 商品数量
     */
    private Integer goodsNum;


}
