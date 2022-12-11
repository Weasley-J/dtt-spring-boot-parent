package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品库表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * 商品类型:0 默认，1 实物 2 虚拟 3 服务
     */
    private Integer itemMold;

    /**
     * 商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务 20:绿通 21:疫苗（新） 22:核酸检测
     */
    private Integer itemKind;

    /**
     * 原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读
     */
    private Integer orgItemKind;

    /**
     * 后台类目ID（三级）
     */
    private Integer categoryId;

    /**
     * 品牌
     */
    private String brandName;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品副标题
     */
    private String itemTitle;

    /**
     * 库存单位：盒,瓶,套,件,个,只,袋,包,台,片,组,箱,粒,枚
     */
    private String stockUnit;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 重量单位：微克(ug),毫克(mg),克(g),千克(kg),升,毫升,两,斤
     */
    private String weightUnit;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 佣金点数
     */
    private BigDecimal commission;

    /**
     * 商品类型:0 默认，1 全球购
     */
    private Integer itemType;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 商品状态：1 启用 2 禁用 3 待完善
     */
    private Integer itemStatus;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 批准文号
     */
    private String medicineNo;

    /**
     * 列表的主图
     */
    private String mainPic;

    /**
     * 售后 0 无 1 可退款 2 不支持退款
     */
    private Integer afterSale;

    /**
     * 1 显示 0 不显示  -1 线下（DTP） -2 线上线下 -3 售药机药品
     */
    private Integer ifShow;

    /**
     * 申请状态:1 无 2 更新审核中
     */
    private Integer applyStatus;

    /**
     * 跳转链接
     */
    private String itemUrl;

    /**
     * 运费模板id(作废。使用goods_carriage_template。只用于b2c方式)
     */
    private Integer carriageTemplateId;

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
     * 操作人
     */
    private String updateUser;

    /**
     * 关联的spuId
     */
    private Integer relateId;

    /**
     * 商品名称首字母
     */
    private String itemNamePy;

    /**
     * 是否符合上架条件 0 否 1是
     */
    private Integer onshlfFlag;

    /**
     * 商品供应商-简称
     */
    private String abbrName;

    /**
     * 商品供应商-全称
     */
    private String fullName;

    /**
     * 商品供应商-来源 1商 城 2疫苗 3药店云
     */
    private Integer source;

    /**
     * 电商 1 上架 0 下架
     */
    private Integer mallOnshelf;

    /**
     * 药店云 1 上架 0 下架
     */
    private Integer ydyOnshelf;

    /**
     * 邦甸园 1 上架 0 下架
     */
    private Integer bdyOnshelf;

    /**
     * 上架是否显示
     */
    private Integer mallShowFlag;

    /**
     * 商城上架 一级类目
     */
    private Integer mallCatgOne;

    /**
     * 商城上架 一级类目名称
     */
    private String mallCatgOneName;

    /**
     * 商城上架 二级类目
     */
    private Integer mallCatgTwo;

    /**
     * 商城上架 二级类目名称
     */
    private String mallCatgTwoName;

    /**
     * 店铺-是否自营 0 非自营 1 自营(冗余)
     */
    private Integer shopSelfFlag;

    /**
     * 商城-商详页是否可购买 0 否 1 是(与goods_onshelf表同步)
     */
    private Integer mallBuyFlag;

    /**
     * 业务标识 1保险 2云DTP 3一体化DTP 4国大保险(冗余supplier表)
     */
    private Integer shopBusinessFlag;


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
     * 发货仓编码
     */
    private String warehouseCode;

    /**
     * 发货仓名称
     */
    private String warehouseName;

    /**
     * 代发供应商编码
     */
    private String sendSupplierCode;
    /**
     * 标签ID,多个使用;号分割
     */
    private String tagIds;

}
