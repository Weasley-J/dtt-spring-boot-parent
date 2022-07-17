package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 三方请求记录表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ThirdRequestRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 本地关联表ID
     */
    private String localId;

    /**
     * 第三方编码
     */
    private String thirdNo;

    /**
     * 类别:1 快钱进件 2 快钱签约 3图片转换
     */
    private Integer type;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 请求header
     */
    private String requestHeader;

    /**
     * 请求体
     */
    private String requestBody;

    /**
     * 返回码
     */
    private String responseCode;

    /**
     * 返回内容
     */
    private String responseBody;

    /**
     * 请求时间
     */
    private LocalDateTime createTime;


}
