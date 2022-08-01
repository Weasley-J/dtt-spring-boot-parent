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
     * Default character collation, <a href="https://docs.microsoft.com/zh-cn/sql/relational-databases/collations/collation-and-unicode-support?view=sql-server-ver16">Here is the help link for SQLServer official.</a>
     */
    private String defaultCollate = "SQL_Latin1_General_CP1_CI_AS";
    /**
     * key: java type; value: sqlserver type
     */
    private Properties mappingProperties;
}
