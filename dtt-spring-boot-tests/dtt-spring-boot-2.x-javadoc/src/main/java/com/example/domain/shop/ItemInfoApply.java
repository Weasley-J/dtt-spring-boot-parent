package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 预商品库表
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemInfoApply implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 正式表ID
     */
    private Integer itemId;

    /**
     * 商品类型:0 默认，1 实物 2 虚拟 3 服务
     */
    private Integer itemMold;

    /**
     * 商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务 20:绿通 21:疫苗（新）22:核酸检测
     */
    private Integer itemKind;

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
     * 库存单位：盒、瓶、套、件、个、只
     */
    private String stockUnit;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 重量单位：盒、瓶、套、件、个、只
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
     * 跳转链接
     */
    private String itemUrl;

    /**
     * 运费模板id
     */
    private Integer carriageTemplateId;

    /**
     * 1 新增 2 编辑
     */
    private Integer applyType;

    /**
     * 审核状态:1 待审核 2 审核通过 3 驳回 4 取消审核
     */
    private Integer auditStatus;

    /**
     * 审核人
     */
    private String auditUser;

    /**
     * 审核原因
     */
    private String auditReason;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
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
     * 商品名称首字母
     */
    private String itemNamePy;

    /**
     * 业务范围:0-商城通用(默认选项)、1-疫苗专用
     */
    private Integer sphereBusiness;

    /**
     * 支付方式：0-预留类型（暂不使用） 、1-线上支付、2-线下支付
     */
    private Integer payType;

    /**
     * 发货仓库编码
     */
    private String warehouseCode;

    /**
     * 发货仓库名称
     */
    private String warehouseName;

    /**
     * 代发供应商编码
     */
    private String sendSupplierCode;


    /**
     * 商品标签IDs 多个;隔开
     */
    private String tagIds;


}
