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
 *
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HaowanGamePrize implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 奖品类型
     */
    private Integer prizeType;

    /**
     * 关联Id  (优惠券id或者权益id)
     */
    private Integer relationId;

    /**
     * 关联名称 (优惠券名称或者权益名称)
     */
    private String relationName;

    /**
     * 关联类型 (优惠券类型或者权益类型)
     */
    private Integer relationType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 状态( 0 启用 ，1 禁用)
     */
    private Integer status;


}
