package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 优惠券用户表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CouponUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠券号
     */
    private String couponNo;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 全局会员id
     */
    private String outMemberId;

    /**
     * 会员手机号码
     */
    private String memberTel;

    /**
     * 优惠券状态：1 待使用 2 已锁定 3 已使用 4 已作废
     */
    private Integer couponStatus;

    /**
     * 健康档案ID
     */
    private Integer pomrId;

    /**
     * 权益id
     */
    private Integer assetsId;

    /**
     * 修改时间：核销时间或者作废时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
