package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.enums.BannerMode;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.SysUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;
import java.util.Properties;

import static cn.alphahub.dtt.plus.enums.BannerMode.ON;

/**
 * The data type mapping between Java and Database
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Data
@ConfigurationProperties(prefix = "alphahub.dtt")
public class DttProperties {
    /**
     * Whether to enable
     */
    private Boolean isEnable = true;
    /**
     * Banner mode
     */
    private BannerMode bannerMode = ON;
    /**
     * Whether to print the parsed SQL in the terminal
     */
    private Boolean showSql = true;
    /**
     * Template property configuration, This is the default configuration,
     * don't modify it if you don't need it
     */
    @NestedConfigurationProperty
    private TemplateProperties template;
    /**
     * 所有建表SQL写入文件
     */
    @NestedConfigurationProperty
    private AllInOneTableProperties allInOneTable;
    /**
     * The properties' relationship of Java data type mapping to database data type
     */
    @NestedConfigurationProperty
    private DataTypeMappingProperties dataTypeMapper;
    /**
     * Model attribute If the Java type is 'java.lang.String' type,
     * when the attribute contains text content such as: "text", "content", "message", "phone", "id", "tel", etc.,
     * you can specify their length from 'string-length-mapping' property; Take MySQL as an example:
     * if there is a column whose name is "user_tel", and "user_tel" contains "tel" text,
     * you can specify the data length of "user_tel" attribute like this: varchar(12)
     */
    @NestedConfigurationProperty
    private List<StringLengthMapper> stringLengthMapper;

    /**
     * Template property configuration
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.template")
    public static class TemplateProperties {
        /**
         * SQL template file path
         */
        private String path = "META-INF/sql-templates";
        /**
         * SQL template file name suffix
         */
        private String suffix = ".vm";
    }

    /**
     * All table creation SQL writes to local file configuration properties
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.all-in-one-table")
    public static class AllInOneTableProperties {
        /**
         * 是否创建所有建表SQL写入文件
         */
        private Boolean enable = false;
        /**
         * SQL文件名
         */
        private String filename = "AllInOne.sql";
        /**
         * SQL文件写入的绝对路径,未配置则取当前工作路径: "user.dir"
         */
        private String filepath;

        public String getFilepath() {
            return StringUtils.isNoneBlank(filepath) ? filepath : SysUtil.getUserDir();
        }

        /**
         * @return Absolute Filename of SQL
         */
        public String getAbsoluteFilename() {
            if (getFilepath().endsWith(SysUtil.getFileSeparator())) return getFilepath() + filename;
            else return getFilepath() + SysUtil.getFileSeparator() + filename;
        }
    }

    /**
     * 数据类型映射属性
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.data-type-mapper")
    public static class DataTypeMappingProperties {
        /**
         * key: java type; value: mysql type
         */
        private Properties mysql;
        /**
         * key: java type; value: oracle type
         */
        private Properties oracle;
        /**
         * key: java type; value: db2 type
         */
        private Properties db2;
        /**
         * key: java type; value: sqlserver type
         */
        private Properties sqlserver;
        /**
         * key: java type; value: mariadb type
         */
        private Properties mariadb;
        /**
         * key: java type; value: postgresql type
         */
        private Properties postgresql;

        /**
         * 获取数据类型映射对应关系
         *
         * @param databaseType 数据库类型
         * @return Properties Mapping
         */
        public Properties getPropsByDbType(DatabaseType databaseType) {
            switch (databaseType) {
                case DB2:
                    return getDb2();
                case MYSQL:
                    return getMysql();
                case ORACLE:
                    return getOracle();
                case MARIADB:
                    return getMariadb();
                case SQLSERVER:
                    return getSqlserver();
                case POSTGRESQL:
                    return getPostgresql();
                default:
                    return new Properties();
            }
        }

        /**
         * 获取数据类型映射对应关系（JAVA的数据类型格式小写）
         *
         * @param databaseType 数据库类型
         * @return Properties Mapping
         */
        public Properties getPropsByDbTypeJavaTypeIsLowerCase(DatabaseType databaseType) {
            switch (databaseType) {
                case DB2:
                    return convertJavaDataTypeToLowercase(getDb2());
                case MYSQL:
                    return convertJavaDataTypeToLowercase(getMysql());
                case ORACLE:
                    return convertJavaDataTypeToLowercase(getOracle());
                case MARIADB:
                    return convertJavaDataTypeToLowercase(getMariadb());
                case SQLSERVER:
                    return convertJavaDataTypeToLowercase(getSqlserver());
                case POSTGRESQL:
                    return convertJavaDataTypeToLowercase(getPostgresql());
                default:
                    return new Properties();
            }
        }

        /**
         * convert java data types to lowercase
         *
         * @param properties key 大写
         * @return key 大写
         */
        protected Properties convertJavaDataTypeToLowercase(Properties properties) {
            Properties need = new Properties();
            properties.forEach((k, v) -> need.put(k.toString().toLowerCase(), v));
            return need;
        }
    }

    /**
     * Model attribute If the Java type is 'java.lang.String' type,
     * when the attribute contains text content,
     * Examples: "text", "content", "message", "phone", "id", "tel", etc.,
     * you can specify their length from 'string-length-mapping' property; Take MySQL as an example:
     * if there is a column whose name is "user_tel", and "user_tel" contains "tel" text,
     * you can specify the data length of "user_tel" attribute like this: varchar(12)
     * <p>
     * Note: The length of 'java.lang.String' type preferably power of 2.
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.string-length-mapper")
    public static class StringLengthMapper {
        /**
         * database type, Must be not null.
         */
        private DatabaseType databaseType;
        /**
         * Data type of DB,the character text type of your database, Usually the data type that maps Java is character(String) type, i.e: varchar
         */
        private String defaultTextType;
        /**
         * Text length oof default if missing
         */
        private Integer defaultTextLength = 256;
        /**
         * text length configurations properties
         */
        @NestedConfigurationProperty
        private List<LengthProperties> lengthConfigs;

        /**
         * Text  length configuration properties
         */
        @Data
        @ConfigurationProperties(prefix = "alphahub.dtt.string-length-mapper.length-configs")
        public static class LengthProperties {
            /**
             * Text property is the content you want the current column contained,
             * Multiple 'text' be separated by commas(","). i.e: phone,tel,telephone,mail,email
             */
            private String text;
            /**
             * the data length of type
             */
            private Integer length;
        }
    }
}
