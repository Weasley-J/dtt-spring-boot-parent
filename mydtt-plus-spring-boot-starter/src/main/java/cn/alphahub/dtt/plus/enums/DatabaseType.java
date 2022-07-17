package cn.alphahub.dtt.plus.enums;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 数据库类型
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Getter
@AllArgsConstructor
public enum DatabaseType {
    MYSQL, ORACLE, DB2, SQLSERVER, MARIADB, POSTGRESQL;

    /**
     * jdbc url prefix
     */
    private static final Map<String, DatabaseType> JDBC_URL_PREFIX_MAP;

    static {
        JDBC_URL_PREFIX_MAP = new ConcurrentHashMap<>(8);
        JDBC_URL_PREFIX_MAP.put("jdbc:mysql:", DatabaseType.MYSQL);
        JDBC_URL_PREFIX_MAP.put("jdbc:oracle:", DatabaseType.ORACLE);
        JDBC_URL_PREFIX_MAP.put("jdbc:db2:", DatabaseType.DB2);
        JDBC_URL_PREFIX_MAP.put("jdbc:sqlserver:", DatabaseType.SQLSERVER);
        JDBC_URL_PREFIX_MAP.put("jdbc:mariadb:", DatabaseType.MARIADB);
        JDBC_URL_PREFIX_MAP.put("jdbc:postgresql:", DatabaseType.POSTGRESQL);
    }

    /**
     * jdbcUrl获取数据库类型
     *
     * @param jdbcUrl jdbc url
     * @return DatabaseType
     */
    public static DatabaseType getDbType(String jdbcUrl) {
        return JDBC_URL_PREFIX_MAP.entrySet().stream().filter(entry -> jdbcUrl.startsWith(entry.getKey())).map(Map.Entry::getValue).findFirst().orElse(null);
    }

    /**
     * 从IOC中获取数据库类型
     *
     * @return DatabaseType
     */
    public static DatabaseType getDbType() {
        DataSourceProperties dataSourceProperties = SpringUtil.getBean(DataSourceProperties.class);
        return getDbType(dataSourceProperties.getUrl());
    }

    /**
     * @return 获取小写Db类型
     */
    public static List<String> getLowerCaseDbTypes() {
        return Arrays.stream(DatabaseType.values()).map(dbType -> dbType.name().toLowerCase()).collect(Collectors.toList());
    }

    /**
     * javaDataType to databaseDataType
     *
     * @param javaDataType java data type
     * @return database data type
     * @apiNote BigDecimal to decimal, So on.
     */
    public static String getDbDataType(String javaDataType) {
        DttProperties.DataTypeMappingProperties dataTypeMapping = SpringUtil.getBean(DttProperties.DataTypeMappingProperties.class);
        Properties props = dataTypeMapping.getPropsByDbType(DatabaseType.getDbType());
        Object value = props.get(javaDataType);
        if (null == value) {
            Properties lowerCaseProps = dataTypeMapping.getPropsByDbTypeJavaTypeIsLowerCase(DatabaseType.getDbType());
            value = lowerCaseProps.get(javaDataType);
            final Logger logger = LoggerFactory.getLogger(DatabaseType.class);
            if (null == value && logger.isErrorEnabled()) {
                logger.error("Java数据类型映射至数据库数据类型出错，数据类型映射类型: {}, javaDataType = {}", JacksonUtil.toJson(props), javaDataType);
            }
        }
        return Objects.nonNull(value) ? value.toString() : "";
    }
}
