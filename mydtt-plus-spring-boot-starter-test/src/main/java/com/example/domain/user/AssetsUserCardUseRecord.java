package com.example.domain.user;

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
 * 卡消费记录表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsUserCardUseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 卡id
     */
    private Integer assetsCardInstanceId;

    /**
     * 用户卡id
     */
    private Integer assetsUserCardId;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 使用类型 0 下单，1 退款
     */
    private Integer usageType;

    /**
     * 使用状态 0 锁定，1 取消锁定 2 完成
     */
    private Integer usageStatus;

    /**
     * 锁定金额
     */
    private BigDecimal lockAmount;

    /**
     * 当前卡余额
     */
    private BigDecimal surplusAmount;

    /**
     * 操作来源(订单号或者退单号)
     */
    private String sourceNo;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
