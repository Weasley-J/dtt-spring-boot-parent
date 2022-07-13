package cn.alphahub.dtt.plus.framework.core.annotations;

import cn.alphahub.dtt.plus.config.DataSourceAutoConfig;
import cn.alphahub.dtt.plus.config.DefaultExtraPropertiesLoader;
import cn.alphahub.dtt.plus.config.DefaultExtraYamlSourceLoader;
import cn.alphahub.dtt.plus.config.InitDttClient;
import cn.alphahub.dtt.plus.config.InitDttHandler;
import cn.alphahub.dtt.plus.config.VelocityHandler;
import cn.alphahub.dtt.plus.enums.ParseType;
import cn.alphahub.dtt.plus.framework.core.*;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用 Dtt 处理程
 * <p>
 * <b>What is DTT?</b>
 *     <ul>
 *         <li>It's means  `Domain-to-Table`，As we know，The Object of Java is `Domain`，Database's is `Table` yet.</li>
 *         <li>You can easily use the '@EnableDtt' annotation to prevent JAVA objects from automatically creating data tables into your database with minimal configuration</li>
 *         <li>DTT can easily preserve comments on database from 'java doc' to database table comments</li>
 *     </ul>
 * </p>
 *
 * @author weasley
 * @version 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DataSourceAutoConfig.class, InitDttHandler.class, DefaultAnnotationParser.class,
        DefaultJavaDocParser.class, DefaultDb2TableHandler.class, DefaultMariadbTableHandler.class,
        DefaultMysqlTableHandler.class, DefaultOracleTableHandler.class, DefaultPostgresqlTableHandler.class,
        DefaultSqlserverTableHandler.class, VelocityHandler.class, DttRunner.class,
        DefaultExtraPropertiesLoader.class, DefaultExtraYamlSourceLoader.class, InitDttClient.class
})
public @interface EnableDtt {
    /**
     * Java域模型的基础包路径，全限定包路径
     *
     * @return Java域模型的基础包路径
     */
    String[] scanBasePackages() default {};

    /**
     * Type-safe alternative to {@link #scanBasePackages} for specifying the classes to
     * scan,each class specified will be scanned.
     * <p>
     * JAVA model classes to scan
     * <p>
     * <strong>Note:</strong> Applicable to incremental table creation, when {@link #scanBasePackages} is specified,
     * it will scan all classes in the package specified by {@link #scanBasePackages}
     *
     * @return base classes to scan
     * @since 1.0.0
     */
    Class<?>[] scanBaseClasses() default {};

    /**
     * 解析模型私有属性注释的方式
     *
     * @return 是否使用Comment注解解析表结构，有代码侵入性，默认使用Java Doc注释
     * @see ParseType
     */
    ParseType parseType() default ParseType.JAVA_DOC;

    /**
     * 创建前删除表
     *
     * @return 创建前是否删除表
     */
    boolean dropTableBeforeCreate() default false;
}
