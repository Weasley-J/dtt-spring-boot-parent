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
import java.time.LocalDateTime;

/**
 * <p>
 * 订单权益扩展表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderAssetsExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 权益包id
     */
    private Long assetsPackageId;

    /**
     * 权益卡模板id
     */
    private Integer assetsCardTemplateId;

    /**
     * 权益卡号
     */
    private String assetsCardNo;

    /**
     * 患者id
     */
    private Integer patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者身份证号
     */
    private String patientIdCard;

    /**
     * 患者手机号
     */
    private String patientPhoneNo;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 源服务包实例id
     */
    private String originalPackageInstanceId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志 1 已删除 0 未删除
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 权益包名称
     */
    private String assetsPackageName;

    /**
     * 2 医生端服务包，3 运营创建服务包
     */
    private Integer goodsType;

    /**
     * 组id
     */
    private String groupId;

    /**
     * 权益创建0元包的时候传入的有效期开始时间
     */
    private LocalDateTime activateBeginTime;

    /**
     * 权益创建0元包的时候传入的有效期退款时间
     */
    private LocalDateTime activateEndTime;
    /**
     * skuId
     */
    private String skuId;
    /**
     * 详情订单信息
     */
    private Integer orderItemId;

}
