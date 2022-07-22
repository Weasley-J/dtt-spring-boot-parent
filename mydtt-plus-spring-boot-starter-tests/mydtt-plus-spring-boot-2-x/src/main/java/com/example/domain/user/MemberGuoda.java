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
 * 国大会员表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemberGuoda implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 大会员id
     */
    private String outMemberId;

    /**
     * 国大会员id
     */
    private String guodaMemberId;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 门店编码
     */
    private String chainCode;

    /**
     * pos编码
     */
    private String posCode;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 绑卡状态 0否1是
     */
    private Integer bindType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
