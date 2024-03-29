package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.DttMbActWrapper;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.interceptor.DefaultDttMybatisInterceptor;
import cn.alphahub.dtt.plus.util.StringUtils;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.DttMybatisOrmSupportProperties;
import static cn.alphahub.dtt.plus.config.DttProperties.TableExistsSqlMapperProperties;

/**
 * The configuration for dtt-mybatis
 *
 * @author weasley
 * @version 1.0.0
 */
@Getter
@Component
@Lazy(value = false)
@ConditionalOnClass({SqlSessionFactory.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DttMybatisOrmSupportProperties.class, DttProperties.class})
@AutoConfigureAfter(name = {"org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration", "com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration",})
public class DttMybatisAutoConfiguration implements InitializingBean {
    private static final String[] MYBATIS_PROP_PREFIX = {"mybatis-plus.type-aliases-package", "mybatis.type-aliases-package"};
    private static final String[] SHARDING_SPHERE_BEANS = {"shardingSphereAutoConfiguration", "org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration"};
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * The cache for mybatis type-aliases mapped classes
     * <p>
     * key:The simple name of class(Lower case, small camel case), value: The wrapper class
     */
    private final Map<String, DttMbActWrapper> typeAliasesMap = new ConcurrentHashMap<>(768);
    private final JdbcTemplate jdbcTemplate;
    private final DttProperties dttProperties;
    private final DatabaseProperty databaseProperty;
    private final ApplicationContext applicationContext;
    /**
     * The list of 'SqlSessionFactory'
     */
    private final List<SqlSessionFactory> sqlSessionFactories;
    private final ClassScanningProvider classScanningProvider;
    /**
     * The default interceptor of mybatis-pro
     */
    private final DefaultDttMybatisInterceptor defaultDttMybatisInterceptor;
    private final DttMybatisOrmSupportProperties dttMybatisOrmSupportProperties;
    /**
     * Check if there is a sharding Sphere on the classpath
     */
    private Boolean shardingSphereEnable = false;

    public DttMybatisAutoConfiguration(JdbcTemplate jdbcTemplate,
                                       DttProperties dttProperties,
                                       DatabaseProperty databaseProperty,
                                       ApplicationContext applicationContext,
                                       List<SqlSessionFactory> sqlSessionFactories,
                                       ClassScanningProvider classScanningProvider,
                                       DefaultDttMybatisInterceptor defaultDttMybatisInterceptor,
                                       DttMybatisOrmSupportProperties dttMybatisOrmSupportProperties) {
        this.jdbcTemplate = jdbcTemplate;
        this.dttProperties = dttProperties;
        this.databaseProperty = databaseProperty;
        this.applicationContext = applicationContext;
        this.sqlSessionFactories = sqlSessionFactories;
        this.classScanningProvider = classScanningProvider;
        this.defaultDttMybatisInterceptor = defaultDttMybatisInterceptor;
        this.dttMybatisOrmSupportProperties = dttMybatisOrmSupportProperties;
    }

    @Override
    public void afterPropertiesSet() {
        if (dttProperties.getIsEnable().equals(false)) return;
        if (dttMybatisOrmSupportProperties.getIsEnable().equals(false)) return;
        this.shardingSphereEnable = isShardingSphereEnable();
        sqlSessionFactories.forEach(sqlSessionFactory -> {
            Configuration configuration = sqlSessionFactory.getConfiguration();
            if (ObjectUtils.isNotEmpty(configuration) && !configuration.getInterceptors().contains(defaultDttMybatisInterceptor)) {
                configuration.addInterceptor(defaultDttMybatisInterceptor);
            }
        });
        if (logger.isInfoEnabled() && shardingSphereEnable.equals(false)) {
            logger.info("Judging the existence of all tables for caching, it's will take a few seconds, if you want to disable dtt-mybatis-orm-support, please set 'alphahub.dtt.mybatis-orm-support.is-enable' to 'false'");
        }
        for (String mybatisPropPrefix : MYBATIS_PROP_PREFIX) {
            String property = applicationContext.getEnvironment().getProperty(mybatisPropPrefix);
            if (StringUtils.isBlank(property)) continue;
            String[] typeAliasesPackages = org.apache.commons.lang3.StringUtils.split(property, ",");
            Set<Class<?>> classes = classScanningProvider.scanBasePackage(typeAliasesPackages).stream().filter(aClass -> !aClass.getSimpleName().endsWith(Constants.BUILDER_SUFFIX)).collect(Collectors.toSet());
            if (CollectionUtils.isEmpty(classes)) {
                logger.warn("The entity class is empty, Please check your configuration of mybatis, type-aliases-package: {}", mybatisPropPrefix);
                return;
            }
            ConcurrentMap<String, DttMbActWrapper> classConcurrentMap = classes.parallelStream().collect(Collectors.toConcurrentMap((key -> StringUtils.firstToLowerCase(key.getSimpleName())), (value -> {
                DttMbActWrapper wrapper = new DttMbActWrapper();
                wrapper.setDomainName(StringUtils.firstToLowerCase(value.getSimpleName()));
                wrapper.setDomainClass(value);
                String tableName = StringUtils.camelToUnderline(value.getSimpleName());
                if (shardingSphereEnable.equals(false)) {
                    wrapper.setTableNotExists(isTableNotExists(tableName));
                }
                return wrapper;
            })));
            this.typeAliasesMap.putAll(classConcurrentMap);
        }
    }

