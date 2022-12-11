package com.example.domain.shop;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品主表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 商品用途编号
     */
    private String usageCode;

    /**
     * 原产国编码
     */
    private String originalCountry;

    /**
     * HS编码
     */
    private String hsCode;

    /**
     * 品牌
     */
    private String brandName;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 包装规格
     */
    private String packingSpec;

    /**
     * 商品单位：盒、袋
     */
    private String goodsUnit;

    /**
     * 商品状态：1 启用 2 禁用
     */
    private Integer goodsStatus;

    /**
     * OTC类别 1 甲类OTC 2 乙类OTC
     */
    private Integer otcType;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 锁定库存
     */
    private Integer lockedStock;

    /**
     * 国药准字
     */
    private String medicineStandard;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 医生开处方 1 可以开处方 0 不可以开处方
     */
    private Integer enableRx;

    /**
     * 处方药类型
     */
    private Integer rxType;

    /**
     * 显示方式 0 不显示 1 线上
     */
    private Integer showType;

    /**
     * 药品名
     */
    private String drugName;

    /**
     * 是否万邦药 0 不是， 1 是
     */
    private Integer wbDrug;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读
     */
    private Integer goodsKind;

    /**
     * 原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读
     */
    private Integer orgGoodsKind;

    /**
     * 商品类型:1 实物 2 虚拟 3 服务
     */
    private Integer goodsMold;

    /**
     * 商品类型:0 默认，1 全球购
     */
    private Integer goodsType;

    /**
     * 医疗批注号
     */
    private String medicalNo;

    /**
     * 佣金点数
     */
    private BigDecimal commission;

    /**
     * 列表的主图
     */
    private String mainPic;

    /**
     * 外部部门
     */
    private String outDept;

    /**
     * 外部sku id
     */
    private String outSkuId;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 一级类目
     */
    private String outCategoryOne;

    /**
     * 二级类目
     */
    private String outCategoryTwo;

    /**
     * 三级类目
     */
    private String outCategoryThree;

    /**
     * 邦指数
     */
    private BigDecimal bangPrice;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 1 显示 0 不显示  -1 线下（DTP） -2 线上线下 -3 售药机药品
     */
    private Integer ifShow;

    /**
     * item_id
     */
    private Integer itemId;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 权益包id
     */
    private String assetPackageId;

    /**
     * 权益卡ID
     */
    private String assetCardId;

    /**
     * item跳转链接
     */
    private String itemUrl;

    /**
     * sku跳转链接
     */
    private String skuUrl;

    /**
     * 运费模板id
     */
    private Integer carriageTemplateId;

    /**
     * 留存比例 X%
     */
    private BigDecimal retainPercent;

    /**
     * 关系比例 X%
     */
    private BigDecimal relatePercent;

    /**
     * 收益类型 1-收益值 2-收益比列
     */
    private Integer earningsType;

    /**
     * 收益
     */
    private BigDecimal earnings;

    /**
     * 是否需要收货地址 0-不需要 1-需要
     */
    private Integer deliveryAddressRequired;

    /**
     * 税收分类编码
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String taxCode;

    /**
     * 税率
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private BigDecimal taxRate;

    /**
     * 零税率标识 1:免税 2:不征税 3:普通零税率
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer zeroTaxMark;

    /**
     * 优惠政策标识 1:使用 0:不使用
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer policyTaxMark;

    /**
     * 政策标识名称
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String policyName;


    private Integer relateId;

    /**
     * 拼音简码
     */
    private String itemNamePy;

    /**
     * 业务范围
     * 0-商城通用(默认选项)、1-疫苗专用
     */
    private Integer sphereBusiness;

    /**
     * 支付方式
     * 0-预留类型（暂不使用） 、1-线上支付、2-线下支付
     */
    private Integer payType;

    /**
     * 部门编号
     */
    private String departmentNo;
}
