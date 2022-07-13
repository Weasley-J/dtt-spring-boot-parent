package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单疫苗扩展表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderVaccinesExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 取消时长
     */
    private Integer cancelDuration;

    /**
     * 外部订单号
     */
    private String outOrderNo;

    /**
     * 外部商品名称
     */
    private String outGoodsName;

    /**
     * 外部商品id
     */
    private String outSkuId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
