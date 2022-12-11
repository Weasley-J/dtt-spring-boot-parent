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
public class OrderInquiry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 处方类型：0后置，1前置，2后置IM 3汉利康
     */
    private Integer inquiryType;

    /**
     * 处方实际审核流：0 一审，1 二审，2 中宝二审
     */
    private Integer roamStatus;

    /**
     * 处方编号
     */
    private String presNumber;

    /**
     * 处方标记：0 默认处方，1 主处方
     */
    private Integer inquirySign;

    /**
     * 审核流：0 默认一审，1 二审，2 中宝二审 3 国大 4 三方
     */
    private Integer checkFlow;

    /**
     * 处方关联编号（主处方对应订单关联编号一致，默认处方按订单号存储）
     */
    private String relevanceNo;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 医生名字
     */
    private String doctorName;

    /**
     * 处方id
     */
    private String prescriptionId;

    /**
     * 处方创建时间
     */
    private LocalDateTime prescriptionDate;

    /**
     * 问诊开处方调用结果
     */
    private String prescribeResult;

    /**
     * 原处方id
     */
    private String originalPrescriptionId;

    /**
     * 处方审核状态 0：待审核 1：成功 -1：失败 2：审核中 3：拆方中 4:流转中
     */
    private Integer checkStatus;

    /**
     * 审核消息
     */
    private String checkMsg;

    /**
     * 处方二审状态：0 无需二审，1 待二审，2 二审中，3 二审成功，4 二审失败
     */
    private Integer secondCheckStatus;

    /**
     * 二审消息
     */
    private String secondCheckMsg;

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
     * 是否复诊/线下医院就诊过 0：否 1：是
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
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 互联网医院咨询单号
     */
    private String consultOrderId;

    /**
     * 互联网医院问诊单状态:0,无;1,待接诊;2,超时;3,正常结束问诊;4,交流中;5,未开处方且医生主动结束问诊;6,用户退款,关闭问诊单
     */
    private Integer consultStatus;

    /**
     * 互联网医院问诊单创建时间
     */
    private LocalDateTime consultDate;


}
