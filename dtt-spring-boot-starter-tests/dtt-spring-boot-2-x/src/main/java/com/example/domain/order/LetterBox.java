package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消息投递
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@Data
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
     * 消息体
     */
    private String content;

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
