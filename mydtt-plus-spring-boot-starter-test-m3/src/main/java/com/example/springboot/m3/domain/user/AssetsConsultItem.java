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
 * 权益项
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsConsultItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益项类型：1 问诊 4 保险
     */
    private Integer itemType;

    /**
     * 权益项子类型：1 图文问诊 2 视频问诊 3 苏可欣 4 优立通
     */
    private Integer itemSubType;

    /**
     * 权益项名称
     */
    private String itemName;

    /**
     * 权益项描述
     */
    private String itemDesc;

    /**
     * 适配维度选择: 默认 -1（无业务场景），1 指定医生， 0 不指定医生
     */
    private Integer assignDoctor;

    /**
     * 关联医生id
     */
    private String doctorList;

    /**
     * 帮指数结算方式 0 默认无须结算 1 百分比 2 绝对值
     */
    private Integer bzsSettleType;

    /**
     * 帮指数结算值
     */
    private BigDecimal bzsSettleValue;

    /**
     * 权益项状态 1 启用 0 禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
