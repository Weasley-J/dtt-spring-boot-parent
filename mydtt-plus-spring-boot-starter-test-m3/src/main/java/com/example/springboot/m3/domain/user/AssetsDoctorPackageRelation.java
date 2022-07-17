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
import java.time.LocalDateTime;

/**
 * <p>
 * 商品-医生-权益包  关系表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsDoctorPackageRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品skuId
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 医生名称
     */
    private String doctorName;

    /**
     * 是否可见: 0-医生可见、1-医患可见
     */
    private Integer isVisible;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 最近操作人
     */
    private String updater;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
