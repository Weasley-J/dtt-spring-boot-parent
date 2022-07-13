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
 * 专场主表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpecialInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专场名称
     */
    private String specialName;

    /**
     * 专场状态：1 未开始 2 进行中 3 已结束
     */
    private Integer specialStatus;

    /**
     * 状态类型 1 活动 2 专场 3 自选商品
     */
    private Integer itemType;

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
     * 跳转url
     */
    private String jumpUrl;

    /**
     * 是否首页轮播显示 1 显示 0 不显示
     */
    private Integer homepageCarouselFlag;

    /**
     * 是否首页专场显示 1 显示 0 不显示
     */
    private Integer homepageSpecialFlag;

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
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
