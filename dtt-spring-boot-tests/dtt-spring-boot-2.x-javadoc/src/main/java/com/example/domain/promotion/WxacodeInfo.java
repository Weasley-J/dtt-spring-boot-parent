package com.example.domain.promotion;

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
 * 带参小程序码列表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WxacodeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 小程序码名称
     */
    private String wxacodeName;

    /**
     * 关联小程序  1-互联网医院 2- 商城 3- 疫苗 4- 药店云
     */
    private Integer relationApp;

    /**
     * 跳转方式 1- 小程序原生页 2-外部h5页
     */
    private Integer jumpType;

    /**
     * 跳转url
     */
    private String jumpUrl;

    /**
     * 小程序码的url
     */
    private String imgUrl;

    /**
     * 删除标志 0- 未删除 1- 已删除
     */
    private Integer deleteFlag;

    /**
     * 创建者id
     */
    private String createBy;

    /**
     * 更新者id
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
