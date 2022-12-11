package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.config.support.MybatisDataSourceConfigurer;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.DatabaseProperty;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.BannerMode;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.DttTableHandler;
import cn.alphahub.dtt.plus.framework.core.parser.DefaultAnnotationParser;
import cn.alphahub.dtt.plus.framework.core.parser.DefaultJavadocParser;
import cn.alphahub.dtt.plus.util.ClassUtil;
import cn.alphahub.dtt.plus.util.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper.PrecisionConfigurationProperties;
import static cn.alphahub.dtt.plus.entity.ContextWrapper.HighPrecisionDataHandler;
import static cn.alphahub.dtt.plus.framework.InitDttHandler.getEnableDtt;

/**
 * init dtt client
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore({InitDttHandler.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
@AutoConfigureAfter({MybatisDataSourceConfigurer.class})
@EnableConfigurationProperties({DttProperties.class, DataSourceProperties.class})
public class InitDttClient {
    private static final Logger logger = LoggerFactory.getLogger(InitDttClient.class);

    /**
     * @return comment parser client map
     */
    @SuppressWarnings({"all"})
    @Bean
    public Map<ParserType, DttCommentParser<ModelEntity>> commentParserClient(ApplicationContext applicationContext) {
        Map<ParserType, DttCommentParser<ModelEntity>> client = new ConcurrentHashMap<>(1);
        Map<String, DttCommentParser> commentParserMap = applicationContext.getBeansOfType(DttCommentParser.class);
        if (ObjectUtils.isNotEmpty(commentParserMap)) {
            if (ParserType.ANNOTATION == getEnableDtt().parserType()) {
                client.put(ParserType.ANNOTATION, commentParserMap.get(DefaultAnnotationParser.class.getName()));
            }
            if (ParserType.JAVA_DOC == getEnableDtt().parserType()) {
                client.put(ParserType.JAVA_DOC, commentParserMap.get(DefaultJavadocParser.class.getName()));
            }
        }
        return client;
    }

    /**
     * @return table handler map
     */
    @SuppressWarnings({"all"})
    @Bean
    @DependsOn({"commentParserClient"})
    public Map<DatabaseType, DttTableHandler<ModelEntity>> tableHandlerClient(ApplicationContext applicationContext, DatabaseHandler databaseHandler) {
        Map<DatabaseType, DttTableHandler<ModelEntity>> client = new ConcurrentHashMap<>(16);
        Map<String, DttTableHandler> tableHandlerMap = applicationContext.getBeansOfType(DttTableHandler.class);
        if (ObjectUtils.isNotEmpty(tableHandlerMap)) {
            tableHandlerMap.forEach((key, value) -> {
                String classNameUnderline = StringUtils.camelToUnderline(ClassUtil.loadClass(key).getSimpleName());
                for (String dbType : databaseHandler.getLowerCaseDbTypes()) {
                    if (classNameUnderline.contains(dbType)) {
                        client.put(DatabaseType.valueOf(dbType.toUpperCase()), value);
                    }
                }
            });
        }
        return client;
    }

    /**
     * Get ContextWrapper
     *
     * @param commentParserClient commentParserClient
     * @param tableHandlerClient  tableHandlerClient
     * @param dttProperties       dttProperties
     * @return DTT context wrapper
     */
    @Bean
    @DependsOn({"commentParserClient", "commentParserClient"})
    public ContextWrapper contextWrapper(@Qualifier("commentParserClient") Map<ParserType, DttCommentParser<ModelEntity>> commentParserClient,
                                         @Qualifier("tableHandlerClient") Map<DatabaseType, DttTableHandler<ModelEntity>> tableHandlerClient,
                                         DttProperties dttProperties,
                                         DatabaseHandler databaseHandler
    ) {

        if (dttProperties.getBannerMode() == BannerMode.ON) DttBanner.getInstance().printBanner();

        ContextWrapper wrapper = ContextWrapper.builder()
                .threadReference(new AtomicReference<>(Thread.currentThread()))
                .dttProperties(dttProperties)
                .databaseHandler(databaseHandler)
                .commentParser(commentParserClient.get(getEnableDtt().parserType()))
                .tableHandler(tableHandlerClient.get(databaseHandler.getDbType()))
                .dttRunDetail(new ContextWrapper.DttRunDetail(LocalDateTime.now()))
                .build();

        // parse string length mapper
        parseStringLengthMapper(dttProperties, databaseHandler, wrapper);

        // Parse high precision data handler
        parseHighPrecisionDataHandler(wrapper, dttProperties);

        return wrapper;
    }

    /**
     * The property for your database
     *
     * @param dataSource           dataSource
     * @param dataSourceProperties dataSourceProperties
     * @return DatabaseProperty
     */
    @Bean
    public DatabaseProperty databaseProperty(DataSource dataSource,
                                             JdbcTemplate jdbcTemplate,
                                             DatabaseHandler databaseHandler,
                                             DataSourceProperties dataSourceProperties
    ) {
        DatabaseProperty property = new DatabaseProperty();
        property.setDatabaseType(databaseHandler.getDbType());
        String databaseName = "";
        if (databaseHandler.getDbType() == DatabaseType.ORACLE) databaseName = dataSourceProperties.getUsername();
        if (databaseHandler.getDbType() == DatabaseType.DB2) {
            try {
                databaseName = jdbcTemplate.queryForObject("SELECT CURRENT SERVER FROM SYSIBM.SYSDUMMY1", String.class);
                if (StringUtils.isBlank(databaseName) || "NULL".equals(databaseName) || "null".equals(databaseName)) {
                    databaseName = "";
                }
            } catch (DataAccessException e) {
                logger.warn("{}", e.getLocalizedMessage(), e);
            }
        }
        try {
            @SuppressWarnings({"all"}) DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            ResultSet result = metaData.getCatalogs();
            String dataURL = metaData.getURL();
            property.setDatabaseVersion(metaData.getDatabaseProductVersion());
            property.setIntDatabaseVersion(metaData.getDatabaseMajorVersion());
            String currentCatalogName = metaData.getConnection().getCatalog();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(currentCatalogName)
                    && !databaseHandler.getDbType().name().equalsIgnoreCase(currentCatalogName)
                    && dataURL.contains(currentCatalogName)) {
                databaseName = currentCatalogName;
            } else {
                while (result.next()) {
                    String databaseNameTemp = result.getString(1);
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(databaseNameTemp)
                            && !databaseHandler.getDbType().name().equalsIgnoreCase(databaseNameTemp)
                            && dataURL.contains(databaseNameTemp)) {
                        databaseName = databaseNameTemp;
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("{}", e.getLocalizedMessage(), e);
        }
        property.setDatabaseName(databaseName);
        return property;
    }


    /**
     * Parse the high precision data handler
     *
     * @param wrapper         The wrapper of DTT context
     * @param dttProperties   The properties of DTT
     * @param databaseHandler The handler of DTT supported database
     */
    protected void parseStringLengthMapper(DttProperties dttProperties, DatabaseHandler databaseHandler, ContextWrapper wrapper) {
        List<DttProperties.StringLengthMapper> lengthMappers = dttProperties.getStringLengthMapper();
        if (ObjectUtils.isNotEmpty(lengthMappers)) {
            Map<DatabaseType, DttProperties.StringLengthMapper> mapperMap = lengthMappers.stream().collect(Collectors.toMap(DttProperties.StringLengthMapper::getDatabaseType, v -> v));
            if (ObjectUtils.isNotEmpty(mapperMap)) {
                DttProperties.StringLengthMapper stringLengthMapper = mapperMap.get(databaseHandler.getDbType());
                if (ObjectUtils.allNotNull(stringLengthMapper)) {
                    List<DttProperties.StringLengthMapper.LengthProperties> lengthConfigs = stringLengthMapper.getLengthConfigs();
                    if (ObjectUtils.isNotEmpty(lengthConfigs)) {
                        Map<String, Integer> textLengthPropertiesMap = lengthConfigs.stream().collect(Collectors.toMap(DttProperties.StringLengthMapper.LengthProperties::getText, DttProperties.StringLengthMapper.LengthProperties::getLength));
                        if (ObjectUtils.isNotEmpty(textLengthPropertiesMap)) {
                            // Get the length of the 'String' type configured by the user
                            ContextWrapper.TextLengthHandler handler = new ContextWrapper.TextLengthHandler();
                            handler.setStringLengthMapper(stringLengthMapper);
                            handler.setTextLengthProperties(textLengthPropertiesMap);
                            wrapper.setTextLengthHandler(handler);
                        }
                    }
                }
            }
        }
    }

    /**
     * Parse the high precision data handler
     *
     * @param contextWrapper The wrapper of DTT context
     * @param dttProperties  The properties of DTT
     */
    protected void parseHighPrecisionDataHandler(ContextWrapper contextWrapper, DttProperties dttProperties) {
        Map<String, PrecisionConfigurationProperties> highPrecisionDataConfigMap = new ConcurrentHashMap<>(256);
        List<PrecisionConfigurationProperties> precisionConfigs = dttProperties.getHighPrecisionDataMapper().getPrecisionConfigs();
        if (CollectionUtils.isNotEmpty(precisionConfigs)) {
            precisionConfigs.forEach(properties -> {
                String[] textArray = properties.getText().split(",");
                if (ObjectUtils.isNotEmpty(textArray)) {
                    for (String text : textArray) {
                        highPrecisionDataConfigMap.put(text, properties);
                    }
                }
            });
        }
        HighPrecisionDataHandler dataHandler = new HighPrecisionDataHandler();
        dataHandler.setHighPrecisionDataConfigMap(highPrecisionDataConfigMap);
        dataHandler.setHighPrecisionDataMapper(dttProperties.getHighPrecisionDataMapper());
        contextWrapper.setHighPrecisionDataHandler(dataHandler);
    }
}
