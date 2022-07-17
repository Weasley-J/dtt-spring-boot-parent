package com.example.springboot.m3.domain.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名
     */
    private String realName;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 注册时间
     */
    private LocalDateTime regTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 最后登录ip
     */
    private String lastIp;

    /**
     * 登录次数
     */
    private Integer logins;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 小程序openid
     */
    private String openid;

    /**
     * 健康商城openid
     */
    private String healthMallOpenid;

    /**
     * 公众号openid
     */
    private String mpOpenid;

    /**
     * 总积分总余额
     */
    private Integer totalIntegral;

    /**
     * wx unionid
     */
    private String unionid;

    /**
     * 会员类型,1:普通会员;2:内部会员
     */
    private Integer memberType;

    /**
     * 用户手机号码
     */
    private String userTel;

    /**
     * 性别 1男 2女
     */
    private Integer userSex;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 背景头像
     */
    private String backgroudImage;

    /**
     * 0 无法登录  1可以登录
     */
    private Integer locking;

    /**
     * 最近登录时间
     */
    private Integer appLastLoginTime;

    /**
     * app下载渠道
     */
    private String downloadChannel;

    /**
     * 注册渠道
     */
    private String regChannel;

    /**
     * app系统版本
     */
    private String systemVersion;

    /**
     * app version
     */
    private String appVersion;

    /**
     * 目标尿酸
     */
    private Integer targetUric;

    /**
     * 会员  0 不是会员  1 是会员
     */
    private Integer memberStatus;

    /**
     * 会员开始时间
     */
    private LocalDateTime memberStarttime;

    /**
     * 会员结束时间
     */
    private LocalDateTime memberEndtime;

    /**
     * 未读的信息数量
     */
    private Integer unreadMsgCount;

    /**
     * 设备标识
     */
    private String deviceFlag;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 修改用户信息时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新档案店员ID
     */
    private Integer updateBdyUserId;

    /**
     * 1 关注  0 取关
     */
    private Integer subscribeFlag;

    /**
     * 2019-09-10 跨境电商 订购人真实姓名
     */
    private String truename;

    /**
     * 手机号重复用户，归属到最小ID
     */
    private Integer parentUserId;

    /**
     * 风友币状态  1 可以使用 0不可以使用
     */
    private Integer lockIntegral;

    /**
     * 大会员系统的会议id
     */
    private String outMemberId;

    /**
     * 苹果登录id
     */
    private String appleId;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）
     */
    private Integer platformId;

    /**
     * 渠道来源
     */
    private String channelSource;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 全局活动id
     */
    private String globalActivityId;

    /**
     * 全局渠道id
     */
    private String globalChannelId;

    /**
     * 是否是药店云用户
     */
    private Integer ydyUser;

    /**
     * 是否是健康云商城用户
     */
    private Integer mallUser;

    /**
     * 药店云小程序openid
     */
    private String ydyMaOpenid;

    /**
     * 好玩openId
     */
    private String thirdUserKey;
}
