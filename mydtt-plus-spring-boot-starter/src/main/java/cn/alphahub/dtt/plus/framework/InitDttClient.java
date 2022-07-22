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
import cn.alphahub.dtt.plus.framework.core.DefaultAnnotationParser;
import cn.alphahub.dtt.plus.framework.core.DefaultJavaDocParser;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.DttTableHandler;
import cn.alphahub.dtt.plus.util.ClassUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.StringLengthMapper;
import static cn.alphahub.dtt.plus.config.DttProperties.StringLengthMapper.LengthProperties;
import static cn.alphahub.dtt.plus.framework.InitDttHandler.getEnableDtt;

/**
 * init dtt client
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter({MybatisDataSourceConfigurer.class})
@AutoConfigureBefore({InitDttHandler.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DttProperties.class, DataSourceProperties.class})
public class InitDttClient {
    private static final Logger logger = LoggerFactory.getLogger(InitDttClient.class);
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DatabaseHandler databaseHandler;

    /**
     * @return comment parser client map
     */
    @Bean
    @SuppressWarnings({"all"})
    public Map<ParserType, DttCommentParser<ModelEntity>> commentParserClient() {
        Map<ParserType, DttCommentParser<ModelEntity>> client = new ConcurrentHashMap<>(1);
        Map<String, DttCommentParser> commentParserMap = applicationContext.getBeansOfType(DttCommentParser.class);
        if (CollectionUtils.isNotEmpty(commentParserMap)) {
            if (ParserType.ANNOTATION == getEnableDtt().parserType()) {
                client.put(ParserType.ANNOTATION, commentParserMap.get(DefaultAnnotationParser.class.getName()));
            }
            if (ParserType.JAVA_DOC == getEnableDtt().parserType()) {
                client.put(ParserType.JAVA_DOC, commentParserMap.get(DefaultJavaDocParser.class.getName()));
            }
        }
        return client;
    }

    /**
     * @return table handler map
     */
    @Bean
    @SuppressWarnings({"all"})
    @DependsOn({"commentParserClient"})
    public Map<DatabaseType, DttTableHandler<ModelEntity>> tableHandlerClient() {
        Map<DatabaseType, DttTableHandler<ModelEntity>> client = new ConcurrentHashMap<>(16);
        Map<String, DttTableHandler> tableHandlerMap = applicationContext.getBeansOfType(DttTableHandler.class);
        if (CollectionUtils.isNotEmpty(tableHandlerMap)) {
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
     * @return DTT context wrapper
     */
    @Bean
    @DependsOn({"commentParserClient", "commentParserClient"})
    public ContextWrapper contextWrapper(@Qualifier("commentParserClient") Map<ParserType, DttCommentParser<ModelEntity>> commentParserClient, @Qualifier("tableHandlerClient") Map<DatabaseType, DttTableHandler<ModelEntity>> tableHandlerClient, DttProperties dttProperties) {

        if (dttProperties.getBannerMode() == BannerMode.ON) DttBanner.getInstance().printBanner();

        ContextWrapper wrapper = ContextWrapper.builder()
                .threadReference(new AtomicReference<>(Thread.currentThread()))
                .commentParser(commentParserClient.get(getEnableDtt().parserType()))
                .tableHandler(tableHandlerClient.get(databaseHandler.getDbType()))
                .dttRunDetail(new ContextWrapper.DttRunDetail(LocalDateTime.now()))
                .build();

        List<StringLengthMapper> lengthMappers = dttProperties.getStringLengthMapper();
        if (ObjectUtils.isNotEmpty(lengthMappers)) {
            Map<DatabaseType, StringLengthMapper> mapperMap = lengthMappers.stream().collect(Collectors.toMap(StringLengthMapper::getDatabaseType, v -> v));
            if (ObjectUtils.isNotEmpty(mapperMap)) {
                StringLengthMapper stringLengthMapper = mapperMap.get(databaseHandler.getDbType());
                if (null != stringLengthMapper) {
                    List<LengthProperties> lengthConfigs = stringLengthMapper.getLengthConfigs();
                    if (ObjectUtils.isNotEmpty(lengthConfigs)) {
                        Map<String, Integer> textLengthPropertiesMap = lengthConfigs.stream().collect(Collectors.toMap(LengthProperties::getText, LengthProperties::getLength));
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

        return wrapper;
    }

    /**
     * The property for your database
     *
     * @return DatabaseProperty
     */
    @Bean
    public DatabaseProperty databaseProperty(DataSource dataSource, DataSourceProperties dataSourceProperties) {
        DatabaseProperty property = new DatabaseProperty();
        property.setDatabaseType(databaseHandler.getDbType());
        String databaseName = "";
        try {
            if (databaseHandler.getDbType() == DatabaseType.ORACLE)
                databaseName = dataSourceProperties.getUsername();
            @SuppressWarnings({"all"}) DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            property.setDatabaseVersion(metaData.getDatabaseProductVersion());
            property.setIntDatabaseVersion(metaData.getDatabaseMajorVersion());
            ResultSet result = metaData.getCatalogs();
            String dataURL = metaData.getURL();
            while (result.next()) {
                String databaseNameTemp = result.getString(1);
                if (!Objects.requireNonNull(databaseHandler.getDbType()).name().equalsIgnoreCase(databaseNameTemp) && dataURL.contains(databaseNameTemp)) {
                    databaseName = databaseNameTemp;
                    break;
                }
            }
        } catch (SQLException e) {
            logger.error("{}", e.getLocalizedMessage(), e);
        }
        property.setDatabaseName(databaseName);
        return property;
    }
}
