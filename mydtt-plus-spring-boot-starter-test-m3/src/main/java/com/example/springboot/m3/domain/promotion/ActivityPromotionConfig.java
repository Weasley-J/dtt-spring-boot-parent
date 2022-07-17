package com.example.springboot.m3.domain.promotion;

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
 * 促销活动配置表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivityPromotionConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分
     */
    private Integer activityType;

    /**
     * 活动名称
     */
    private String activityName;

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
     * 活动状态：1 未开始 2 进行中 3 已结束4 未启用(手动停用)
     */
    private Integer activityStatus;

    /**
     * 是否互斥 1:是 0否
     */
    private Integer mutexType;

    /**
     * 活动店铺id
     */
    private Integer supplierId;

    /**
     * 1 显示 0 不显示
     */
    private Integer isShow;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者名
     */
    private String creatorName;


}
