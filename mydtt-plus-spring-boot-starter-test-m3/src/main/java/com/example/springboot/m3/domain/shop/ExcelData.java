package com.example.springboot.m3.domain.shop;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wcy
 * @Date: 2020/4/13 18:51
 * @Description:
 */
@Data
public class ExcelData implements Serializable {


    /**
     * 表头
     */
    private List<String> titles;

    /**
     * 数据
     */
    private List<List<Object>> rows;

    /**
     * 页签名称
     */
    private String name;

    private Integer sheetNum;
}
