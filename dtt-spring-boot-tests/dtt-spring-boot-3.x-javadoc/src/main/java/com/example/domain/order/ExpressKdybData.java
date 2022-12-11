package com.example.domain.order;

import lombok.Data;

/**
 * @author: zhuyonglin
 * @description:
 * @date: 2021-10-11 11:21
 **/
@Data
public class ExpressKdybData {

    private String context;

    private String time;

    private String ftime;

    private String status;

    private String areaCode;

    private String areaName;
}
