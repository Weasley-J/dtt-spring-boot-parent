package com.example.domain.payment;

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
 * 支付配置表
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayChannelConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态 0:未启用 1:已启用
     */
    private Integer configStatus;

    /**
     * 渠道名称
     */
    private String payChannel;

    /**
     * 聚合支付内部渠道
     */
    private String innerPayChannel;

    /**
     * 父商户id
     */
    private String superMerchantId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * appid
     */
    private String appId;

    /**
     * 支撑PayTradeType
     */
    private String supportPayTradeTypes;

    /**
     * 支撑appid列表
     */
    private String supportAppids;

    /**
     * 支撑业务方appid列表
     */
//    @Deprecated
//    private String supportAppBizids;
    /**
     * 支撑订单类型
     */
    private String supportOrderTypes;
    private String configVersion;
    private String payCategoryName;
    private String payName;

    /**
     * 服务器地址
     */
    private String serverUrl;

    /**
     * 私钥path
     */
    private String privateKeyPath;

    /**
     * 公钥path
     */
    private String publicKeyPath;

    /**
     * 接口密钥
     */
    private String apiKey;

    /**
     * 接口密钥
     */
    private String apiKeyPath;

    /**
     * 证书path
     */
    private String privateCertPath;

    /**
     * public证书path
     */
    private String publicCertPath;

    /**
     * 根证书path
     */
    private String rootCertPath;

    /**
     * 终端ID
     */
    private String terminalId;

    /**
     * 私钥alias
     */
    private String privateKeyAlias;

    /**
     * 存储keyValue对象
     */
    private String keyValueObj;

    /**
     * 私钥password
     */
    private String privateKeyPassword;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 开发备注
     */
    private String developRemark;

    /**
     * 是否需要分账 0:否  1:是
     */
    private Integer needSharding;

    /**
     * 平台userId
     */
    private String superMerchangeUid;


}
