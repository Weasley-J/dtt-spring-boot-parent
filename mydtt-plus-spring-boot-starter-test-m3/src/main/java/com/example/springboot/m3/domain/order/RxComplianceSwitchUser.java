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
 * 用户强合规开关控制表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RxComplianceSwitchUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 强合规开关：0 关闭，1 开启
     */
    private Integer switchStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

    /**
     * 手机号
     */
    private String telPhone;

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
