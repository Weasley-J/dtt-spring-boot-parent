package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 供应商配送配置
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierDeliveryAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 配送服务方：0 商户，1 美团
     */
    private Integer deliveryServiceProvider;

    /**
     * 认证标识
     */
    private String appkey;

    /**
     * 认证密钥
     */
    private String secret;

    /**
     * 服务codes，多个code用,号分割
     */
    private String deliveryServiceCodes;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUsername;

    /**
     * 是否删除，0 否，1 是
     */
    private Integer isDel;


}
