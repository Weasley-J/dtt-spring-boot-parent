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
 * oms线下导入订单取消批次表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsCancelOrderImportBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 三方平台编号 同订单主表
     */
    private Integer thirdPlatformId;

    /**
     * 处理状态 0.未处理 1.处理中 2.处理完成
     */
    private Integer status;

    /**
     * 总数
     */
    private Integer totalCnt;

    /**
     * 成功数
     */
    private Integer successCnt;

    /**
     * 部分失败数
     */
    private Integer partFailureCnt;

    /**
     * 失败数
     */
    private Integer failureCnt;

    /**
     * 执行人
     */
    private String executeName;

    /**
     * 执行时间
     */
    private LocalDateTime executeTime;

    /**
     * 创建人
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 0.未删除 1.已删除
     */
    private Integer delFlag;


}
