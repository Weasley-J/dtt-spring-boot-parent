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
 * 外部请求日志记录
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LogOuterReqst implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 外部渠道code 1：京东
     */
    private Integer outerCode;

    /**
     * 外部渠道名称
     */
    private String outerName;

    /**
     * 请求地址(去掉域名和请求参数)
     */
    private String requestUri;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 返回参数
     */
    private String responseResult;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
