package com.example.domain.dtt;

import cn.alphahub.dtt.plus.annotations.Dtt;
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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Dtt(value = "用户信息")
public class DttPerson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Dtt(value = "主键id")
    private Long id;

    @Dtt(value = "用户openId", length = 32)
    private String openId;

    @Dtt(value = "用户昵称", length = 8)
    private String nickname;

    @Dtt(value = "是否启用, 默认：1")
    private Boolean isEnable = true;

    @Dtt(value = "用户积分余额, 默认：0.00", precision = 10, scale = 2)
    private BigDecimal balance;

    @Dtt(value = "出生日期，格式：yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    @Dtt(value = "会员类型，默认：ORDINARY", defaultValue = "ORDINARY")
    private MemberType memberType = MemberType.ORDINARY;

    @Dtt(value = "用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常")
    private Integer status = 0;

    @Dtt(value = "账户注销状态；0 未注销（默认），1 已销户")
    private Integer deleted = 0;

    @Dtt(value = "注册时间，格式: yyyy-MM-dd")
    private LocalDate registrarDate;

    @Dtt(value = "会员加速开始时间, 格式：HH:mm:ss")
    private LocalTime accelerateBeginTime;

    @Dtt(value = "会员加速结束时间, 格式：HH:mm:ss")
    private LocalTime accelerateEndTime;

    @Dtt(value = "修改时间")
    private LocalDateTime updateTime;
}
