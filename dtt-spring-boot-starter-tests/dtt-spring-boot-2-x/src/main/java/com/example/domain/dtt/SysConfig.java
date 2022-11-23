package com.example.domain.dtt;

import cn.alphahub.dtt.plus.annotations.Dtt;
import lombok.Data;

import java.io.Serializable;

/**
 * 参数配置表 sys_config
 *
 * @author ruoyi
 */
@Data
@Dtt("参数配置表")
public class SysConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    //@Excel(name = "参数主键", cellType = ColumnType.NUMERIC)
    @Dtt(primaryKey = true, value = "参数主键")
    private Long configId;

    /**
     * 参数名称
     */
    //@Excel(name = "参数名称")
    @Dtt("参数名称")
    private String configName;

    /**
     * 参数键名
     */
    //@Excel(name = "参数键名")
    @Dtt("参数键名")
    private String configKey;

    /**
     * 参数键值
     */
    //@Excel(name = "参数键值")
    @Dtt("参数键值")
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    //@Excel(name = "系统内置", readConverterExp = "Y=是,N=否")
    @Dtt("系统内置")
    private String configType;
}
