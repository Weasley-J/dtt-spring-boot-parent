package com.example.springboot.m3.domain.user;

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
 * 权益包
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权益包id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益包类型：默认0，0 基础权益包，1 续费权益包；
     */
    private Integer packageType;

    /**
     * 权益包名称
     */
    private String packageName;

    /**
     * 权益包描述
     */
    private String packageDesc;

    /**
     * 权益包所属BU（非必填）: HH、HO、OBM，默认：null
     */
    private String packageBu;

    /**
     * 权益包图片URL
     */
    private String packageImage;

    /**
     * 权益包总价值，默认：￥0.00
     */
    private BigDecimal totalValue;

    /**
     * 权益包售价
     */
    private BigDecimal sellPrice;

    /**
     * 时间类型：0 无，1 固定时间 2 自发放后多少天有效，默认：0
     */
    private Integer timeType;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 自发放后多少天内有效
     */
    private Integer days;

    /**
     * 权益包状态：1 启用（上架），0 禁用（下架），默认：1
     */
    private Integer status;

    /**
     * 权益包税率配置状态 0 默认值（未处理） 1:待配置 2:待更新 3:已配置
     */
    private Integer taxStatus;

    /**
     * 配置税率时间
     */
    private LocalDateTime configTaxTime;

    /**
     * 可共享次数
     */
    private Integer shareCount;

    /**
     * 是否能升级：0 不能，1 可以，默认: 0
     */
    private Integer canUpgrade;

    /**
     * 激活方式 0 手动激活 1 购买系统自动激活
     */
    private Integer packageActivateType;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建者类型：1 医生，2 运营，0 未知，默认：0
     */
    private Integer creatorType;

    /**
     * 最近操作人
     */
    private String updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
