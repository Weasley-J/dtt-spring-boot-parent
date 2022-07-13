package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.enums.DbType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Properties;

/**
 * Java与数据库类型映射
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
     * The properties' relationship of Java data type mapping to database data type
     */
    @NestedConfigurationProperty
    private DataTypeMappingProperties dataTypeMapping;

    /**
     * 数据类型映射属性
     */
    @Data
    @ConfigurationProperties(prefix = "alphahub.dtt.data-type-mapping")
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
         * @param dbType 数据库类型
         * @return Properties Mapping
         */
        public Properties getPropsByDbType(DbType dbType) {
            switch (dbType) {
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
         * @param dbType 数据库类型
         * @return Properties Mapping
         */
        public Properties getPropsByDbTypeJavaTypeIsLowerCase(DbType dbType) {
            switch (dbType) {
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
}
