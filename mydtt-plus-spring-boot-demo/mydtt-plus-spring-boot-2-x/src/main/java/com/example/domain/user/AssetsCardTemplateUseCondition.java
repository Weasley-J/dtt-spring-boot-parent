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
 * 卡使用场景条件约束
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssetsCardTemplateUseCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 卡模板
     */
    private Integer assetsCardTemplateId;

    /**
     * 约束条件类型  0 指定商品可用 1 指定商品不可用  2全部商品可用   3 黑名单
     */
    private Integer conditionType;

    /**
     * 商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通
     */
    private String goodsKind;

    /**
     * 商品类型:1 实物 2 虚拟 3 服务
     */
    private Integer goodsMold;

    /**
     * 商品类型:0 仅非全球购商品使用，1 仅全球购商品使用  2 均可
     */
    private Integer goodsType;

    /**
     * 是否自营 0 非自营 1 自营 2均可
     */
    private Integer selfFlag;

    /**
     * sku id
     */
    private String skuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 删除标致 0:否 1:是
     */
    private Integer deleteFlag;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建人
     */
    private String updateUserId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
