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
 * oms线下导入订单批次表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderImportBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 三方平台编号 0.无 1.复星商城 2.京东 3.宝宝树
     */
    private Integer thirdPlatformId;

    /**
     * 导入状态: 0 未导入,1 导入中,2 已导入
     */
    private Integer status;

    /**
     * 失败标识: 0 无,1 有失败订单,2 正常
     */
    private Integer failureFlag;

    /**
     * 总数
     */
    private Integer totalCnt;

    /**
     * 成功数
     */
    private Integer successCnt;

    /**
     * 失败数
     */
    private Integer failureCnt;

    /**
     * 导入OMS人
     */
    private String importOmsUserName;

    /**
     * 导入OMS时间
     */
    private LocalDateTime importOmsCreateTime;

    /**
     * 创建人
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 逻辑删除标志 0 未删除,1已删除
     */
    private Integer delFlag;


}
