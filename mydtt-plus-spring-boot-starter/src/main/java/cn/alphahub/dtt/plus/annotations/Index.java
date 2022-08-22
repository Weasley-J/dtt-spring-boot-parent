package cn.alphahub.dtt.plus.annotations;

/**
 * The index of the table
 *
 * @author weasley
 * @version 1.3.6
 */
public @interface Index {
    /**
     * The name of the <em>fields</em> (mapping to table columns) which used as an index for table
     *
     * @return The name of the fields (mapping to the columns)
     */
    String[] columns() default {};
}
