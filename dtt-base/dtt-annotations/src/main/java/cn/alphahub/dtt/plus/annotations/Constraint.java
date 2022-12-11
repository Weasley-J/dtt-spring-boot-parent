package cn.alphahub.dtt.plus.annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The constraints condition for model of table,
 * <ul>
 *     <li>Taking effect when {@code @Dtt} annotated on class, If {@code @Dtt} annotated on a property of a class, {@code @Constraint} doesn't work. </li>
 * </ul>
 *
 * @author weasley
 * @version 1.3.6
 * @apiNote It is recommended enabling this property on Class to describe constraints information for the table
 * @see Index
 * @see UniqueKey
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {
    /**
     * The index of table
     *
     * @return The index of table
     */
    Index index();

    /**
     * The unique key of table
     *
     * @return unique key
     */
    UniqueKey unique();
}
