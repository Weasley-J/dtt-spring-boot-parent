package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author max
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CouponRestrict implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券Id
     */
    private Integer couponId;

    /**
     * 优惠券限制类型 2科室 3医生
     */
    private Integer restrictType;

    /**
     * 科室或者医生id
     */
    private Integer restrictId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
