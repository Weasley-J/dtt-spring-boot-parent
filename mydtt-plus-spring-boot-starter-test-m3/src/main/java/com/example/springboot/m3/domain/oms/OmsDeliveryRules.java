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
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsDeliveryRules implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规则编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 所属机构   fxjk 云药房  , fxyjk 云健康
     */
    private String organ;

    /**
     * 规则层级  0 平台  1 店铺   2 商品
     */
    private Integer ruleLevel;

    /**
     * 平台  0 全部平台  1 复星商城  2 天猫   3 京东  4 宝宝树   5 快手    6 抖音    7 星选
     */
    private Integer platform;

    /**
     * 店铺
     */
    private Integer supplierId;

    /**
     * 商品集合
     */
    private String skuIds;

    /**
     * 发货快递    shengsheng   生生物流   debangkuaidi   德邦快递  shunfengbiaokuai顺丰电商标快   shunfengtekuai  顺丰特快   shunfengbiaokuai2 顺丰标快   shunfengsuyunbzd顺丰快运标准达  zhongtong 中通快递  jd 京东快递
     */
    private String express;

    /**
     * 订单类型  0 普通订单  1 B2B订单 2领用订单
     */
    private Integer orderType;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 启用状态  0 禁用  1 启用
     */
    private Integer status;


}
