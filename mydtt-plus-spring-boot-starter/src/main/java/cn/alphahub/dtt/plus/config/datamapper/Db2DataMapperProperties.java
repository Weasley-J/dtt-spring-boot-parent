package cn.alphahub.dtt.plus.config.datamapper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with db2
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "alphahub.dtt.data-type-mapper.db2")
public class Db2DataMapperProperties {
    /**
     * key: java type; value: db2 type
     */
    private Properties mappingProperties;
}
