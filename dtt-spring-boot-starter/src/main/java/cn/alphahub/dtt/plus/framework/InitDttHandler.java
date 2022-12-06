package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.exception.ParseException;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.alphahub.dtt.plus.util.SpringUtil;
import cn.alphahub.dtt.plus.util.SystemUtil;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.AllInOneTableProperties;
import static cn.alphahub.dtt.plus.config.DttProperties.DataTypeMapperProperties;
import static cn.alphahub.dtt.plus.config.DttProperties.StringLengthMapper.LengthProperties;
import static cn.alphahub.dtt.plus.constant.Constants.BUILDER_SUFFIX;

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
@ConditionalOnBean(annotation = {EnableDtt.class})
@ConfigurationPropertiesScan({"cn.alphahub.dtt.plus.config"})
@EnableConfigurationProperties({DttProperties.class, DataTypeMapperProperties.class, AllInOneTableProperties.class, LengthProperties.class,})
public class InitDttHandler implements ApplicationRunner {
    /**
     * 域模型集合, 默认大小：512
     */
    private static final Set<ParseFactory<ModelEntity>> FACTORIES = new LinkedHashSet<>(512);
    private static final Logger logger = LoggerFactory.getLogger(InitDttHandler.class);

    @Autowired
    private DttProperties dttProperties;
    @Autowired
    private ContextWrapper contextWrapper;
    @Autowired
    private ClassScanningProvider classScanningProvider;
    @Autowired
    private AllInOneTableProperties allInOneProperties;

    /**
     * 获取{@code  @EnableDtt}注解
     *
     * @return {@code  @EnableDtt}注解
     */
    public static EnableDtt getEnableDtt() {
        Map<String, Object> beansWithAnnotation = SpringUtil.getApplicationContext().getBeansWithAnnotation(EnableDtt.class);
        if (!CollectionUtils.isEmpty(beansWithAnnotation)) {
            for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
                EnableDtt annotation = entry.getValue().getClass().getAnnotation(EnableDtt.class);
                if (null != annotation) {
                    return annotation;
                }
            }
        }
        throw new ParseException("No beans annotated by @EnableDtt annotation, Check your configuration please.");
    }

    /**
     * 解析注解, 解析模型数据
     *
     * @param dtt 启动自动创建数据库表注解
     */
    public void resolveAnnotationsClass(EnableDtt dtt) {
        // 解析注释, 自动推断实现
        DttCommentParser<ModelEntity> commentParser = contextWrapper.getCommentParser();

        Consumer<Class<?>> classConsumer = aClass -> FACTORIES.add(commentParser.parse(aClass.getName()));

        if (ObjectUtils.isNotEmpty(dtt.scanBasePackages())) {
            Set<Class<?>> fullyClasses = classScanningProvider.scanBasePackage(dtt.scanBasePackages());
            //Filter out class objects in builder mode
            Set<Class<?>> purelyClasses = fullyClasses.stream().filter(aClass -> !aClass.getSimpleName().endsWith(BUILDER_SUFFIX)).collect(Collectors.toSet());
            purelyClasses.forEach(classConsumer);
        }

        if (ObjectUtils.isNotEmpty(dtt.scanBaseClasses())) {
            Set<Class<?>> classes = Arrays.stream(dtt.scanBaseClasses()).filter(aClass -> !aClass.getSimpleName().endsWith(BUILDER_SUFFIX)).collect(Collectors.toSet());
            classes.forEach(classConsumer);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        boolean warnEnabled = logger.isWarnEnabled();
        boolean infoEnabled = logger.isInfoEnabled();
        if (dttProperties.getIsEnable().equals(false)) {
            if (warnEnabled)
                logger.warn("Dtt has disabled，Please check the configuration property of 'alphahub.dtt.is-enable' in your yaml file.");
            return;
        }

        URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        if (ResourceUtils.isJarURL(location) && getEnableDtt().parserType() == ParserType.JAVA_DOC) {
            if (warnEnabled)
                logger.warn("Your application run with type of '{}', ParserType Of JAVA_DOC not support, Please check your @EnableDtt annotation's configurations.", location);
            return;
        }

        //There is no dependency of 'com.github.therapi:therapi-runtime-javadoc-scribe' in classpath to parse the description of model
        if (getEnableDtt().parserType() == ParserType.JAVA_DOC && !SystemUtil.getJarPath().contains("therapi-runtime-javadoc-scribe"))
            logger.warn("Current model parser type is: {}, there is no dependency of 'com.github.therapi:therapi-runtime-javadoc-scribe' in your classpath, please add this dependency in the project to parse the description of your model.", getEnableDtt().parserType());

        resolveAnnotationsClass(getEnableDtt());

        if (CollectionUtils.isEmpty(FACTORIES)) {
            if (warnEnabled) logger.warn("Data model is empty. DTT cannot parse.");
            return;
        }

        String tables = contextWrapper.getTableHandler().bulkOps(FACTORIES);
        if (allInOneProperties.getEnable().equals(true)) {
            File file = new File(allInOneProperties.getAbsoluteFilename());
            if (!file.getParentFile().exists()) FileUtils.forceMkdirParent(file);
            try (FileOutputStream fos = new FileOutputStream(allInOneProperties.getAbsoluteFilename(), false)) {
                fos.write(tables.getBytes());
            }
        }

        if (infoEnabled) {
            contextWrapper.getDttRunDetail().setDttEndTime(LocalDateTime.now());
            if (allInOneProperties.getEnable().equals(true))
                logger.info("Auto created tables for '{}' seconds. detail: {}, location: {}", JacksonUtil.toJson(contextWrapper.getDttRunDetail()), JacksonUtil.toJson(contextWrapper.getDttRunDetail()), allInOneProperties.getAbsoluteFilename());
            else
                logger.info("Auto created tables for '{}' seconds. detail: {}", JacksonUtil.toJson(contextWrapper.getDttRunDetail()), JacksonUtil.toJson(contextWrapper.getDttRunDetail()));
        }

    }
}
