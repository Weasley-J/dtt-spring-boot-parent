package com.example.springboot.m3.domain.dtt;

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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * OMS B2B订单主表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsB2bOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 0 草稿 1.待出库 2.出库中 3.已出库 4.已取消 5.已完成 6.部分出库
     */
    private Integer status = 6;

    /**
     * 1、销售出库、2领用出库、3其他出库
     */
    private Integer exwarehouseType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 仓库名称
     */
    private String warehouseName;

//    /**
//     * 物流公司id
//     */
//    private Integer expressCompanyId;

    /**
     * 物流公司编码
     */
    private String expressCode;

    /**
     * 物流公司名称
     */
    private String expressCompany;

    /**
     * 支付方式 1.对现结 2.货到付款
     */
    private Integer payType;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 运费
     */
    private BigDecimal carriageAmount;

    /**
     * 成本部门
     */
    private Integer costDepartment;

    /**
     * 部门名称
     */
    private String costDepartmentName;

    /**
     * 成本单元
     */
    private Integer costUnit;

    /**
     * 单元名称
     */
    private String costUnitName;

    /**
     * 客户名称
     */
    private String buyerName;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverTel;

    /**
     * 订单收货时间
     */
    private LocalDateTime receiverTime;

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
     * 乡镇
     */
    private String town;

    /**
     * 收货人详细地址
     */
    private String address;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 发货标识 1.物流快递 4、自提
     */
    private Integer deliveryFlag;

    /**
     * 发货类型 1.wms 3.供应商线下
     */
    private Integer deliveryType;

    /**
     * 异常标识 1.正常 2.状态异常 3.同步物流异常 4.暂停 5.物料编码缺失 6.发货调用失败 7.出库调用失败
     */
    private Integer exceptionFlag;

    /**
     * 是否删除  1 是  0  否
     */
    private Integer delFlag;

    /**
     * 取消出库原因
     */
    private String cancelReason;

    /**
     * 订单留言
     */
    private String postscript;

    /**
     * 付款时间
     */
    private LocalDate payTime;

    /**
     * 外部订单号
     */
    private String thirdOrderNo;

    /**
     * 代发标志 0-否 1-是
     */
    private Integer issuingFlag;

    /**
     * 物流单号
     */
    private String invoiceNo;

    /**
     * 退货状态:0-无退货 1-部分退货 2-全部退货
     */
    private Integer refundStatus;

    /**
     * 货主id
     */
    private String merchantId;
}
