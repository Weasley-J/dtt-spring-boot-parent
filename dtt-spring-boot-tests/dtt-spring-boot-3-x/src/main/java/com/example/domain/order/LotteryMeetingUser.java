package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 年会抽奖用户表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LotteryMeetingUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * OAID,如018513
     */
    private String oaId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 抽奖资格
     */
    private Integer qualificationFlag;

    /**
     * 删除标志
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;


}
