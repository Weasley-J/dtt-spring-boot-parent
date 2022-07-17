package com.example.springboot.m3.domain.order;

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
 * 购物车商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 购物车id
     */
    private Integer carId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 门店ID
     */
    private Integer supplierId;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 商品类型 0:普通商品 1：加购商品
     */
    private Integer goodsType;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
