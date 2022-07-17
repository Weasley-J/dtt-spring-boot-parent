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
 * 优惠券品类表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CouponKind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券ID
     */
    private Integer couponId;

    /**
     * 优惠券类型：1 实物 2 虚拟 3 服务
     */
    private Integer couponMold;

    /**
     * 优惠券分类：2.OTC 3.械字号 4.RX 5：健字号 6：消字号 7：妆字号 8：食字号 9：其它
     * 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务
     */
    private Integer couponKind;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
