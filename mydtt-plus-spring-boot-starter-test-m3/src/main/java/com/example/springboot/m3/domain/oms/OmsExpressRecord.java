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
 * 快递记录信息
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsExpressRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 快递公司code
     */
    private String comCode;

    /**
     * 快递公司名称
     */
    private String comName;

    /**
     * 快递单号
     */
    private String expNo;

    /**
     * 快递单当前签收状态，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转单，10待清关，11清关中，12已清关，13清关异常，14收件人拒签
     */
    private Integer state;

    /**
     * 返回快递单监控状态 polling:监控，shutdown:结束（已签收），abort:中止，updateall:重新推送
     */
    private String returnStatus;

    /**
     * 返回msg
     */
    private String returnMsg;

    /**
     * 返回的结果
     */
    private String returnResult;

    /**
     * 物流轨迹信息
     */
    private String record;

    /**
     * 签收时间
     */
    private LocalDateTime signTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
