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
import java.time.LocalDateTime;

/**
 * <p>
 * 权益订单历史记录表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsOrderItemUseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权益订单id
     */
    private Integer orderId;

    /**
     * 权益订单项id
     */
    private Integer orderItemId;

    /**
     * 权益包id
     */
    private Integer packageId;

    /**
     * 权益订单状态：1 未核销 2 部分核销 3 已完成 4 已退款
     */
    private Integer orderStatus;

    /**
     * 权益商品项状态：1 未核销 2 部分核销 3 已完成 4 已退款
     */
    private Integer orderItemStatus;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 来源  default- 默认 patients-患者 order-订单 vaccine- 疫苗  detection-基因检测
     */
    private String source;

    /**
     * 核销数量
     */
    private Integer useNumber;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者身份证
     */
    private String patientIdCard;

    /**
     * 患者手机号
     */
    private String patientTel;

    /**
     * 收货人手机号
     */
    private String receiverTel;

    /**
     * 1 核销  2 撤销核销  3 延期 4 作废
     */
    private Integer useType;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 关联id
     */
    private String refId;

    /**
     * 外部系统核销幂等键
     */
    private String outId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 权益项名称
     */
    private String subTitle;

    /**
     * 权益项子类型：0 无 ，1 图文问诊， 2 视频问诊，3 苏可欣（保险），4 优立通（保险）， 5 疫苗服务，6 优惠券，7 实物商品，8 体检，9 检验检测，10 报告解读 ，11 医美服务，12 本地生活，13 宠物服务, 14 优立通（雪特），15 绿通
     */
    private Integer itemSubType;


}
