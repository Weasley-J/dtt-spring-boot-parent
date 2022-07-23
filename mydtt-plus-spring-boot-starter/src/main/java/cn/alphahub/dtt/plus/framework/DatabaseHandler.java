package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.DataTypeMapperProperties;

/**
 * Handling some DB information
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@Component
@AutoConfigureBefore({ContextWrapper.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DataSourceProperties.class, DataTypeMapperProperties.class})
public class DatabaseHandler {

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

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DataTypeMapperProperties dataTypeMapping;

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
     * javaDataType to databaseDataType
     *
     * @param javaDataType java data type
     * @return database data type
     * @apiNote BigDecimal to decimal, So on.
     */
    public String getDbDataType(String javaDataType) {
        Properties props = dataTypeMapping.getPropsByDbType(getDbType());
        Object value = props.get(javaDataType);
        if (null == value) {
            Properties lowerCaseProps = dataTypeMapping.getPropsByDbTypeJavaTypeIsLowerCase(getDbType());
            value = lowerCaseProps.get(javaDataType);
            final Logger logger = LoggerFactory.getLogger(DatabaseType.class);
            if (null == value && logger.isErrorEnabled()) {
                logger.error("Java数据类型映射至数据库数据类型出错，数据类型映射类型: {}, Java-data-type = {}", JacksonUtil.toJson(props), javaDataType);
            }
        }
        return Objects.nonNull(value) ? value.toString() : "";
    }

    /**
     * 从IOC中获取数据库类型
     *
     * @return DatabaseType
     */
    public DatabaseType getDbType() {
        return getDbType(dataSourceProperties.getUrl());
    }

    /**
     * @return 获取小写Db类型
     */
    public List<String> getLowerCaseDbTypes() {
        return Arrays.stream(DatabaseType.values()).map(dbType -> dbType.name().toLowerCase()).collect(Collectors.toList());
    }
}
