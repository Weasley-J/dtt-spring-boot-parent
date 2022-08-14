package cn.alphahub.dtt.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The wrapper of dtt-mybatis automatic create table.
 *
 * @since 1.3.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DttMbActWrapper implements Serializable {
    /**
     * The name of domain.
     * <p> i.e: com.example.domain.dtt.DttMember -> dttMember
     */
    private String domainName;
    /**
     * The class of domain mapped to DB table.
     */
    private Class<?> domainClass;
    /**
     * The database table exists
     */
    private Boolean tableExists;
    /**
     * The database table does not exist
     */
    private Boolean tableNotExists;

    public Boolean getTableExists() {
        return !tableNotExists;
    }
}
