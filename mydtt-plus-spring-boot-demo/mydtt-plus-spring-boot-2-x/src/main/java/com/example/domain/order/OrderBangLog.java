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
 * 邦指数日志表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderBangLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 医生ID
     */
    private String doctorId;

    /**
     * 买家用户ID
     */
    private Integer buyerId;

    /**
     * 1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功
     */
    private Integer status;

    /**
     * 处方商品明细
     */
    private String goodsInfo;

    /**
     * 消息topic
     */
    private String mq;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
