package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DbType;
import cn.alphahub.dtt.plus.enums.ParseType;
import cn.alphahub.dtt.plus.framework.core.CommentParser;
import cn.alphahub.dtt.plus.framework.core.DefaultAnnotationParser;
import cn.alphahub.dtt.plus.framework.core.DefaultJavaDocParser;
import cn.alphahub.dtt.plus.framework.core.TableHandler;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    /**
     * @return comment parser client map
     */
    @Bean
    @SuppressWarnings({"all"})
    public Map<ParseType, CommentParser<ModelEntity>> commentParserClient() {
        Map<ParseType, CommentParser<ModelEntity>> client = new ConcurrentHashMap<>(1);
        Map<String, CommentParser> commentParserMap = SpringUtil.getApplicationContext().getBeansOfType(CommentParser.class);
        if (CollectionUtils.isNotEmpty(commentParserMap)) {
            if (ParseType.ANNO_TYPE == InitDttHandler.enableDttHandler().parseType()) {
                client.put(ParseType.ANNO_TYPE, commentParserMap.get(DefaultAnnotationParser.class.getName()));
            }
            if (ParseType.JAVA_DOC == InitDttHandler.enableDttHandler().parseType()) {
                client.put(ParseType.JAVA_DOC, commentParserMap.get(DefaultJavaDocParser.class.getName()));
            }
        }
        return client;
    }

    /**
     * @return table handler map
     */
    @Bean
    @DependsOn({"commentParserClient"})
    @SuppressWarnings({"all"})
    public Map<DbType, TableHandler<ModelEntity>> tableHandlerClient() {
        Map<DbType, TableHandler<ModelEntity>> client = new ConcurrentHashMap<>(16);
        Map<String, TableHandler> tableHandlerMap = SpringUtil.getApplicationContext().getBeansOfType(TableHandler.class);
        if (CollectionUtils.isNotEmpty(tableHandlerMap)) {
            tableHandlerMap.forEach((key, value) -> {
                String classNameUnderline = StringUtils.camelToUnderline(ClassUtil.loadClass(key).getSimpleName());
                for (String dbType : DbType.getLowerCaseDbTypes()) {
                    if (classNameUnderline.contains(dbType)) {
                        client.put(DbType.valueOf(dbType.toUpperCase()), value);
                    }
                }
            });
        }
        return client;
    }

}
