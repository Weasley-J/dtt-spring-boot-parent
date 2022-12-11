package com.example.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class SupplierPic implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 图片类型 1-行业资格许可证 2-特批材料
     */
    private Integer type;

    /**
     * 商家id
     */
    private Integer supplierId;

    private LocalDateTime createTime;


}
