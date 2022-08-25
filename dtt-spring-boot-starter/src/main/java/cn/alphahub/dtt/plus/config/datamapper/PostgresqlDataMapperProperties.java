package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with postgresql
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.postgresql")
public class PostgresqlDataMapperProperties {
    /**
     * key: java type; value: postgresql type
     */
    private Properties mappingProperties;
}
