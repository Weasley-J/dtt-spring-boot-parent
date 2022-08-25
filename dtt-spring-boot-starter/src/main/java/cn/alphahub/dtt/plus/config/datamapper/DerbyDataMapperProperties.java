package cn.alphahub.dtt.plus.config.datamapper;

import cn.alphahub.dtt.plus.config.DttProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping for DERBY database
 *
 * @author weasley
 * @version 1.3.5
 */
@Data
@ConfigurationProperties(prefix = DttProperties.PREFIX + ".data-type-mapper.derby")
public class DerbyDataMapperProperties {
    /**
     * Whether to enable DERBY database columns' name in uppercase
     */
    private Boolean enableColumnUpperCase = true;
    /**
     * key: java type; value: DERBY data type<br>
     *
     * @see <a href="https://db.apache.org/derby/docs/10.16/ref/refderby.pdf">official documentation</a>
     */
    private Properties mappingProperties;
}
