package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 供应商配送服务扩展表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierDeliveryServiceExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 供应商配送服务id
     */
    private Integer deliveryServiceId;

    /**
     * 配送服务code
     */
    private String deliveryServiceCode;

    /**
     * 配送范围，格式[{"x":31.305655,"y":96.954307},{"x":31.237576,"y":97.025718}]
     */
    private String deliveryScope;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除，0 否，1 是
     */
    private Integer isDel;


}
