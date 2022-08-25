package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with oracle
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.oracle")
public class OracleDataMapperProperties {
    /**
     * Whether to enable Oracle database columns' name in uppercase
     */
    private Boolean enableColumnUpperCase = true;
    /**
     * key: java type; value: oracle type
     */
    private Properties mappingProperties;
}
