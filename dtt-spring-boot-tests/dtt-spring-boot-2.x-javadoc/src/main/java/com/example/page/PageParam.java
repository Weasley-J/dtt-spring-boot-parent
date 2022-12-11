package com.example.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页基础参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;
    /**
     * 分页大小
     */
    private Integer pageSize = 10;
}
