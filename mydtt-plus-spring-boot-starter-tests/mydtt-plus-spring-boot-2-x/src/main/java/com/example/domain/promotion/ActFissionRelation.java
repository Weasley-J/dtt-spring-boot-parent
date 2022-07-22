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
 * 裂变活动关系表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActFissionRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 子级会员id
     */
    private Integer memberId;

    /**
     * 子级会员手机号
     */
    private String memberTel;

    /**
     * 父级会员id
     */
    private Integer parentMemberId;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 子级优惠券号
     */
    private String couponNo;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 父级优惠券号
     */
    private String parentCouponNo;

    /**
     * 父级优惠券发放时间
     */
    private LocalDateTime parentCouponGiveTime;

    /**
     * 来源
     */
    private String resource;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
