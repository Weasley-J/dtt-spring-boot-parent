package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping for HSQL database
 *
 * @author weasley
 * @version 1.3.5
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.hsql")
public class HsqlDataMapperProperties {
    /**
     * Whether to enable HSQL database columns' name in uppercase
     */
    private Boolean enableColumnUpperCase = false;
    /**
     * key: java type; value: HSQL data type
     */
    private Properties mappingProperties;
}
