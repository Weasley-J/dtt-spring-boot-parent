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
import java.time.LocalDateTime;

/**
 * <p>
 * 强合规开关日志表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RxComplianceSwitchLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开关id
     */
    private Integer switchId;

    /**
     * 合规开关类型 1: 终端 2：业务 3:用户灰度  4:sku白名单
     */
    private Integer switchType;

    /**
     * 操作描述
     */
    private String remark;

    /**
     * 操作人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
