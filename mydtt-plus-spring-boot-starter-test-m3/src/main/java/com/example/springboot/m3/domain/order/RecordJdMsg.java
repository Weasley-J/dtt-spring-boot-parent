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
 * 京东消息信息
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-07
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordJdMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 京东消息id
     */
    private String jdMsgId;

    /**
     * 京东消息
     */
    private String jdMsg;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
