package com.example.domain.user;

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
 * 登录日志表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MallLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * member_id
     */
    private Integer memberId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 登录短信验证码
     */
    private String smsCode;

    /**
     * 登录短信验证码UUID或者三方token
     */
    private String smsCodeUuid;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * sessionKey
     */
    private String sessionKey;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
