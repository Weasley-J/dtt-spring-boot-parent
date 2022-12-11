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
public class OmsDeliveryRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规则id
     */
    private Integer ruleId;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 发货快递    shengsheng   生生物流   debangkuaidi   德邦快递  shunfengbiaokuai顺丰电商标快   shunfengtekuai  顺丰特快   shunfengbiaokuai2 顺丰标快   shunfengsuyunbzd顺丰快运标准达  zhongtong 中通快递  jd 京东快递
     */
    private String express;

    /**
     * 发货快递  生生物流、德邦大件快递360、顺丰电商标快、顺丰特快，顺丰标快、顺丰快运标准达、中通快递、京东快递、德邦精准卡航、专车直送、自提、顺医标快、顺医特快
     */
    private String expressCompany;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
