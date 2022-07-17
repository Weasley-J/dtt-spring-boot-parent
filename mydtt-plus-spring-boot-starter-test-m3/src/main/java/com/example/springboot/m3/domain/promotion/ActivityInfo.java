package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 活动主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动类型：1 专场活动 2 优惠券活动
     */
    private Integer activityType;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动状态：1 未开始 2 进行中 3 已结束
     */
    private Integer activityStatus;

    /**
     * 审核状态：1 单审核 2 审核通过 3 驳回
     */
    private Integer auditStatus;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;

    /**
     * 审核者用户名
     */
    private String auditUsername;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 队列标志位
     */
    private Integer messageFlag;


}
