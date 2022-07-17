package cn.alphahub.dtt.plus.constant;

/**
 * 常量类
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
public interface Constants {
    /**
     * primary key
     */
    String PRIMARY_KEY = "id";
    /**
     * 内部 'properties' 元数据配置文件
     */
    String[] PROPERTIES_FILES = {"META-INF/dtt-extra.properties",};

    /**
     * 内部 'ddt-data-type-mapping.yml' 元数据配置文件
     */
    String DDT_DATA_TYPE_MAPPER = "META-INF/ddt-data-type-mapping.yml";
    /**
     * vm模版主键标识字段
     */
    String PRIMARY_KEY_MARK = "primaryKey";
    /**
     * 建造者模式类名后缀
     */
    String BUILDER_SUFFIX = "Builder";
    /**
     * serialVersionUID
     */
    String SERIAL_VERSION_UID = "serialVersionUID";
    /**
     * get method prefix
     */
    String GET = "get";
}
