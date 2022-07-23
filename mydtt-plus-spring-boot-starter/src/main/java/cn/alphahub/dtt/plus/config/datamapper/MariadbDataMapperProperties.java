package cn.alphahub.dtt.plus.config.datamapper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with mariadb
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "alphahub.dtt.data-type-mapper.mariadb")
public class MariadbDataMapperProperties {
    /**
     * key: java type; value: mariadb type
     */
    private Properties mappingProperties;
}