    /**
     * is sharding sphere enable?
     *
     * @return if enable return true
     * @see <a href="https://shardingsphere.apache.org/document/5.1.2/cn/user-manual/shardingsphere-jdbc/spring-boot-starter/">ShardingSphere Auto-Configuration</a>
     */
    protected boolean isShardingSphereEnable() {
        boolean isShardingSphereEnable = false;
        try {
            Class<?> shardingSphereDriver = Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
            if (ObjectUtils.isNotEmpty(shardingSphereDriver)) return true;
            Class<?> shardingSphereConnection = Class.forName("org.apache.shardingsphere.driver.jdbc.core.connection.ShardingSphereConnection");
            if (ObjectUtils.isNotEmpty(shardingSphereConnection)) return true;
        } catch (Exception e) {
            // No dump
        }
        for (String shardingSphereBean : SHARDING_SPHERE_BEANS) {
            try {
                if (ObjectUtils.isNotEmpty(applicationContext.getBean(shardingSphereBean)))
                    isShardingSphereEnable = true;
                if (isShardingSphereEnable) break;
            } catch (Exception e) {
                // No dump
            }
        }
        return isShardingSphereEnable;
    }

    /**
     * Whether the table exists in the database
     *
     * @param tableName The name of table
     * @return If table not exists, return true
     */
    public boolean isTableNotExists(String tableName) {
        if (StringUtils.isBlank(tableName)) return false;
        if (null == databaseProperty.getDatabaseType()) return false;
        List<String> sqlScripts = getQueryTableExistsSqlScripts(tableName, databaseProperty.getDatabaseType());
        if (CollectionUtils.isEmpty(sqlScripts)) return false;
        Integer exists = null;
        for (String sql : sqlScripts) {
            try {
                exists = jdbcTemplate.queryForObject(sql, Integer.class);
                if (null != exists && exists > 0) {
                    return false;
                }
            } catch (DataAccessException ignored) {
                //No dump
            }
        }
        return null == exists || exists == 0;
    }


    /**
     * Get the sql script for DTT to use
     *
     * @param tableName    The name of given table, i.e: dtt_member
     * @param databaseType The given database type
     * @return sql scripts
     */
    public List<String> getQueryTableExistsSqlScripts(String tableName, DatabaseType databaseType) {
        Map<DatabaseType, TableExistsSqlMapperProperties> propertiesMap = dttProperties.getTableExistsSqlMapper();
        TableExistsSqlMapperProperties rawSql = propertiesMap.get(databaseType);
        if (null == rawSql) return Collections.emptyList();

        String realTableName = tableName;
        List<String> scripts = new ArrayList<>(4);

        if (rawSql.getTablenameUppercase().equals(true)) realTableName = tableName.toUpperCase();
        String realScript = org.apache.commons.lang3.StringUtils.defaultIfBlank(rawSql.getScriptForTableExists(), "");

        realScript = realScript.replace("${tablename}", realTableName);
        if (realScript.contains("${dbname}")) {
            realScript = realScript.replace("${dbname}", databaseProperty.getDatabaseName());
        }
        scripts.add(realScript);

        return scripts;
    }
}
