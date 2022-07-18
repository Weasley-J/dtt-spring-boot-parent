package com.example.domain.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * OMS订单商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 第三方平台子订单编号,若没有拆单为第三方平台订单编号
     */
    private String thirdOrderItemNo;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 外部skuId
     */
    private String outSkuId;

    /**
     * 条形码
     */
    private String outBarCode;

    /**
     * 货号
     */
    private String outProductCode;

    /**
     * 第三方平台skuId
     */
    private String thirdSkuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品单位：盒、袋
     */
    private String goodsUnit;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 药品名
     */
    private String drugName;

    /**
     * OTC类别 1 甲类OTC 2 乙类OTC
     */
    private Integer otcType;

    /**
     * 商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品
     */
    private Integer goodsKind;

    /**
     * 原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通 21:疫苗（新）22:核酸检测
     */
    private Integer orgGoodsKind;

    /**
     * 处方药类型
     */
    private Integer rxType;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 三方平台商品销售单价
     */
    private BigDecimal thirdRetailPrice;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商全称
     */
    private String supplierFullName;

    /**
     * 主图
     */
    private String mainPic;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 商品金额
     */
    private BigDecimal totalAmount;

    /**
     * 实付总金额
     */
    private BigDecimal shareAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 实付单价
     */
    private BigDecimal singleShareAmount;

    /**
     * 商品货款总金额
     */
    private BigDecimal goodsSellerAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 支付通道扣减金额（非现金）
     */
    private BigDecimal payDisAmount;

    /**
     * 虚拟优惠码分摊金额
     */
    private BigDecimal shareDiscountCodeAmount;

    /**
     * 渠道部门
     */
    private String departmentChannel;

    /**
     * 仓库id
     */
    private String warehouseCode;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 代发供应商
     */
    private String sendSupplierCode;
}
