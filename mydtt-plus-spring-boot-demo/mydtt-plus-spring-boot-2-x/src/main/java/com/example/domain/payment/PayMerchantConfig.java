package com.example.domain.payment;

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
 * 商户支付账号配置
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayMerchantConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态 0:未启用 1:已启用
     */
    private Integer configStatus;

    /**
     * 订单来源(平台)：0 无 1 商城系统
     */
    private Integer orderSource;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 支付环境
     */
    private String payenv;

    /**
     * appid
     */
    private String appid;

    /**
     * schema_key
     */
    private String schemaKey;

    /**
     * 支付配置ids
     */
    private String configIds;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
