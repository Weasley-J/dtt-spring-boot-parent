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
 * 业务操作日志表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BizLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长，步长＝1
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务场景
     */
    private String bizName;

    /**
     * 业务主键
     */
    private String bizPrimaryKey;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 变更前
     */
    private String beforeContext;

    /**
     * 变更后
     */
    private String afterContext;

    /**
     * 业务接口request
     */
    private String submitRequest;

    /**
     * 业务接口response
     */
    private String submitResponse;

    /**
     * 操作人
     */
    private String userId;

    /**
     * 操作人姓名
     */
    private String userName;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * trace_id
     */
    private String traceId;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;


}
