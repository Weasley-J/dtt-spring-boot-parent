package cn.alphahub.dtt.plus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Database Type
 *
 * @author weasley
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DatabaseType {
    MYSQL,
    ORACLE,
    DB2,
    SQLSERVER,
    MARIADB,
    POSTGRESQL,
    H2,
    HSQL,
    DERBY;
}
