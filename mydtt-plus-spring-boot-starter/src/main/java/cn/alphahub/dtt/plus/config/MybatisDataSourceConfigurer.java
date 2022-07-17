package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Configuration for MyBatis,
 *
 * @author weasley
 * @since 1.0.4
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(annotation = {EnableDtt.class})
@ConditionalOnProperty(prefix = "mybatis", name = {"mapper-locations", "type-aliases-package"})
@EnableConfigurationProperties({MybatisDataSourceConfigurer.MybatisProperties.class})
public class MybatisDataSourceConfigurer {

    @Bean
    @ConditionalOnMissingBean(name = {"dataSource"})
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @DependsOn({"dataSource"})
    @ConditionalOnMissingBean(value = {SqlSessionFactory.class})
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource,
                                               MybatisProperties mybatisProperties
    ) {
        org.apache.ibatis.session.Configuration configuration = mybatisProperties.getConfiguration();
        Environment environment = new Environment
                .Builder("333666999")
                .dataSource(dataSource)
                .transactionFactory(new JdbcTransactionFactory())
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
}
