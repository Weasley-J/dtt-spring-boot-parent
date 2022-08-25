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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 邦指数结算单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IndexStatement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邦指数结算单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 结算单号
     */
    private String statementNo;

    /**
     * 计算医生数
     */
    private Integer settleDoctorCount;

    /**
     * 提交时间 - 对应邦指数后台的结算时间
     */
    private LocalDateTime submitTime;

    /**
     * 提交人
     */
    private String submitter;

    /**
     * 提交结算金额
     */
    private BigDecimal submitAmount;

    /**
     * 结算成功金额
     */
    private BigDecimal successfulAmount;

    /**
     * 结算状态 0：未结算 （默认） 1：已结算
     */
    private Integer status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除(0:未删除,1:已删除)
     */
    private Integer isDel;


}
