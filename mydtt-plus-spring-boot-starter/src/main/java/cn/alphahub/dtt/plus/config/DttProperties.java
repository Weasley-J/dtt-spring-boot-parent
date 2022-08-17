package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.config.datamapper.*;
import cn.alphahub.dtt.plus.enums.BannerMode;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.SysUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static cn.alphahub.dtt.plus.config.DttProperties.PREFIX;
import static cn.alphahub.dtt.plus.enums.BannerMode.ON;

/**
 * The data type mapping between Java and Database
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Data
@ConfigurationProperties(prefix = PREFIX)
public class DttProperties {
    public static final String PREFIX = "alphahub.dtt";
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
     * The configuration properties of writing all table DLL statements to local file.
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
     * The mapper configuration for handling the number of decimals for high precision data types
     */
    @NestedConfigurationProperty
    private HighPrecisionDataMapper highPrecisionDataMapper;
    /**
     * The properties of sql-script-mapper to query the given table whether exists
     * <p>
     * key: DatabaseType, value: sql-script-mapper
     */
    @NestedConfigurationProperty
    private Map<DatabaseType, TableExistsSqlMapperProperties> tableExistsSqlMapper;

    /**
     * The configuration property of DTT-MyBatis,<br>
     * To provide the ability of fully automated ORM framework support.
     */
    @Data
    @ConfigurationProperties(prefix = PREFIX + ".mybatis-orm-support")
    public static class DttMybatisOrmSupportProperties {
        /**
         * Whether to enable mybatis fully automatic ORM support in the range of RDB supported by DTT
         *
         * @see DatabaseType
         */
        private Boolean isEnable = true;
    }

    /**
     * Template property configuration
     */
    @Data
    @ConfigurationProperties(prefix = PREFIX + ".template")
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
    @ConfigurationProperties(prefix = PREFIX + ".code-generator")
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
         * The domain class with fully qualified class name what your want to generate code. It's optional,
         * This configuration is useful if your project is already run in production, DTT will create tables on demand,
         * The given classes must be implements {@link java.io.Serializable}.<br>
         * <p> Yaml Configuration example:
         * <pre>
         * alphahub:
         *   dtt:
         *     code-generator:
         *       is-enable: on
         *       module-name: dtt
         *       module-package: com.example
         *       module-path: /Users/weasley/Development/IdeaProjects/mydtt-plus-spring-boot-parent/mydtt-plus-spring-boot-starter-tests/mydtt-plus-spring-boot-2-x
         *       base-classes:
         *         - com.example.domain.dtt.DttMember
         *         - com.example.domain.dtt.DttPerson
         * </pre>
         */
        private Set<Class<? extends Serializable>> baseClasses;
    }

    /**
     * The configuration properties of writing all table DLL statements to local file.
     */
    @Data
    @ConfigurationProperties(prefix = PREFIX + ".all-in-one-table")
    public static class AllInOneTableProperties {
        /**
         * Whether to write all SQL of table creation to local files
         */
        private Boolean enable = false;
        /**
         * The filename of the exported SQL statement
         */
        private String filename = "AllInOne.sql";
        /**
         * The absolute filepath of all table DDL statements to, Take the current working path: "user.dir" If not configured.
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
    @ConfigurationProperties(prefix = PREFIX + ".data-type-mapper")
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
         * The data mapper properties of  H2 database.
         */
        private H2DataMapperProperties h2;
        /**
         * The mapper of Java data type mapping for HSQL database
         */
        private HsqlDataMapperProperties hsql;
        /**
         * The mapper of Java data type mapping for DERBY database
         */
        private DerbyDataMapperProperties derby;

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
                case H2:
                    return this.getH2().getMappingProperties();
                case HSQL:
                    return this.getHsql().getMappingProperties();
                case DERBY:
                    return this.getDerby().getMappingProperties();
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
                    return convertJavaTypeToLowercase(getDb2().getMappingProperties());
                case MYSQL:
                    return convertJavaTypeToLowercase(getMysql().getMappingProperties());
                case ORACLE:
                    return convertJavaTypeToLowercase(getOracle().getMappingProperties());
                case MARIADB:
                    return convertJavaTypeToLowercase(getMariadb().getMappingProperties());
                case SQLSERVER:
                    return convertJavaTypeToLowercase(getSqlserver().getMappingProperties());
                case POSTGRESQL:
                    return convertJavaTypeToLowercase(getPostgresql().getMappingProperties());
                case H2:
                    return convertJavaTypeToLowercase(getH2().getMappingProperties());
                case HSQL:
                    return convertJavaTypeToLowercase(getHsql().getMappingProperties());
                case DERBY:
                    return convertJavaTypeToLowercase(getDerby().getMappingProperties());
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
    @ConfigurationProperties(prefix = PREFIX + ".string-length-mapper")
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
         * Text length of default if missing
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
        @ConfigurationProperties(prefix = PREFIX + ".string-length-mapper.length-configs")
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

    /**
     * The mapper of high precision data types
     */
    @Data
    @ConfigurationProperties(prefix = PREFIX + ".high-precision-data-mapper")
    public static class HighPrecisionDataMapper {
        /**
         * The default high precision data type of Java.
         */
        private String highPrecisionDataType = "BigDecimal";
        /**
         * The default integer part length of high precision data type.
         */
        private Integer defaultIntegerLength = 10;
        /**
         * The default decimal part length of high precision data type.
         */
        private Integer defaultDecimalLength = 6;
        /**
         * The precision configuration list for some text.
         */
        @NestedConfigurationProperty
        private List<PrecisionConfigurationProperties> precisionConfigs;

        /**
         * The precision configuration list for some text. i.e:
         * <p>
         * Take <b>MySQL<b> as an example, if you have the following configuration.
         * <pre>
         * alphahub:
         *   dtt:
         *     high-precision-data-mapper:
         *       high-precision-data-type: BigDecimal
         *       default-integer-length: 10
         *       default-decimal-length: 6
         *       precision-configs:
         *         - text: price,amount
         *           integer-length: 10
         *           decimal-length: 2
         * </pre>
         * <p>
         * When a column of some table contains 'price' or 'amount',
         * DTT will infer the data type of the database point for this column as: decimal(10,2)
         */
        @Data
        @ConfigurationProperties(prefix = PREFIX + ".high-precision-data-mapper.precision-configs")
        public static class PrecisionConfigurationProperties {
            /**
             * The text property is the content you want some column contained,
             * Multiple 'text' be separated by commas(","). i.e: price,amount
             */
            private String text;
            /**
             * The length of integer part
             */
            private Integer integerLength;
            /**
             * The length of decimal part
             */
            private Integer decimalLength;
        }
    }

    /**
     * The properties of sql-script-mapper to query the given table whether exists
     */
    @Data
    @ConfigurationProperties(prefix = PREFIX + ".table-exists-sql-mapper")
    public static class TableExistsSqlMapperProperties {
        /**
         * The SQL script to  query the given table whether exists, the table name format(underline),
         * <p>
         * i.e: dtt_member
         *
         * @see DatabaseType#MYSQL
         * @see DatabaseType#SQLSERVER
         * @see DatabaseType#MARIADB
         * @see DatabaseType#POSTGRESQL
         */
        private String scriptOfLowerCaseTableName;
        /**
         * The SQL script to  query the given table whether exists, the table name format(underline), Optional.
         * <p>
         * i.e: DTT_MEMBER
         *
         * @see DatabaseType#DB2
         * @see DatabaseType#H2
         * @see DatabaseType#ORACLE
         */
        private String scriptOfUpperCaseTableName;
    }
}
