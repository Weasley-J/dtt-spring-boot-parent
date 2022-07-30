package cn.alphahub.dtt.plus.framework.annotations;

import cn.alphahub.dtt.plus.config.DefaultExtraPropertiesLoader;
import cn.alphahub.dtt.plus.config.DefaultExtraYamlSourceLoader;
import cn.alphahub.dtt.plus.config.DttMybatisOrmAutoConfiguration;
import cn.alphahub.dtt.plus.config.support.MyBatisPlusCodeGeneratorConfigurer;
import cn.alphahub.dtt.plus.config.support.MybatisDataSourceConfigurer;
import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.framework.InitDttClient;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.Interceptor.DefaultDttMybatisInterceptor;
import cn.alphahub.dtt.plus.framework.VelocityHandler;
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
 * <ul>
 *     <li>It's means  `Domain-to-Table`,  Domain driven table</li>
 *     <li>Aims to make it easy for you to automatically create DB tables based on your Java model</li>
 *     <li>DTT can easily preserve comments on database from 'java doc' to database table comments</li>
 * </ul>
 *
 * @author weasley
 * @version 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({InitDttHandler.class, InitDttClient.class, DefaultAnnotationParser.class,
        DefaultJavaDocParser.class, DefaultDb2TableHandler.class, DefaultMariadbTableHandler.class,
        DefaultMysqlTableHandler.class, DefaultOracleTableHandler.class, DefaultPostgresqlTableHandler.class,
        DefaultSqlserverTableHandler.class, VelocityHandler.class, ClassScanningProvider.class,
        MybatisDataSourceConfigurer.class, DefaultExtraPropertiesLoader.class, DefaultExtraYamlSourceLoader.class,
        DefaultTemplateExecutor.class, DefaultTemplateResolver.class, DttAggregationRunner.class,
        DatabaseHandler.class, MyBatisPlusCodeGeneratorConfigurer.class, DefaultDttMybatisInterceptor.class,
        DttMybatisOrmAutoConfiguration.class
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
     * The Java model classes be given
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
     * @see ParserType
     */
    ParserType parserType() default ParserType.JAVA_DOC;

    /**
     * 创建前删除表
     *
     * @return 创建前是否删除表
     */
    boolean dropTableBeforeCreate() default false;
}
