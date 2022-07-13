package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员类型枚举
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/9
 */
@Getter
@AllArgsConstructor
public enum MemberType {
    ORDINARY("普通会员"),
    STUDENT("学生会员"),
    GUNMETAL("青铜会员"),
    SILVER("白银会员"),
    GOLD("黄金会员"),
    DIAMOND("钻石会员"),
    SPORTS("体育会员"),
    PLUS("plus会员");

    /**
     * 会员描述
     */
    private final String desc;
}
