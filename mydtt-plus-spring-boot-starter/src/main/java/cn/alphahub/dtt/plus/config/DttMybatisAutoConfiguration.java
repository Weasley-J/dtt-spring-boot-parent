package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.DttMbActWrapper;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.interceptor.DefaultDttMybatisInterceptor;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Lazy;
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
@AutoConfigureAfter(name = {"mybatisAutoConfiguration", "mybatisPlusAutoConfiguration"})
public class DttMybatisAutoConfiguration implements InitializingBean {
    private static final String[] MYBATIS_PROP_PREFIX = {"mybatis-plus.type-aliases-package", "mybatis.type-aliases-package"};
    private static final String[] shardingSphereBeans = {"shardingSphereAutoConfiguration", "org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration"};
    /**
     * The type aliases map of mybatis
     * <p>
     * key:The simple name of class(Lower case, small camel case), value: The class
     */
    private final Map<String, DttMbActWrapper> typeAliasesMap = new ConcurrentHashMap<>(768);
    private final DttProperties dttProperties;
    private final JdbcTemplate jdbcTemplate;
    private final DatabaseProperty databaseProperty;
    private final ClassScanningProvider classScanningProvider;
    /**
     * The list of 'SqlSessionFactory'
     */
    private final List<SqlSessionFactory> sqlSessionFactories;
    /**
     * The default interceptor of mybatis-pro
     */
    private final DefaultDttMybatisInterceptor defaultDttMybatisInterceptor;

    public DttMybatisAutoConfiguration(DttProperties dttProperties,
                                       JdbcTemplate jdbcTemplate,
                                       DatabaseProperty databaseProperty,
                                       ClassScanningProvider classScanningProvider,
                                       List<SqlSessionFactory> sqlSessionFactories,
                                       DefaultDttMybatisInterceptor defaultDttMybatisInterceptor) {
        this.dttProperties = dttProperties;
        this.jdbcTemplate = jdbcTemplate;
        this.databaseProperty = databaseProperty;
        this.sqlSessionFactories = sqlSessionFactories;
        this.classScanningProvider = classScanningProvider;
        this.defaultDttMybatisInterceptor = defaultDttMybatisInterceptor;
    }

    @Override
    public void afterPropertiesSet() {
        sqlSessionFactories.forEach(sqlSessionFactory -> {
            Configuration configuration = sqlSessionFactory.getConfiguration();
            if (ObjectUtils.isNotEmpty(configuration) && !configuration.getInterceptors().contains(defaultDttMybatisInterceptor)) {
                configuration.addInterceptor(defaultDttMybatisInterceptor);
            }
        });
        for (String mybatisPropPrefix : MYBATIS_PROP_PREFIX) {
            String property = SpringUtil.getProperty(mybatisPropPrefix);
            if (StringUtils.isNoneBlank(property)) {
                String[] typeAliasesPackages = StringUtils.split(property, ",");
                if (ObjectUtils.isNotEmpty(typeAliasesPackages)) {
                    Set<Class<?>> classes = classScanningProvider.scanBasePackage(typeAliasesPackages).stream().filter(aClass -> !aClass.getSimpleName().endsWith(Constants.BUILDER_SUFFIX)).collect(Collectors.toSet());
                    if (CollectionUtils.isNotEmpty(classes)) {
                        ConcurrentMap<String, DttMbActWrapper> classConcurrentMap = classes.stream().collect(Collectors.toConcurrentMap((key -> com.baomidou.mybatisplus.core.toolkit.StringUtils.firstToLowerCase(key.getSimpleName())), (value -> {
                            DttMbActWrapper actWrapper = new DttMbActWrapper();
                            actWrapper.setDomainName(com.baomidou.mybatisplus.core.toolkit.StringUtils.firstToLowerCase(value.getSimpleName()));
                            actWrapper.setDomainClass(value);
                            String tableName = com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(value.getSimpleName());
                            actWrapper.setTableNotExists(isTableNotExists(tableName));
                            return actWrapper;
                        })));
                        this.typeAliasesMap.putAll(classConcurrentMap);
                    }
                }
            }
        }
    }

    /**
     * is sharding sphere enable?
     *
     * @return if enable return true
     * @see <a href="https://shardingsphere.apache.org/document/5.1.2/cn/user-manual/shardingsphere-jdbc/spring-boot-starter/">ShardingSphere Auto-Configuration</a>
     */
    public boolean isShardingSphereEnable() {
        boolean isShardingSphereEnable = false;
        for (String shardingSphereBean : shardingSphereBeans) {
            try {
                if (com.baomidou.mybatisplus.core.toolkit.ObjectUtils.isNotNull(SpringUtil.getBean(shardingSphereBean))) {
                    isShardingSphereEnable = true;
                    break;
                }
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
        if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(tableName)) return false;
        if (null == databaseProperty.getDatabaseType()) {
            // Do nothing, Unsupported database type
            return false;
        }
        if (isShardingSphereEnable()) {
            // TODO: compatibility with sharding-sphere, May be compatible later
            return false;
        }
        List<String> sqlList = getQueryTableExistsSqlList(tableName, databaseProperty.getDatabaseType());
        if (CollectionUtils.isEmpty(sqlList)) return false;
        Integer exists = null;
        for (String sql : sqlList) {
            exists = jdbcTemplate.queryForObject(sql, Integer.class);
            if (null != exists && exists > 0) {
                return false;
            }
        }
        return null == exists || exists == 0;
    }


    /**
     * Get the sql script for DTT to use
     *
     * @param tableName    The name of given table, i.e: dtt_member
     * @param databaseType The given database type
     * @return SQL entity
     */
    public List<String> getQueryTableExistsSqlList(String tableName, DatabaseType databaseType) {
        List<String> sqlList = new ArrayList<>(4);
        Map<DatabaseType, TableExistsSqlMapperProperties> propertiesMap = dttProperties.getTableExistsSqlMapper();
        TableExistsSqlMapperProperties rawSql = propertiesMap.get(databaseType);
        if (null == rawSql) return Collections.emptyList();
        String dbNamePlaceHolder = "${databaseName}";
        switch (databaseType) {
            case MYSQL:
            case MARIADB:
            case SQLSERVER:
            case POSTGRESQL:
                String sql = rawSql.getLowerCaseTableName().replace("${lowerCaseTableName}", tableName);
                if (sql.contains(dbNamePlaceHolder))
                    sql = sql.replace(dbNamePlaceHolder, databaseProperty.getDatabaseName());
                sqlList.add(sql);
                return sqlList;
            case H2:
            case DB2:
            case ORACLE:
                String lowerCaseTableNameSql = rawSql.getLowerCaseTableName().replace("${lowerCaseTableName}", tableName);
                String upperCaseTableNameSql = rawSql.getUpperCaseTableName().replace("${upperCaseTableName}", tableName.toUpperCase());
                if (lowerCaseTableNameSql.contains(dbNamePlaceHolder))
                    lowerCaseTableNameSql = lowerCaseTableNameSql.replace(dbNamePlaceHolder, databaseProperty.getDatabaseName());
                sqlList.add(lowerCaseTableNameSql);

                if (upperCaseTableNameSql.contains(dbNamePlaceHolder))
                    upperCaseTableNameSql = upperCaseTableNameSql.replace(dbNamePlaceHolder, databaseProperty.getDatabaseName());
                sqlList.add(upperCaseTableNameSql);

                return sqlList;
            case HSQL:
            case DERBY:
            default:
                return sqlList;
        }
    }
}
