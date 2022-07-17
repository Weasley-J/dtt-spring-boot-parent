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
 * 终端强合规开关控制表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RxComplianceSwitchEndpoint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 终端类型 小程序-h5InWx，h5，app-wxMiniApp
     */
    private String endpoint;

    /**
     * 终端名称 小程序-h5InWx，h5，app-wxMiniApp
     */
    private String endpointName;

    /**
     * 强合规开关：0 关闭，1 开启
     */
    private Integer switchStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 操作人
     */
    private String updateUser;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;


}
