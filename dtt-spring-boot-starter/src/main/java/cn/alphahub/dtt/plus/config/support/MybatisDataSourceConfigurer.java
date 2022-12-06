package cn.alphahub.dtt.plus.config.support;

import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

import static cn.alphahub.dtt.plus.config.support.MybatisDataSourceConfigurer.MybatisPlusProperties;
import static cn.alphahub.dtt.plus.config.support.MybatisDataSourceConfigurer.MybatisProperties;
import static cn.alphahub.dtt.plus.config.support.MybatisDataSourceConfigurer.MybatisSupportCondition;


/**
 * Configuration for MyBatis, If missing Mybatis autoconfiguration Bean.
 * <p>
 * Do a supplementary data source configuration between Mybatis and MybatisPlus when the data source number autoconfiguration is missing, if possible.
 *
 * @author Weasley
 * @since 1.0.6
 */
@Configuration(proxyBeanMethods = false)
@Conditional({MybatisSupportCondition.class})
@AutoConfigureBefore({InitDttHandler.class,})
@ConditionalOnBean(annotation = {EnableDtt.class})
@ConfigurationPropertiesScan({"cn.alphahub.dtt.plus.config"})
@ConditionalOnMissingBean({SqlSessionFactory.class, SqlSessionTemplate.class})
@EnableConfigurationProperties({DataSourceProperties.class, MybatisProperties.class, MybatisPlusProperties.class})
public class MybatisDataSourceConfigurer {

    @SuppressWarnings("unchecked")
    protected static <T> T createDataSource(DataSourceProperties properties, Class<? extends DataSource> type) {
        return (T) properties.initializeDataSourceBuilder().type(type).build();
    }

    @Bean
    @ConditionalOnSingleCandidate(value = DataSource.class)
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = createDataSource(properties, HikariDataSource.class);
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

