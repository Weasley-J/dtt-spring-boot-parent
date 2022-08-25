package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with mysql
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.mysql")
public class MysqlDataMapperProperties {
    /**
     * The default engine of mysql
     */
    private String defaultEngine = "InnoDB";
    /**
     * Default charset
     */
    private String defaultCharset = "utf8mb4";
    /**
     * Default character collation
     */
    private String defaultCollate = "utf8mb4_general_ci";
    /**
     * key: java type; value: mysql type
     */
    private Properties mappingProperties;
}
