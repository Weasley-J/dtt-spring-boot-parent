package com.example.domain.order;

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
 * 三方订单导入批次表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderThreeImportBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 批次导入时间
     */
    private LocalDateTime createTime;

    /**
     * 校验成功数
     */
    private Integer successNumber;

    /**
     * 导入总数
     */
    private Integer importTotalNumber;

    /**
     * 校验失败数
     */
    private Integer failNumber;

    /**
     * 订单导入状态0未导入，1导入
     */
    private Integer orderImportStatus;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
