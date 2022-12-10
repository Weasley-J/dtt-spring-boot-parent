package com.example.domain.javatag;

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
 * 用户信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomJavatagMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     *
     * @primaryKey
     */
    private Long memberId;
    /**
     * 用户openId
     *
     * @length 16
     */
    private String openId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 是否启用, 默认：1
     *
     * @defaultValue true
     */
    private Boolean isEnable;
    /**
     * 用户积分余额, 默认：0.00
     *
     * @precision 10
     * @scale 2
     * @defaultValue 0.00
     */
    private BigDecimal balance;
    /**
     * 出生日期，格式：yyyy-MM-dd HH:mm:ss
     */
    private LocalDateTime birthday;
    /**
     * 会员类型，默认：ORDINARY
     *
     * @defaultValue PLUS
     */
    private MemberType memberType = MemberType.ORDINARY;
    /**
     * 用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常
     *
     * @defaultValue 3
     */
    private Integer status;
    /**
     * 账户注销状态；0 未注销（默认），1 已销户
     *
     * @defaultValue 0
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
