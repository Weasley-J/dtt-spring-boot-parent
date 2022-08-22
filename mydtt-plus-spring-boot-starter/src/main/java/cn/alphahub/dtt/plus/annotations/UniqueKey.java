package cn.alphahub.dtt.plus.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * To annotate a field of a domain class is one of the unique key for table
 *
 * @author weasley
 * @version 1.3.6
 */
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueKey {
    /**
     * The name of the <em>fields</em> (mapping to table columns) which used as unique key for table
     *
     * @return The name of the fields (mapping to table columns)
     */
    String[] columns() default {};
}
