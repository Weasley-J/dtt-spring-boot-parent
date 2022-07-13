package com.example.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专场活动主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActivitySpecial implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动表id
     */
    private Integer activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动状态：1 未开始 2 进行中 3 已结束
     */
    private Integer activityStatus;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 首页展示图片banner
     */
    private String bannerUrl;

    /**
     * 专场图片
     */
    private String picUrl;

    /**
     * 是否首页轮播：0 不是 1 是
     */
    private Integer homepageCarousel;

    /**
     * 是否首页下方展示：0 不展示 1 展示
     */
    private Integer homepageDownShow;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
