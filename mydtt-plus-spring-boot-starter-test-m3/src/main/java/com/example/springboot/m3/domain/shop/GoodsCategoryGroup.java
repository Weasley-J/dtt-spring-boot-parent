package com.example.springboot.m3.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 展示一级分类分组表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class GoodsCategoryGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 展示分类一级ID
     */
    private Integer categoryOneId;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云 5 星苗鲸选
     */
    private Integer platformId;

    /**
     * 排序
     */
    private Integer seqNum;

    /**
     * 删除状态 0未删除 1删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;


}
