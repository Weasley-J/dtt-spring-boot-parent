package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品操作日志表
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-06-01
 */

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */

    private Integer id;

    /**
     * 页面 1-商品库 2-预商品库 3-上架管理 4-商品审核 5-后台类目 6-前台类目
     */
    private Integer operationPage;

    /**
     * 类型
     */
    private String operationType;

    /**
     * 内容
     */
    private String operationContent;

    /**
     * 操作的主表名称
     */
    private String operationTable;

    /**
     * 操作的主表的id(主键)
     */
    private Integer operationTableId;

    /**
     * 操作条件
     */
    private String operationCondition;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;


}
