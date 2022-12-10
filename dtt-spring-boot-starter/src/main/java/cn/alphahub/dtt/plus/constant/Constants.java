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
     * null string
     */
    String NULL_STRING = "NULL";
    /**
     * 内部 'properties' 元数据配置文件
     */
    @SuppressWarnings({"all"})
    String[] PROPERTIES_FILES = {"META-INF/dtt-extra.properties",};
    /**
     * 内部 'ddt-data-mapper.yml' 元数据配置文件
     */
    String DDT_DATA_TYPE_MAPPER = "META-INF/ddt-data-mapper.yml";
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

    /* Custom Javadoc Tag Start */
    /**
     * Tags for {@link String} type to define the length<br/>
     * Usage: Add {@link @length} tag on filed property for your Java model
     */
    String CUSTOM_TAG_LENGTH = "length";
    /**
     * Tags for {@link java.math.BigDecimal} type to define the precision<br/>
     * Usage: Add {@link @precision} tags on filed property for your Java model
     */
    String CUSTOM_TAG_PRECISION = "precision";
    /**
     * Tags for {@link java.math.BigDecimal} type to define the scale<br/>
     * Usage: Add {@link @scale} tag on filed property for your Java model
     */
    String CUSTOM_TAG_SCALE = "scale";
    /**
     * To set a default value for a column<br/>
     * Usage: Add {@link @defaultValue} tag on filed property to set a default value for a column
     */
    String CUSTOM_TAG_DEFAULT_VALUE = "defaultValue";
    /**
     * To specify a field is the primary key<br/>
     * Usage: Add {@link @primaryKey} tag on filed property to specify the field is the primary key
     */
    String CUSTOM_TAG_IS_PRIMARY_KEY = "primaryKey";
    /**
     * To specify a data type for a column<br/>
     * Usage: Add {@link @dbDataType} tag on filed property to  specify a data type for a column
     */
    String CUSTOM_TAG_DB_DATA_TYPE = "dbDataType";
    /* Custom Javadoc Tag End */
}
