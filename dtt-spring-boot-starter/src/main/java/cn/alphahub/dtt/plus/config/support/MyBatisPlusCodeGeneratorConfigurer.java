package cn.alphahub.dtt.plus.config.support;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DefaultJavaDocParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.CodeGeneratorProperties;
import static cn.alphahub.dtt.plus.util.JacksonUtil.toJson;
import static java.lang.System.out;

/**
 * The configurer of  mybatis-plus code generator
 *
 * @author weasley
 * @version 1.0.0
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({CodeGeneratorProperties.class})
@ConditionalOnProperty(prefix = DttProperties.PREFIX + ".code-generator", name = {"is-enable"}, havingValue = "true")
public class MyBatisPlusCodeGeneratorConfigurer {
    private static final Logger log = LoggerFactory.getLogger(MyBatisPlusCodeGeneratorConfigurer.class);
    /**
     * The resource path of the template file
     */
    private static final String RESOURCE_PATH = "META-INF/code-templates";
    /**
     * The suffix of the template file
     */
    private static final String TEMPLATE_SUFFIX = ".vm";
    /**
     * The template resources
     */
    private static final String[] TEMPLATE_RESOURCES = new String[]{"Service.java", "Mapper.java", "Mapper.xml",};

    /**
     * A bean what takes up a code generated space
     *
     * @param cgProperties The cgProperties of mybatis-plus code generator
     * @return The class of mybatis-plus code generator
     */
    @Bean
    @ConditionalOnBean({VelocityEngine.class, DefaultJavaDocParser.class, ClassScanningProvider.class})
    public MyBatisPlusCodeGeneratorPlaceholder myBatisPlusCodeGeneratorPlaceholder(CodeGeneratorProperties cgProperties,
                                                                                   VelocityEngine velocityEngine,
                                                                                   DefaultJavaDocParser javaDocParser,
                                                                                   ClassScanningProvider classScanningProvider
    ) {
        MyBatisPlusCodeGeneratorPlaceholder placeholder = new MyBatisPlusCodeGeneratorPlaceholder();

        if (StringUtils.isAnyBlank(cgProperties.getModuleName(), cgProperties.getModulePath())) {
            log.warn("The properties of code generator cannot be null or empty: {}", toJson(cgProperties));
            return placeholder;
        }

        URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        if (ResourceUtils.isJarURL(location)) {
            log.warn("The code generator not support for application run type of '{}'!", location);
            return placeholder;
        }

        List<MyBatisPlusCodeWrapper> codeWrappers = getMyBatisPlusCodeWrappers(cgProperties, javaDocParser, classScanningProvider);

        if (CollectionUtils.isEmpty(codeWrappers)) return placeholder;

        for (MyBatisPlusCodeWrapper codeWrapper : codeWrappers) {
            VelocityContext context = new VelocityContext();
            context.put("modulePackage", codeWrapper.getModulePackage());
            context.put("domainFullyQualifiedClass", codeWrapper.getDomainFullyQualifiedClass());
            context.put("domainSimpleClassName", codeWrapper.getDomainSimpleClassName());
            context.put("domainDescription", codeWrapper.getDomainDescription());
            for (String templateResource : TEMPLATE_RESOURCES) {
                String templateName = RESOURCE_PATH + "/" + templateResource + TEMPLATE_SUFFIX;
                StringWriter writer = new StringWriter();
                Template template = velocityEngine.getTemplate(templateName, StandardCharsets.UTF_8.name());
                template.merge(context, writer);
                if (cgProperties.getShowCode().equals(true)) {
                    log.info("/* -------------- Source code of '{}' -------------- */\n{}", codeWrapper.getDomainFullyQualifiedClass(), writer);
                }
                String absoluteFilename = getAbsoluteFilename(cgProperties, codeWrapper, templateResource);
                try {
                    File file = new File(absoluteFilename);
                    if (!file.getParentFile().exists()) {
                        FileUtils.forceMkdirParent(file);
                    }
                    if (cgProperties.getOverrideExists().equals(true)) {
                        IOUtils.write(writer.toString(), new FileOutputStream(absoluteFilename, false), StandardCharsets.UTF_8);
                    }
                    if (cgProperties.getOverrideExists().equals(false) && !file.exists()) {
                        IOUtils.write(writer.toString(), new FileOutputStream(absoluteFilename, false), StandardCharsets.UTF_8);
                    }
                } catch (IOException ex) {
                    log.error("{}", ex.getLocalizedMessage(), ex);
                }
                out.println(absoluteFilename);
            }
        }

        return placeholder;
    }

    /**
     * Get mybatis-plus code wrappers
     *
     * @param cgProperties          The given MyBatis-Plus code generation configuration properties
     * @param javaDocParser         The java doc parser
     * @param classScanningProvider The Class scanning provider
     * @return mybatis-plus code wrappers
     */
    private List<MyBatisPlusCodeWrapper> getMyBatisPlusCodeWrappers(CodeGeneratorProperties cgProperties, DefaultJavaDocParser javaDocParser, ClassScanningProvider classScanningProvider) {
        List<MyBatisPlusCodeWrapper> codeWrappers = new ArrayList<>();

        if (StringUtils.isNoneBlank(cgProperties.getBasePackage())) {
            codeWrappers = classScanningProvider.scanBasePackage(cgProperties.getBasePackage()).stream()
                    .filter(className -> !className.getName().endsWith("Builder"))
                    .map(aClass -> {
                        String modelComment = "";
                        ParseFactory<ModelEntity> parseFactory = javaDocParser.parse(aClass.getName());
                        if (null != parseFactory.getModel())
                            modelComment = StringUtils.defaultIfBlank(parseFactory.getModel().getModelComment(), "");
                        return MyBatisPlusCodeWrapper.builder()
                                .modulePackage(cgProperties.getModulePackage())
                                .domainDescription(modelComment)
                                .domainSimpleClassName(aClass.getSimpleName())
                                .domainFullyQualifiedClass(aClass.getName())
                                .build();
                    }).collect(Collectors.toList());
        }

        if (ObjectUtils.isNotEmpty(cgProperties.getBaseClasses())) {
            for (Class<? extends Serializable> aClass : cgProperties.getBaseClasses()) {
                String modelComment = "";
                ParseFactory<ModelEntity> parseFactory = javaDocParser.parse(aClass.getName());
                if (null != parseFactory.getModel())
                    modelComment = StringUtils.defaultIfBlank(parseFactory.getModel().getModelComment(), "");
                codeWrappers.add(MyBatisPlusCodeWrapper.builder()
                        .modulePackage(cgProperties.getModulePackage())
                        .domainDescription(modelComment)
                        .domainSimpleClassName(aClass.getSimpleName())
                        .domainFullyQualifiedClass(aClass.getName())
                        .build());
            }
        }

        return codeWrappers;
    }


    /**
     * The Absolute Filename Of Source Code
     *
     * @param cgProperties     MyBatis-Plus code generation configuration properties
     * @param codeWrapper      mybatis-plus code wrapper to integrate metadata
     * @param templateResource A template resource of velocity（'.vm'）
     * @return The Absolute Filename Of Source Code
     */
    private String getAbsoluteFilename(CodeGeneratorProperties cgProperties, MyBatisPlusCodeWrapper codeWrapper, String templateResource) {
        String basicPath = "";
        String absoluteFilename = "";

        String modulePath = cgProperties.getModulePath();
        String modulePackagePath = codeWrapper.getModulePackagePath();

        String javaSuffix = ".java";
        String xmlSuffix = ".xml";

        String fileParentPathname = templateResource.split("\\.")[0].toLowerCase(Locale.ROOT);

        if (modulePath.endsWith("/")) {
            if (templateResource.endsWith(javaSuffix)) {
                basicPath = modulePath + "src/main/java/" + modulePackagePath;
            }
            if (templateResource.endsWith(xmlSuffix)) {
                basicPath = modulePath + "src/main/resources/mapper/" + cgProperties.getModuleName();
            }
        } else {
            if (templateResource.endsWith(javaSuffix)) {
                basicPath = modulePath + "/src/main/java/" + modulePackagePath;
            }
            if (templateResource.endsWith(xmlSuffix)) {
                basicPath = modulePath + "/src/main/resources/mapper/" + cgProperties.getModuleName();
            }
        }

        if (templateResource.endsWith(javaSuffix))
            absoluteFilename = MessageFormat.format("{0}/{1}/{2}{3}", basicPath, fileParentPathname, codeWrapper.getDomainSimpleClassName(), templateResource);

        if (templateResource.endsWith(xmlSuffix))
            absoluteFilename = MessageFormat.format("{0}/{1}{2}", basicPath, codeWrapper.getDomainSimpleClassName(), templateResource);

        return absoluteFilename;
    }

    /**
     * The class of mybatis-plus code generator
     */
    @Data
    public static class MyBatisPlusCodeGeneratorPlaceholder {
    }

    /**
     * mybatis-plus code wrapper to integrate metadata
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class MyBatisPlusCodeWrapper {
        /**
         * The package name of your module
         */
        private String modulePackage;
        /**
         * The simple class name of your domain object
         */
        private String domainSimpleClassName;
        /**
         * The fully qualified class name of your domain object
         */
        private String domainFullyQualifiedClass;
        /**
         * The description for domain object
         */
        private String domainDescription = "";

        /**
         * @return If the module Package Name is missing, the parent package name of the module Package Name will be returned
         */
        public String getModulePackage() {
            if (StringUtils.isNoneBlank(modulePackage)) return modulePackage;
            String[] oldPackages = domainFullyQualifiedClass.split("\\.");
            String[] newPackages = Arrays.copyOf(oldPackages, oldPackages.length - 1);
            return StringUtils.join(newPackages, ".");
        }

        /**
         * @return If the module Package Name is missing, the parent package name of the module Package Name will be returned
         */
        public String getModulePackagePath() {
            if (StringUtils.isBlank(modulePackage)) return "";
            String[] oldPackages = modulePackage.split("\\.");
            return StringUtils.join(oldPackages, "/");
        }
    }

}
