package com.example.domain.order;

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
 * 订单商品表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * goods id
     */
    private Integer goodsId;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品系统item_id
     */
    private Integer goodsItemId;

    /**
     * 外部skuId
     */
    private String outSkuId;

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
     * 商品类型:0 默认，1 全球购，2医生端权益，3消费端权益，4 疫苗
     */
    private Integer goodsType;

    /**
     * 库存
     */
    private Integer stock;

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
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商全称
     */
    private String supplierFullName;

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
     * 佣金点数
     */
    private BigDecimal commission;

    /**
     * 列表的主图
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
     * 商品分摊金额
     */
    private BigDecimal shareAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 支付通道扣减金额（非现金）
     */
    private BigDecimal payDisAmount;

    /**
     * 分摊运费，计最后一个商品
     */
    private BigDecimal carriageAmount;

    /**
     * 一级类目
     */
    private Integer categoryOne;

    /**
     * 一级类目名称
     */
    private String categoryOneName;

    /**
     * 二级类目
     */
    private Integer categoryTwo;

    /**
     * 二级类目名称
     */
    private String categoryTwoName;

    /**
     * 后台一级类目id
     */
    private Integer oneCategoryId;

    /**
     * 后台一级类目名称
     */
    private String oneCategoryName;

    /**
     * 后台二级类目id
     */
    private Integer twoCategoryId;

    /**
     * 后台二级类目名称
     */
    private String twoCategoryName;

    /**
     * 后台三级类目id
     */
    private Integer threeCategoryId;

    /**
     * 后台三级类目名称
     */
    private String threeCategoryName;

    /**
     * 商品上架的id
     */
    private Integer goodsOnshelfId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * item内部项类型：0默认商品，1运费
     */
    private Integer itemInternalType;

    /**
     * 赠品标识 默认0 否，1加购，2赠品
     */
    private Integer giftFlag;

    /**
     * 赠品状态 默认0 满足赠送条件，1 不满足赠送条件
     */
    private Integer giftStatus;

    /**
     * 商详也是否可购买 0 否 1 是
     */
    private Integer buyFlag;

    /**
     * 商家类型 0 其他  1 MP  2 入仓  3 DSV
     */
    private Integer merchantType;

    /**
     * 是否自营供应商 0 非自营 1 自营
     */
    private Integer selfFlag;

    /**
     * 业务标识 1保险 2云DTP 3一体化DTP
     */
    private Integer businessFlag;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 摘要签名
     */
    private String insurePaySign;

    /**
     * 虚拟优惠码分摊金额
     */
    private BigDecimal shareDiscountCodeAmount;

    /**
     * 渠道部门
     */
    private String departmentChannel;

    /**
     * 分销活动编号
     */
    private String distributionActivityId;

    /**
     * 所属分销员编号
     */
    private String distributionOutMemberId;

    /**
     * 是否组合商品 0否 1是
     */
    private Integer assortedFlag;
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


}
