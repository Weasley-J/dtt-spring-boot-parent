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

/**
 * <p>
 * 地区表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MallDistrict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 上级id
     */
    private Integer parentId;

    /**
     * 级别
     */
    private Integer levelType;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 地区简称
     */
    private String shortName;

    /**
     * 编码路径
     */
    private String parentPath;

    /**
     * 省名称
     */
    private String province;

    /**
     * 市名称
     */
    private String city;

    /**
     * 行政区
     */
    private String district;

    /**
     * 省简称
     */
    private String provinceShortName;

    /**
     * 市简称
     */
    private String cityShortName;

    /**
     * 行政区简称
     */
    private String districtShortName;

    /**
     * 省拼音
     */
    private String provincePinyin;

    /**
     * 市拼音
     */
    private String cityPinyin;

    /**
     * 行政区拼音
     */
    private String districtPinyin;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 简拼
     */
    private String jianpin;

    /**
     * 首字母
     */
    private String firstChar;

    /**
     * 区号
     */
    private String cityCode;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 备注
     */
    private String remark1;

    /**
     * 备注
     */
    private String remark2;


}
