package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.config.datamapper.Db2DataMapperProperties;
import cn.alphahub.dtt.plus.config.datamapper.MariadbDataMapperProperties;
import cn.alphahub.dtt.plus.config.datamapper.MysqlDataMapperProperties;
import cn.alphahub.dtt.plus.config.datamapper.OracleDataMapperProperties;
import cn.alphahub.dtt.plus.config.datamapper.PostgresqlDataMapperProperties;
import cn.alphahub.dtt.plus.config.datamapper.SqlserverDataMapperProperties;
import cn.alphahub.dtt.plus.enums.BannerMode;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.SysUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;
import java.util.Map;
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
     * The configuration property of DTT-MyBatis,<br>
     * To provide the ability of fully automated ORM framework support.
     */
    @NestedConfigurationProperty
    private DttMybatisOrmSupportProperties mybatisOrmSupport;
    /**
     * Template property configuration, This is the default configuration,
     * don't modify it if you don't need it
     */
    @NestedConfigurationProperty
    private TemplateProperties template;
    /**
     * /**
     * MyBatis-Plus code generation configuration properties
     * <p>
     * Tips:
     * <ul>
     * <li>Only Service, Mapper, XML files are generated</li>
     * <li>The location of Mapper XML file's path will be like this: src/main/resources/mapper/${module-name}</li>
     * <li>The location of Service src path will be like this: src/main/java/${base-package}/${module-name}</li>
     * <li>The location of Mapper interface src path will be like this: src/main/java/${base-package}/${module-name}</li>
     * </ul>
     */
    @NestedConfigurationProperty
    private CodeGeneratorProperties codeGenerator;
    /**
     * 所有建表SQL写入文件
     */
    @NestedConfigurationProperty
    private AllInOneTableProperties allInOneTable;
    /**
     * The primary key data type mappings，If missing.
     * <ul>
     *     <li>key: database type</li>
     *     <li>value: The data type of primary key</li>
     * </ul>
     */
    private Map<DatabaseType, String> primaryKeyMapper;
    /**
     * The properties' relationship of Java data type mapping to database data type
     */
    @NestedConfigurationProperty
    private DataTypeMapperProperties dataTypeMapper;
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
     * The configuration property of DTT-MyBatis,<br>
     * To provide the ability of fully automated ORM framework support.
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.mybatis-orm-support")
    public static class DttMybatisOrmSupportProperties {
        /**
         * Whether to enable mybatis fully automatic ORM support in the range of RDB supported by DTT
         *
         * @see DatabaseType
         */
        private Boolean isEnable = false;
    }

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
     * MyBatis-Plus code generation configuration properties
     * <p>
     * Tips:
     * <ul>
     * <li>Only Service, Mapper, XML files are generated</li>
     * <li>The location of Mapper XML file's path will be like this: src/main/resources/mapper/${module-name}</li>
     * <li>The location of Service src path will be like this: src/main/java/${base-package}/${module-name}</li>
     * <li>The location of Mapper interface src path will be like this: src/main/java/${base-package}/${module-name}</li>
     * </ul>
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.code-generator")
    public static class CodeGeneratorProperties {
        /**
         * Whether to enable mybatis-plus code generation
         */
        private Boolean isEnable = false;
        /**
         * Whether to show generated code in console
         */
        private Boolean showCode = false;
        /**
         * Whether to overwrite existing files
         */
        private Boolean overrideExists = false;
        /**
         * The name of your module
         */
        private String moduleName;
        /**
         * The package location of generating code
         */
        private String modulePackage;
        /**
         * The absolute path location of your project
         */
        private String modulePath;
        /**
         * The domain package what your want to generate code. It's also the location of your Java Entity's package
         */
        private String basePackage;
        /**
         * The domain with fully qualified class name what your want to generate code. It's optional,Multiple Classes are separated by commas(",")
         */
        private String[] baseClasses;
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
    public static class DataTypeMapperProperties {
        /**
         * The mapper of Java data type mapping with db2
         */
        private Db2DataMapperProperties db2;
        /**
         * The mapper of Java data type mapping with mariadb
         */
        private MariadbDataMapperProperties mariadb;
        /**
         * The mapper of Java data type mapping with mysql
         */
        private MysqlDataMapperProperties mysql;
        /**
         * The mapper of Java data type mapping with oracle
         */
        private OracleDataMapperProperties oracle;
        /**
         * The mapper of Java data type mapping with postgresql
         */
        private PostgresqlDataMapperProperties postgresql;
        /**
         * The mapper of Java data type mapping with sqlserver
         */
        private SqlserverDataMapperProperties sqlserver;

        /**
         * 获取数据类型映射对应关系
         *
         * @param databaseType 数据库类型
         * @return Properties Mapping
         */
        public Properties getPropsByDbType(DatabaseType databaseType) {
            switch (databaseType) {
                case DB2:
                    return this.getDb2().getMappingProperties();
                case MYSQL:
                    return this.getMysql().getMappingProperties();
                case ORACLE:
                    return this.getOracle().getMappingProperties();
                case MARIADB:
                    return this.getMariadb().getMappingProperties();
                case SQLSERVER:
                    return this.getSqlserver().getMappingProperties();
                case POSTGRESQL:
                    return this.getPostgresql().getMappingProperties();
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
                    return this.convertJavaTypeToLowercase(getDb2().getMappingProperties());
                case MYSQL:
                    return this.convertJavaTypeToLowercase(getMysql().getMappingProperties());
                case ORACLE:
                    return this.convertJavaTypeToLowercase(getOracle().getMappingProperties());
                case MARIADB:
                    return this.convertJavaTypeToLowercase(getMariadb().getMappingProperties());
                case SQLSERVER:
                    return this.convertJavaTypeToLowercase(getSqlserver().getMappingProperties());
                case POSTGRESQL:
                    return this.convertJavaTypeToLowercase(getPostgresql().getMappingProperties());
                default:
                    return new Properties();
            }
        }

        /**
         * Convert java data types to lowercase
         *
         * @param properties key 大写
         * @return key 大写
         */
        protected Properties convertJavaTypeToLowercase(Properties properties) {
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
