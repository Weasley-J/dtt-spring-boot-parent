package cn.alphahub.dtt.plus.entity;

import cn.alphahub.dtt.plus.enums.DatabaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The property for your database
 *
 * @author Weasley
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DatabaseProperty implements Serializable {
    /**
     * The type of database
     */
    private DatabaseType databaseType;
    /**
     * The name of database
     */
    private String databaseName;
    /**
     * The version of database
     */
    private String databaseVersion;
    /**
     * The integer version of database
     */
    private Integer intDatabaseVersion;
}
