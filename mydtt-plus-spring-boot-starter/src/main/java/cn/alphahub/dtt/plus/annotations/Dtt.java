package cn.alphahub.dtt.plus.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 域模型、元数据的描述信息
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
     * 模型描述信息，与表的comment属性对应
     *
     * @return 描述信息
     */
    String value() default "";

    /**
     * @return 是否主键
     */
    boolean primaryKey() default false;

    /**
     * Data types mapped to the database，For example:  varchar(64)
     *
     * @return data types mapped to the database
     */
    String dbDataType() default "";

    /**
     * @return 默认值
     */
    String defaultValue() default "";

    /**
     * The constraints condition for model of table.
     *
     * @return constraints condition
     * @apiNote It is recommended enabling this property on Class to describe constraints information for the table
     * @see Index
     * @see Unique
     */
    Constraint[] constraints() default {};
}
