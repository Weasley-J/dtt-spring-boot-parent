package com.example.springboot.m3.domain.promotion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 外部调用接口记录表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExternalCallLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型 1发券
     */
    private Integer externalType;

    /**
     * 调用接口地址
     */
    private String url;

    /**
     * 入参
     */
    private String param;

    /**
     * 业务编码
     */
    private String externalCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
