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
public @interface Unique {
    /**
     * Returns the unique key value for table
     *
     * @return The unique key value for table
     */
    String[] columns() default {};
}
