package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DbType;
import cn.alphahub.dtt.plus.enums.ParseType;
import cn.alphahub.dtt.plus.framework.core.CommentParser;
import cn.alphahub.dtt.plus.framework.core.ParsedModel;
import cn.alphahub.dtt.plus.framework.core.TableHandler;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.alphahub.dtt.plus.util.PackageUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.DataTypeMappingProperties;

/**
 * 初始表处理
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Data
@Component
@AutoConfigureAfter({InitDttClient.class})
@ConfigurationPropertiesScan({"cn.alphahub.table.plus.config"})
@EnableConfigurationProperties({DttProperties.class, DataTypeMappingProperties.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
public class InitDttHandler implements ApplicationRunner {
    /**
     * 域模型集合
     */
    private static final Set<ParsedModel<ModelEntity>> MODEL_ENTITIES = new LinkedHashSet<>(512);
    private static final Logger logger = LoggerFactory.getLogger(InitDttHandler.class);
    @Autowired
    private DttProperties.DataTypeMappingProperties dataTypeMapping;
    @Autowired
    private Map<DbType, TableHandler<ModelEntity>> tableHandlerClient;
    @Autowired
    private Map<ParseType, CommentParser<ModelEntity>> commentParserClient;

    /**
     * 获取{@code  @EnableDtt}注解
     *
     * @return {@code  @EnableDtt}注解
     */
    public static EnableDtt enableDttHandler() {
        Map<String, Object> beans = SpringUtil.getApplicationContext().getBeansWithAnnotation(SpringBootApplication.class);
        List<EnableDtt> enableDttAnnoSet = new LinkedList<>();
        if (!org.springframework.util.CollectionUtils.isEmpty(beans)) {
            beans.forEach((key, value) -> {
                EnableDtt annotation = value.getClass().getAnnotation(EnableDtt.class);
                if (null != annotation) {
                    enableDttAnnoSet.add(annotation);
                }
            });
        }
        return new ArrayList<>(enableDttAnnoSet).get(0);
    }

    /**
     * javaDataType to databaseDataType
     *
     * @param javaDataType java data type
     * @return database data type
     * @apiNote BigDecimal to decimal, So on.
     */
    public String getDatabaseDataType(String javaDataType) {
        Properties props = dataTypeMapping.getPropsByDbType(DbType.getDbType());
        Object value = props.get(javaDataType);
        if (null == value) {
            Properties lowerCaseProps = dataTypeMapping.getPropsByDbTypeJavaTypeIsLowerCase(DbType.getDbType());
            value = lowerCaseProps.get(javaDataType);
            if (null == value && logger.isErrorEnabled()) {
                logger.error("Java数据类型映射至数据库数据类型出错，数据类型映射类型: {}, javaDataType = {}", JacksonUtil.toJson(props), javaDataType);
            }
        }
        return Objects.nonNull(value) ? value.toString() : "";
    }

    @Override
    public void run(ApplicationArguments args) {
        // 1 解析注解内的class对象
        resolveAnnotationsClass(enableDttHandler());
        // 2 获取数据库具体实现
        TableHandler<ModelEntity> tableHandler = tableHandlerClient.get(DbType.getDbType());
        // 3 批量操作执行DDL
        tableHandler.bulkOps(MODEL_ENTITIES);
    }

    /**
     * 解析注解, 解析模型数据
     *
     * @param dttHandler 启动自动创建数据库表注解
     */
    public void resolveAnnotationsClass(EnableDtt dttHandler) {
        // 解析注释, 自动推断实现
        CommentParser<ModelEntity> commentParser = commentParserClient.get(dttHandler.parseType());

        Consumer<Class<?>> classConsumer = aClass -> MODEL_ENTITIES.add(commentParser.parse(aClass.getName()));

        if (null != dttHandler.scanBasePackages() && dttHandler.scanBasePackages().length > 0) {
            Arrays.stream(dttHandler.scanBasePackages()).filter(StringUtils::isNotBlank).forEach(basePackage -> {
                //Filter out class objects in builder mode
                Set<Class<?>> classes = PackageUtil.scanPackage(basePackage).stream().filter(aClass -> !aClass.getSimpleName().endsWith(Constants.BUILDER_SUFFIX)).collect(Collectors.toSet());
                classes.forEach(classConsumer);
            });
        }

        if (null != dttHandler.scanBaseClasses() && dttHandler.scanBaseClasses().length > 0) {
            Set<Class<?>> classes = Arrays.stream(dttHandler.scanBaseClasses()).filter(aClass -> !aClass.getSimpleName().endsWith(Constants.BUILDER_SUFFIX)).collect(Collectors.toSet());
            classes.forEach(classConsumer);
        }
    }
}
