package com.example.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 三方商家回调地址配置表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsThirdMerchantUrlManager implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 回调业务类型:1:订单创建 2：新增退单 3:退款单状态变更
     */
    private Integer type;

    /**
     * 回调第三方地址
     */
    private String merchantUrl;

    /**
     * 请求方式：GET,POST
     */
    private String requestType;


}
