package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The data mapper properties of  H2 database.
 *
 * @author weasley
 * @version 1.3.1
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.h2")
public class H2DataMapperProperties {
    /**
     * Whether to enable h2 database columns' name in uppercase
     */
    private Boolean enableColumnUpperCase = true;
    /**
     * key: java type; value: db2 type
     */
    private Properties mappingProperties;
}
