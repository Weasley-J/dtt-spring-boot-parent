package cn.alphahub.dtt.plus.framework.interceptor;

import cn.alphahub.dtt.plus.config.DttMybatisAutoConfiguration;
import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.DttMbActWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.framework.core.parser.DefaultAnnotationParser;
import cn.alphahub.dtt.plus.util.StringUtils;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
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
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static cn.alphahub.dtt.plus.config.DttProperties.DttMybatisOrmSupportProperties;

/**
 * The default DTT interceptor for mybatis
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
    private final DttProperties dttProperties;
    private final ApplicationContext applicationContext;
    private final DttMybatisOrmSupportProperties dttMybatisOrmSupportProperties;

    public DefaultDttMybatisInterceptor(DttProperties dttProperties,
                                        ApplicationContext applicationContext,
                                        DttMybatisOrmSupportProperties dttMybatisOrmSupportProperties) {
        this.dttProperties = dttProperties;
        this.applicationContext = applicationContext;
        this.dttMybatisOrmSupportProperties = dttMybatisOrmSupportProperties;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        Executor executor = target instanceof Executor ? ((Executor) target) : null;
        StatementHandler statementHandler = target instanceof StatementHandler ? ((StatementHandler) target) : null;
        if (null != executor) {
            //No dump
        }
        if (null != statementHandler && dttMybatisOrmSupportProperties.getIsEnable()) {
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

        if (ObjectUtils.isEmpty(contextWrapper)) return;

        // if APP run with type of Jar environment dtt Comment Parser takes Default Annotation Parser
        if (ResourceUtils.isJarURL(location))
            dttCommentParser = applicationContext.getBean(DefaultAnnotationParser.class);
        else dttCommentParser = contextWrapper.getCommentParser();

        DttMybatisAutoConfiguration dttMybatisAutoConfiguration = applicationContext.getBean(DttMybatisAutoConfiguration.class);
        Map<String, DttMbActWrapper> typeAliasesMap = dttMybatisAutoConfiguration.getTypeAliasesMap();
        if (ObjectUtils.isEmpty(typeAliasesMap)) return;

        boolean shardingSphereEnable = dttMybatisAutoConfiguration.getShardingSphereEnable();

        if (shardingSphereEnable) {
            // TODO: compatibility with sharding-sphere, May be compatible later
            return;
        }

        handleCrateTable(tableNames, contextWrapper, typeAliasesMap, dttCommentParser);
    }

    /**
     * Handle crate table by default
     *
     * @param tableNames       table names
     * @param contextWrapper   contextWrapper
     * @param typeAliasesMap   The cache for mybatis type-aliases mapped classes，key:The simple name of class(Lower case, small camel case), value: The wrapper class
     * @param dttCommentParser dttCommentParser
     */
    private void handleCrateTable(List<String> tableNames, ContextWrapper contextWrapper, Map<String, DttMbActWrapper> typeAliasesMap, DttCommentParser<ModelEntity> dttCommentParser) {
        for (String tableName : tableNames) {
            String classCamelName = StringUtils.underlineToCamel(tableName);
            if (!typeAliasesMap.containsKey(classCamelName)) return;
            DttMbActWrapper actWrapper = typeAliasesMap.get(classCamelName);
            if (actWrapper.getTableNotExists().equals(true)) {
                logger.info("Table of '{}' not exists, DTT will help you to create it automatically.", tableName);
                ParseFactory<ModelEntity> parseFactory = dttCommentParser.parse(actWrapper.getDomainClass().getName());
                if (null == parseFactory.getModel() || CollectionUtils.isEmpty(parseFactory.getModel().getDetails())) {
                    return;
                }
                contextWrapper.getTableHandler().create(parseFactory);
                //Set table does not exist to false after creation.
                actWrapper.setTableNotExists(false);
            }
        }
    }
}
