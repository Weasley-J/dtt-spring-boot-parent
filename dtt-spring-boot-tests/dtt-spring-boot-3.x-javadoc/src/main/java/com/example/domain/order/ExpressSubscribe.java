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
 * 快递订阅记录
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-03-31
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpressSubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订阅平台 1:快递网 2快递100
     */
    private Integer subPlatform;

    /**
     * 快递公司code(与平台相关)
     */
    private String comCode;

    /**
     * 快递单号
     */
    private String expNo;

    /**
     * 订阅信息
     */
    private String subInfo;

    /**
     * 订阅返回值
     */
    private String subResult;

    /**
     * 是否订阅成功 1成功 0:失败
     */
    private Integer resultStatus;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
