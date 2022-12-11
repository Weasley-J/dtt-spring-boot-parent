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
 * 权益二级分类菜单
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsItemCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类目编码
     */
    private Integer code;

    /**
     * 类目名称
     */
    private String itemName;

    /**
     * 类型: 1 一级分类，2 二级分类
     */
    private Integer itemType;

    /**
     * 排序值，数值越小越靠前; 插入值为100000的倍数，调整顺序上下移动，只需要改变当前步长和基础数值
     */
    private Integer sortValue;

    /**
     * 父级类目id
     */
    private Integer parentId;

    /**
     * 类型状态：0未启用，1已启用
     */
    private Integer itemStatus;

    /**
     * 权益跳转url
     */
    private String jumpUrl;

    /**
     * 权益跳转其他业务链接的JSON字符串，如:h5,微信小程序等，json字符规范:{"key1":"url1","key2":"url2"}；例如：{"h5":"https://www.abc.com","weChatMiniProgram":"https://www.def.com"}
     */
    private String businessUrl;

    /**
     * app使用链接环境：1.不显示，2.h5页面，3.原生页
     */
    private Integer appUrlType;

    /**
     * app使用url
     */
    private String appUrl;

    /**
     * 小程序使用链接环境：1.不显示，2.h5页面，3.原生页
     */
    private Integer smallProgramUrlType;

    /**
     * 小程序使用url
     */
    private String smallProgramUrl;

    /**
     * 其他使用链接环境：1.不显示，2.h5页面，3.原生页
     */
    private Integer clientUrlType;

    /**
     * 小程序使用url
     */
    private String clientUrl;

    /**
     * 商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通 21:疫苗（新）
     */
    private Integer goodsKind;

    /**
     * 是否前端展示 0不展示 ，1展示
     */
    private Integer isShow;

    /**
     * 适配维度选择 0 不勾选， 1勾选
     */
    private Integer isAssign;

    /**
     * 医生适配维度选择: -1 无业务场景，1 指定医生， 0 不指定医生，默认: -1
     */
    private Integer assignDoctor;

    /**
     * 帮指数结算方式 0 勾选 1 不勾选
     */
    private Integer isBzsShow;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
