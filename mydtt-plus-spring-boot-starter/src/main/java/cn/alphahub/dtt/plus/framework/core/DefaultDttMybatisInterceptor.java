package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.net.URL;
import java.sql.Connection;
import java.util.List;

import static cn.alphahub.dtt.plus.config.DttMybatisInterceptorConfigurer.TYPE_ALIASES_MAP;

/**
 * The default interceptor of mybatis-pro
 *
 * @author weasley
 * @version 1.2.6
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@Intercepts(value = {
        @Signature(type = StatementHandler.class, method = "getBoundSql", args = {}),
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
})
public class DefaultDttMybatisInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDttMybatisInterceptor.class);
    private final JdbcTemplate jdbcTemplate;

    private final ApplicationContext applicationContext;

    public DefaultDttMybatisInterceptor(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        this.jdbcTemplate = jdbcTemplate;
        this.applicationContext = applicationContext;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        Executor executor = target instanceof Executor ? ((Executor) target) : null;
        StatementHandler statementHandler = target instanceof StatementHandler ? ((StatementHandler) target) : null;
        if (null != executor) {
            // No dump
        }
        if (null != statementHandler) {
            BoundSql boundSql = statementHandler.getBoundSql();
            Statement parse = CCJSqlParserUtil.parse(boundSql.getSql());
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tableNames = tablesNamesFinder.getTableList(parse);
            createTableIfNotExists(tableNames);
        }
        return invocation.proceed();
    }

    /**
     * Create the table if it doesn't exist
     *
     * @param tableNames The table names
     */
    private void createTableIfNotExists(List<String> tableNames) {
        if (CollectionUtils.isEmpty(tableNames)) return;

        DttCommentParser<ModelEntity> dttCommentParser;
        URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        ContextWrapper contextWrapper = applicationContext.getBean(ContextWrapper.class);

        if (ObjectUtils.isNull(contextWrapper)) return;

        // if APP run with type of Jar environment dtt Comment Parser takes Default Annotation Parser
        if (ResourceUtils.isJarURL(location))
            dttCommentParser = applicationContext.getBean(DefaultAnnotationParser.class);
        else
            dttCommentParser = contextWrapper.getCommentParser();

        for (String tableName : tableNames) {
            if (isTableNotExists(tableName) && !CollectionUtils.isEmpty(TYPE_ALIASES_MAP)) {
                logger.info("Table of '{}' doesn't exists, DTT will be created automatically", tableName);
                String classCamelName = StringUtils.underlineToCamel(tableName);
                if (!TYPE_ALIASES_MAP.containsKey(classCamelName)) return;
                ParseFactory<ModelEntity> parseFactory = dttCommentParser.parse(TYPE_ALIASES_MAP.get(classCamelName).getName());
                if (null == parseFactory.getModel() || CollectionUtils.isEmpty(parseFactory.getModel().getDetails()))
                    return;
                contextWrapper.getTableHandler().create(parseFactory);
            }
        }

    }

    /**
     * Whether the table exists in the database
     *
     * @param tableName The name of table
     * @return If table not exists, return true
     */
    public boolean isTableNotExists(String tableName) {
        if (StringUtils.isBlank(tableName)) return false;
        DatabaseProperty databaseProperty = SpringUtil.getBean(DatabaseProperty.class);
        String sql = "";
        switch (databaseProperty.getDatabaseType()) {
            case MYSQL:
            case MARIADB:
                sql = "SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_NAME = '" + tableName + "'";
                break;
            case ORACLE:
                if (!StringUtils.isCapitalMode(tableName)) {
                    // TODO Whether the table Name is converted to uppercase
                }
                sql = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + tableName + "'";
                break;
            case DB2:
                if (!StringUtils.isCapitalMode(tableName)) {
                    tableName = tableName.toUpperCase();
                }
                sql = "SELECT COUNT(*) FROM syscat.tables WHERE TABSCHEMA = 'TESTDB' AND TABNAME = '" + tableName + "'";
                break;
            case SQLSERVER:
                sql = "SELECT COUNT(*) FROM sys.all_objects WHERE object_id = OBJECT_ID( N'[dbo].[" + tableName + "]' ) AND type IN ( 'U' )";
                break;
            case POSTGRESQL:
                sql = "SELECT COUNT(*) FROM pg_class WHERE relname = '" + tableName + "'";
                break;
            default:
                break;
        }
        if (StringUtils.isBlank(sql)) return false;
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        if (null == integer) return true;
        return integer == 0;
    }
}
