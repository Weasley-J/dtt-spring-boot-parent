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
 * 消息投递
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LetterBox implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长，步长＝1
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型 0 普通信件
     */
    private Integer letterType;

    /**
     * 0 未处理（默认）；1 处理失败；2 处理成功
     */
    private Integer letterStatus;

    /**
     * 回调服务名称
     */
    private String serviceName;

    /**
     * app_id
     */
    private String appId;

    /**
     * 消息体
     */
    private String content;

    /**
     * 请求上下文
     */
    private String requestContext;

    /**
     * 响应上下文
     */
    private String responseContext;

    /**
     * 失败次数
     */
    private Integer failureCount;

    /**
     * 执行间隔
     */
    private Integer execIntervalMinutes;

    /**
     * 错误消息或者执行消息
     */
    private String message;

    /**
     * 执行时间
     */
    private LocalDateTime nextExecTime;

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;


}
