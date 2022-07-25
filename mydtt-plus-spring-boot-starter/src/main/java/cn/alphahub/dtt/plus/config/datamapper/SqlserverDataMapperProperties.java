package cn.alphahub.dtt.plus.config.datamapper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * The mapper of Java data type mapping with sqlserver
 *
 * @author weasley
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "alphahub.dtt.data-type-mapper.sqlserver")
public class SqlserverDataMapperProperties {
    /**
     * Default character collation
     */
    private String defaultCollate = "SQL_Latin1_General_CP1_CI_AS";
    /**
     * key: java type; value: sqlserver type
     */
    private Properties mappingProperties;
}
