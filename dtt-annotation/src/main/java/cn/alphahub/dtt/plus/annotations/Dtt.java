package cn.alphahub.dtt.plus.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Information that describes the domain model, metadata
 * <ul>
 *     <li>When Dtt is annotated on the class, the actual value of 'value properties' will be used as the description of the model</li>
 * </ul>
 *
 * @author weasley
 * @version 1.0.0
 */
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Dtt {
    /**
     * The model description information corresponds to the comment property of the table
     *
     * @return the comment description
     */
    String value() default "";

    /**
     * @return Whether the column is the primary key
     */
    boolean primaryKey() default false;

    /**
     * Data types mapped to the database，For example:  varchar(64)
     *
     * @return data types mapped to the database
     */
    String dbDataType() default "";

    /**
     * The default value for column
     */
    String defaultValue() default "";

    /**
     * The length for {@link String} type(The column datatype mapped to Java {@link String} type)
     */
    int length() default -1;

    /**
     * The precision for {@link java.math.BigDecimal} type(The column datatype mapped to Java {@link java.math.BigDecimal} type)
     *
     * @return precision for {@link java.math.BigDecimal} type
     */
    int precision() default -1;

    /**
     * The scale for {@link java.math.BigDecimal} type(The column datatype mapped to Java {@link java.math.BigDecimal} type)
     *
     * @return scale for {@link java.math.BigDecimal} type
     */
    int scale() default -1;

    /**
     * The constraints condition for model of table.
     *
     * @return constraints condition
     * @apiNote It is recommended enabling this property on Class to describe constraints information for tables
     * @implNote Not yet implemented
     * @implSpec
     * @see Index
     * @see UniqueKey
     */
    Constraint[] constraints() default {};
}
