package com.example.springboot.m3.domain.order;

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
 * 问诊记录日志表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RxInquiryLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private String orderIds;

    /**
     * 咨询单号
     */
    private String consultOrderId;

    /**
     * 问诊单状态:0,待接诊;4,超时;5,交流中;6,处方已开出且正常结束;100,未开处方且医生主动结束订单 101：用户退款，问诊单关闭
     */
    private Integer consultStatus;

    /**
     * 平台：1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 问诊请求url
     */
    private String url;

    /**
     * 问诊异常备注
     */
    private String remark;


}
