package com.example.domain.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 权益卡配置表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsCardTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 卡基础类型 0 常规卡 1 礼品卡
     */
    private Integer baseType;

    /**
     * 权益卡名称
     */
    private String cardName;

    /**
     * 权益卡描述
     */
    private String cardDesc;

    /**
     * 权益卡样式图片
     */
    private String cardStyleImg;

    /**
     * 0 禁用 1 启用
     */
    private Integer cardStatus;

    /**
     * 卡激活方式 0 手动激活 1 购买系统自动激活
     */
    private Integer cardActivateType;

    /**
     * 卡面值
     */
    private BigDecimal cardFaceAmount;

    /**
     * 激活有效期时间类型：0 无，1 固定时间 2 自发放后多少天有效，默认：0
     */
    private Integer timeType;

    /**
     * 激活有效期开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 激活有效期结束时间
     */
    private LocalDateTime endTime;

    /**
     * 激活有效期自发放后多少天内有效
     */
    private Integer days;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 最近操作人
     */
    private String updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 使用有效期时间类型：0 无，1 固定时间 2 自发放后多少天有效，默认：0
     */
    private Integer useTimeType;

    /**
     * 使用有效期开始时间
     */
    private LocalDateTime useBeginTime;

    /**
     * 使用有效期结束时间
     */
    private LocalDateTime useEndTime;

    /**
     * 使用有效期自发放后多少天内有效
     */
    private Integer useDays;


}
