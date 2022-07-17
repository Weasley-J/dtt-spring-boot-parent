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

/**
 * <p>
 * 会员地址表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemberAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员主表id
     */
    private Integer memberId;

    /**
     * 收货人名称
     */
    private String userName;

    /**
     * 收货人手机号
     */
    private String userTel;

    /**
     * 平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云
     */
    private Integer platformId;

    /**
     * 连锁id
     */
    private Integer chainShopId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 收货人详细地址
     */
    private String address;

    /**
     * 门牌号
     */
    private String houseNumber;

    /**
     * 标签：家，公司，学校
     */
    private String label;

    /**
     * 1 默认地址  0 非默认普通地址
     */
    private Integer defaultFlag;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

}
