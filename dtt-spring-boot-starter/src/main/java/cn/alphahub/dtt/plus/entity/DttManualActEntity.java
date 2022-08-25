package cn.alphahub.dtt.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The entity of DTT manual create table
 *
 * @author weasley
 * @since 1.3.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DttManualActEntity implements Serializable {
    /**
     * The class map to table
     */
    private String tableMappedClass;
    /**
     * The table DML statement
     */
    private String tableStatement;
}
