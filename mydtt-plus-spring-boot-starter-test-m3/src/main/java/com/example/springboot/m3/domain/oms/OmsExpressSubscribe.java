package com.example.springboot.m3.domain.oms;

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
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsExpressSubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订阅平台 1.快递网 2.快递100 3.复星商城
     */
    private Integer subPlatform;

    /**
     * 快递公司code(不同平台可能code不同)
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
     * 订阅返回码
     */
    private Integer subResultCode;

    /**
     * 订阅返回值
     */
    private String subResult;

    /**
     * 订阅方式 1.等待推送(仅支持快递100) 2.主动拉取(仅支持复星商城)
     */
    private Integer subscribeType;

    /**
     * 拉取状态(当订阅方式为 2 时) 0.无需拉取 1.正常拉取 2.结束拉取
     */
    private Integer pollStatus;

    /**
     * 是否订阅成功 0.失败 1.成功
     */
    private Integer resultStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
