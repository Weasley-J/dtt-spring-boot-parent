package com.example.domain.dtt;

import com.example.enums.MemberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 用户信息-DttMember
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DttMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户openId
     */
    private String openId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 是否启用, 默认：1
     */
    private Boolean isEnable = true;
    /**
     * 用户积分余额, 默认：0.00
     */
    private BigDecimal balance = BigDecimal.valueOf(0L, 2);
    /**
     * 出生日期，格式：yyyy-MM-dd HH:mm:ss
     */
    private LocalDateTime birthday;
    /**
     * 会员类型，默认：ORDINARY
     */
    private MemberType memberType = MemberType.ORDINARY;
    /**
     * 用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常
     */
    private Integer status = 3;
    /**
     * 账户注销状态；0 未注销（默认），1 已销户
     */
    private Integer deleted = 0;
    /**
     * 注册时间，格式: yyyy-MM-dd
     */
    private LocalDate registrarDate;
    /**
     * 会员加速开始时间, 格式：HH:mm:ss
     */
    private LocalTime accelerateBeginTime;
    /**
     * 会员加速结束时间, 格式：HH:mm:ss
     */
    private LocalTime accelerateEndTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