    @Bean
    @DependsOn({"dataSource"})
    @ConditionalOnMissingBean(value = {SqlSessionFactory.class})
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource,
                                               MybatisProperties mybatis,
                                               MybatisPlusProperties mybatisPlus
    ) {
        org.apache.ibatis.session.Configuration configuration = mybatis.getConfiguration();
        if (configuration == null) {
            configuration = mybatisPlus.getConfiguration();
        }
        Environment environment = new Environment
                .Builder("333666999")
                .dataSource(dataSource)
                .transactionFactory(new SpringManagedTransactionFactory())
                .build();
        configuration.setEnvironment(environment);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    @Bean
    @DependsOn({"sqlSessionFactory"})
    @ConditionalOnMissingBean(value = {SqlSessionTemplate.class})
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @DependsOn({"dataSource"})
    @ConditionalOnMissingBean(value = {DataSourceTransactionManager.class})
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Spring version number prefix greater or equal 3 will be autowired
     */
    public static class MybatisSupportCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            String mybatisProperty = context.getEnvironment().getProperty(MybatisProperties.MYBATIS_PREFIX + ".mapper-locations");
            String mybatisPlusProperty = context.getEnvironment().getProperty(Constants.MYBATIS_PLUS + ".mapper-locations");
            boolean mybatisPropertyIsAllBlank = org.apache.commons.lang3.StringUtils.isAllBlank(mybatisProperty, mybatisPlusProperty);
            if (mybatisPropertyIsAllBlank) {
                return false;
            }
            String springVersionPrefix = SpringApplication.class.getPackage().getImplementationVersion().split("\\.")[0];
            if (StringUtils.hasText(springVersionPrefix)) {
                String _javaVersion = System.getProperty("java.version").split("\\.")[0];
                int javaVersion = Integer.parseInt(_javaVersion);
                return Integer.parseInt(springVersionPrefix) >= 3 && javaVersion >= 17;
            }
            return false;
        }
    }

    /**
     * Configuration properties for MyBatis.
     *
     * @author Eddú Meléndez
     * @author Kazuki Shimizu
     */
    @ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
    public static class MybatisProperties {

        public static final String MYBATIS_PREFIX = "mybatis";

        private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        /**
         * Location of MyBatis xml config file.
         */
        private String configLocation;

        /**
         * Locations of MyBatis mapper files.
         */
        private String[] mapperLocations;

        /**
         * Packages to search type aliases. (Package delimiters are ",; \t\n")
         */
        private String typeAliasesPackage;

        /**
         * The super class for filtering type alias. If this not specifies, the MyBatis deal as type alias all classes that
         * searched from typeAliasesPackage.
         */
        private Class<?> typeAliasesSuperType;

        /**
         * Packages to search for type handlers. (Package delimiters are ",; \t\n")
         */
        private String typeHandlersPackage;

        /**
         * Indicates whether perform presence check of the MyBatis xml config file.
         */
        private boolean checkConfigLocation = false;

        /**
         * Execution mode for {@link SqlSessionTemplate}.
         */
        private ExecutorType executorType;

        /**
         * The default scripting language driver class. (Available when use together with mybatis-spring 2.0.2+)
         */
        private Class<? extends LanguageDriver> defaultScriptingLanguageDriver;

        /**
         * Externalized properties for MyBatis configuration.
         */
        private Properties configurationProperties;

        /**
         * A Configuration object for customize default settings. If {@link #configLocation} is specified, this property is
         * not used.
         */
        @NestedConfigurationProperty
        private org.apache.ibatis.session.Configuration configuration;

        /**
         * @since 1.1.0
         */
        public String getConfigLocation() {
            return this.configLocation;
        }

        /**
         * @since 1.1.0
         */
        public void setConfigLocation(String configLocation) {
            this.configLocation = configLocation;
        }

        public String[] getMapperLocations() {
            return this.mapperLocations;
        }

        public void setMapperLocations(String[] mapperLocations) {
            this.mapperLocations = mapperLocations;
        }

        public String getTypeHandlersPackage() {
            return this.typeHandlersPackage;
        }

        public void setTypeHandlersPackage(String typeHandlersPackage) {
            this.typeHandlersPackage = typeHandlersPackage;
        }

        public String getTypeAliasesPackage() {
            return this.typeAliasesPackage;
        }

        public void setTypeAliasesPackage(String typeAliasesPackage) {
            this.typeAliasesPackage = typeAliasesPackage;
        }

        /**
         * @since 1.3.3
         */
        public Class<?> getTypeAliasesSuperType() {
            return typeAliasesSuperType;
        }

        /**
         * @since 1.3.3
         */
        public void setTypeAliasesSuperType(Class<?> typeAliasesSuperType) {
            this.typeAliasesSuperType = typeAliasesSuperType;
        }

        public boolean isCheckConfigLocation() {
            return this.checkConfigLocation;
        }

        public void setCheckConfigLocation(boolean checkConfigLocation) {
            this.checkConfigLocation = checkConfigLocation;
        }

        public ExecutorType getExecutorType() {
            return this.executorType;
        }

        public void setExecutorType(ExecutorType executorType) {
            this.executorType = executorType;
        }

        /**
         * @since 2.1.0
         */
        public Class<? extends LanguageDriver> getDefaultScriptingLanguageDriver() {
            return defaultScriptingLanguageDriver;
        }

        /**
         * @since 2.1.0
         */
        public void setDefaultScriptingLanguageDriver(Class<? extends LanguageDriver> defaultScriptingLanguageDriver) {
            this.defaultScriptingLanguageDriver = defaultScriptingLanguageDriver;
        }

        /**
         * @since 1.2.0
         */
        public Properties getConfigurationProperties() {
            return configurationProperties;
        }

        /**
         * @param configurationProperties configurationProperties
         * @since 1.2.0
         */
        public void setConfigurationProperties(Properties configurationProperties) {
            this.configurationProperties = configurationProperties;
        }

        public org.apache.ibatis.session.Configuration getConfiguration() {
            return configuration;
        }

        public void setConfiguration(org.apache.ibatis.session.Configuration configuration) {
            this.configuration = configuration;
        }

        public Resource[] resolveMapperLocations() {
            return Stream.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]))
                    .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
        }

        private Resource[] getResources(String location) {
            try {
                return resourceResolver.getResources(location);
            } catch (IOException e) {
                return new Resource[0];
            }
        }

    }


    /**
     * Configuration properties for MyBatis.
     *
     * @author Eddú Meléndez
     * @author Kazuki Shimizu
     */
    @Data
    @Accessors(chain = true)
    @ConfigurationProperties(prefix = Constants.MYBATIS_PLUS)
    public static class MybatisPlusProperties {

        private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        /**
         * Location of MyBatis xml config file.
         */
        private String configLocation;

        /**
         * Locations of MyBatis mapper files.
         *
         * @since 3.1.2 add default value
         */
        private String[] mapperLocations = new String[]{"classpath*:/mapper/**/*.xml"};

        /**
         * Packages to search type aliases. (Package delimiters are ",; \t\n")
         */
        private String typeAliasesPackage;

        /**
         * The super class for filtering type alias.
         * If this not specifies, the MyBatis deal as type alias all classes that searched from typeAliasesPackage.
         */
        private Class<?> typeAliasesSuperType;

        /**
         * Packages to search for type handlers. (Package delimiters are ",; \t\n")
         */
        private String typeHandlersPackage;

        /**
         * Indicates whether perform presence check of the MyBatis xml config file.
         */
        private boolean checkConfigLocation = false;

        /**
         * Execution mode for {@link org.mybatis.spring.SqlSessionTemplate}.
         */
        private ExecutorType executorType;

        /**
         * The default scripting language driver class. (Available when use together with mybatis-spring 2.0.2+)
         * <p>
         * 如果设置了这个,你会至少失去几乎所有 mp 提供的功能
         */
        private Class<? extends LanguageDriver> defaultScriptingLanguageDriver;

        /**
         * Externalized properties for MyBatis configuration.
         */
        private Properties configurationProperties;

        /**
         * A Configuration object for customize default settings. If {@link #configLocation}
         * is specified, this property is not used.
         * TODO 使用 MybatisConfiguration
         */
        @NestedConfigurationProperty
        private MybatisConfiguration configuration;

        /**
         * 不再需要这个配置,放心删除
         *
         * @deprecated 2022-03-07
         */
        @Deprecated
        private String typeEnumsPackage;

        /**
         * TODO 全局配置
         */
        @NestedConfigurationProperty
        private GlobalConfig globalConfig = GlobalConfigUtils.defaults();


        public Resource[] resolveMapperLocations() {
            return Stream.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]))
                    .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
        }

        private Resource[] getResources(String location) {
            try {
                return resourceResolver.getResources(location);
            } catch (IOException e) {
                return new Resource[0];
            }
        }
    }
}
