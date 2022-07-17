package com.example.springboot.m3.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 药店云关联云药房商品
 * </p>
 */
@Data

@NoArgsConstructor
@AllArgsConstructor

public class ItemRetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Integer id;

    /**
     * itemId
     */
    private Integer itemId;


}
