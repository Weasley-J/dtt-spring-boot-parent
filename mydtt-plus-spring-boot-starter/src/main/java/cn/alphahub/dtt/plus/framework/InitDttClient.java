package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

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
public class InitDttClient {

    @Autowired
    private ApplicationContext applicationContext;

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
                for (String dbType : DatabaseType.getLowerCaseDbTypes()) {
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
    @SuppressWarnings({"all"})
    @DependsOn({"commentParserClient", "commentParserClient"})
    public ContextWrapper contextWrapper(@Qualifier("commentParserClient") Map<ParserType, DttCommentParser<ModelEntity>> commentParserClient,
                                         @Qualifier("tableHandlerClient") Map<DatabaseType, DttTableHandler<ModelEntity>> tableHandlerClient,
                                         DataSource dataSource) throws SQLException {
        String databaseName = "";
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet result = metaData.getCatalogs();
        String dataURL = metaData.getURL();
        while (result.next()) {
            String databaseNameTemp = result.getString(1);
            if (!Objects.requireNonNull(DatabaseType.getDbType()).name().equalsIgnoreCase(databaseNameTemp)
                    && dataURL.contains(databaseNameTemp)) {
                databaseName = databaseNameTemp;
            }
        }

        return ContextWrapper.builder()
                .databaseName(databaseName)
                .threadReference(new AtomicReference<>(Thread.currentThread()))
                .commentParser(commentParserClient.get(getEnableDtt().parserType()))
                .tableHandler(tableHandlerClient.get(DatabaseType.getDbType()))
                .dttRunDetail(new ContextWrapper.DttRunDetail(LocalDateTime.now()))
                .build();
    }
}
