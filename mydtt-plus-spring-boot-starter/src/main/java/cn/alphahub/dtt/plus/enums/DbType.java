package cn.alphahub.dtt.plus.enums;

import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
public enum DbType {
    MYSQL, ORACLE, DB2, SQLSERVER, MARIADB, POSTGRESQL;

    /**
     * jdbc url prefix
     */
    private static final Map<String, DbType> JDBC_URL_PREFIX_MAP;

    static {
        JDBC_URL_PREFIX_MAP = new ConcurrentHashMap<>(8);
        JDBC_URL_PREFIX_MAP.put("jdbc:mysql:", DbType.MYSQL);
        JDBC_URL_PREFIX_MAP.put("jdbc:oracle:", DbType.ORACLE);
        JDBC_URL_PREFIX_MAP.put("jdbc:db2:", DbType.DB2);
        JDBC_URL_PREFIX_MAP.put("jdbc:sqlserver:", DbType.SQLSERVER);
        JDBC_URL_PREFIX_MAP.put("jdbc:mariadb:", DbType.MARIADB);
        JDBC_URL_PREFIX_MAP.put("jdbc:postgresql:", DbType.POSTGRESQL);
    }

    /**
     * jdbcUrl获取数据库类型
     *
     * @param jdbcUrl jdbc url
     * @return DbType
     */
    public static DbType getDbType(String jdbcUrl) {
        return JDBC_URL_PREFIX_MAP.entrySet().stream().filter(entry -> jdbcUrl.startsWith(entry.getKey())).map(Map.Entry::getValue).findFirst().orElse(null);
    }

    /**
     * 从IOC中获取数据库类型
     *
     * @return DbType
     */
    public static DbType getDbType() {
        DataSourceProperties dataSourceProperties = SpringUtil.getBean(DataSourceProperties.class);
        return getDbType(dataSourceProperties.getUrl());
    }

    /**
     * @return 获取小写Db类型
     */
    public static List<String> getLowerCaseDbTypes() {
        return Arrays.stream(DbType.values()).map(dbType -> dbType.name().toLowerCase()).collect(Collectors.toList());
    }

}
