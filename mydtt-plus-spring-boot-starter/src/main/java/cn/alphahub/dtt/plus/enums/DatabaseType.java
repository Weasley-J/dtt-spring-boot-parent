package cn.alphahub.dtt.plus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据库类型
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
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

}
