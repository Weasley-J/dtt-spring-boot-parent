package com.example.springboot.m3.domain.oms;

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
 * oms订单附加信息表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * oms订单id
     */
    private Integer orderId;

    /**
     * 三方商户编码
     */
    private String thirdCode;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 店铺每日订单序号
     */
    private Integer daySerialNumber;

    /**
     * 推送订单至三方状态 0.无需推送 1.待推送 2.推送成功 3.推送失败
     */
    private Integer pushOrderToThirdStatus;


}
