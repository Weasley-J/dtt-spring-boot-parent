package cn.alphahub.dtt.plus.config.support;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.InitDttClient;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.framework.core.parser.DefaultJavadocParser;
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
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
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
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.CodeGeneratorProperties;
import static cn.alphahub.dtt.plus.util.JacksonUtil.toJson;
import static cn.alphahub.dtt.plus.util.StringUtils.camelToUnderline;
import static cn.alphahub.dtt.plus.util.StringUtils.firstToLowerCase;
import static cn.alphahub.dtt.plus.util.StringUtils.firstToUpperCase;
import static cn.alphahub.dtt.plus.util.StringUtils.isNotBlank;
import static cn.alphahub.dtt.plus.util.StringUtils.underlineToCamel;
import static java.lang.System.out;
import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.removeIgnoreCase;
import static org.apache.commons.lang3.StringUtils.removeStartIgnoreCase;

/**
 * The configurer of  mybatis-plus code generator
 *
 * @author weasley
 * @version 1.0.0
 */
@Component
@AutoConfigureAfter({InitDttClient.class, InitDttHandler.class, DttCommentParser.class})
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
    @SuppressWarnings({"all"})
    private static final String[] TEMPLATE_RESOURCES = new String[]{"IService.java", "ServiceImpl.java", "Controller.java", "Service.java", "Mapper.java", "Mapper.xml",};
    private final ApplicationContext applicationContext;

    public MyBatisPlusCodeGeneratorConfigurer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * A bean what takes up a code generated space
     *
     * @param cgProperties The cgProperties of mybatis-plus code generator
     * @return The class of mybatis-plus code generator
     */
    @Bean
    @ConditionalOnBean({VelocityEngine.class, ClassScanningProvider.class})
    public MyBatisPlusCodeGeneratorPlaceholder myBatisPlusCodeGeneratorPlaceholder(CodeGeneratorProperties cgProperties,
                                                                                   VelocityEngine velocityEngine,
                                                                                   ClassScanningProvider classScanningProvider) {
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

        List<MyBatisPlusCodeWrapper> codeWrappers = getMyBatisPlusCodeWrappers(cgProperties, applicationContext.getBean(DefaultJavadocParser.class), classScanningProvider);

        if (CollectionUtils.isEmpty(codeWrappers)) return placeholder;

        for (MyBatisPlusCodeWrapper codeWrapper : codeWrappers) {
            VelocityContext context = new VelocityContext();
            context.put("modulePackage", codeWrapper.getModulePackage());
            context.put("apiPathPrefix", camelToUnderline(codeWrapper.getDomainCamelcaseName()).replaceAll("_", "/"));
            context.put("author", firstToUpperCase(System.getProperty("user.name")));
            context.put("primaryKeyAttrType", codeWrapper.getPrimaryKeyAttrType());
            context.put("primaryKeyAttrName", codeWrapper.getPrimaryKeyAttrName());
            context.put("domainDescription", codeWrapper.getDomainDescription());
            context.put("modelEntityName", codeWrapper.getModelEntityName());
            context.put("domainCamelcaseName", codeWrapper.getDomainCamelcaseName());
            context.put("domainSimpleClassName", codeWrapper.getDomainSimpleClassName());
            context.put("domainFullyQualifiedClass", codeWrapper.getDomainFullyQualifiedClass());
            for (String templateResource : TEMPLATE_RESOURCES) {
                if (shouldSkipCurrent(cgProperties, templateResource)) continue;
                String templateName = RESOURCE_PATH + "/" + templateResource + TEMPLATE_SUFFIX;
                StringWriter writer = new StringWriter();
                Template template = velocityEngine.getTemplate(templateName, StandardCharsets.UTF_8.name());
                template.merge(context, writer);
                if (Boolean.TRUE.equals(cgProperties.getShowCode())) {
                    log.info("/* -------------- Source code of '{}' -------------- */\n{}", codeWrapper.getDomainFullyQualifiedClass(), writer);
                }
                String absoluteFilename = getAbsoluteFilename(cgProperties, codeWrapper, templateResource);
                try {
                    boolean overrideExists = cgProperties.getOverrideExists();
                    File file = new File(absoluteFilename);
                    if (!file.getParentFile().exists()) {
                        FileUtils.forceMkdirParent(file);
                    }
                    if (overrideExists) {
                        IOUtils.write(writer.toString(), new FileOutputStream(absoluteFilename, false), StandardCharsets.UTF_8);
                    } else {
                        if (!file.exists()) {
                            IOUtils.write(writer.toString(), new FileOutputStream(absoluteFilename, false), StandardCharsets.UTF_8);
                        }
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
     * should skip current turn
     *
     * @param cgProperties     MyBatis-Plus code generation configuration properties
     * @param templateResource the template resource
     * @return true: should skip current
     */
    protected boolean shouldSkipCurrent(CodeGeneratorProperties cgProperties, String templateResource) {
        if (cgProperties.getIncludeInterface().equals(false) && "IService.java".equals(templateResource))
            return true;
        if (cgProperties.getIncludeInterface().equals(false) && "ServiceImpl.java".equals(templateResource))
            return true;
        return cgProperties.getIncludeController().equals(false) && "Controller.java".equals(templateResource);
    }

    /**
     * Get mybatis-plus code wrappers
     *
     * @param cgProperties          The given MyBatis-Plus code generation configuration properties
     * @param commentParser         The comment parser
     * @param classScanningProvider The Class scanning provider
     * @return mybatis-plus code wrappers
     */
    private List<MyBatisPlusCodeWrapper> getMyBatisPlusCodeWrappers(CodeGeneratorProperties cgProperties, DttCommentParser<ModelEntity> commentParser, ClassScanningProvider classScanningProvider) {
        List<MyBatisPlusCodeWrapper> codeWrappers = new ArrayList<>();

        if (StringUtils.isNoneBlank(cgProperties.getBasePackage())) {
            codeWrappers = classScanningProvider.scanBasePackage(cgProperties.getBasePackage()).stream()
                    .filter(className -> !className.getName().endsWith("Builder"))
                    .map(aClass -> this.processCodeWrapper(cgProperties, commentParser, aClass))
                    .collect(Collectors.toList());
        }

        if (ObjectUtils.isNotEmpty(cgProperties.getBaseClasses())) {
            for (Class<? extends Serializable> aClass : cgProperties.getBaseClasses()) {
                codeWrappers.add(this.processCodeWrapper(cgProperties, commentParser, aClass));
            }
        }

        return codeWrappers;
    }

    /**
     * Process code wrapper for code-generator
     *
     * @param cgProperties  MyBatis-Plus code generation configuration properties
     * @param commentParser Analyze model and model descriptions
     * @param aClass        The class of model
     * @return code wrapper for code-generator
     */
    public MyBatisPlusCodeWrapper processCodeWrapper(CodeGeneratorProperties cgProperties, DttCommentParser<ModelEntity> commentParser, Class<?> aClass) {
        String modelComment = "";
        ParseFactory<ModelEntity> parseFactory = commentParser.parse(aClass.getName());
        if (null != parseFactory.getModel()) {
            modelComment = defaultIfBlank(parseFactory.getModel().getModelComment(), "");
        }
        MyBatisPlusCodeWrapper codeWrapper = MyBatisPlusCodeWrapper.builder()
                .modelEntityName(aClass.getSimpleName())
                .modulePackage(cgProperties.getModulePackage())
                .domainDescription(modelComment)
                .domainCamelcaseName(firstToLowerCase(aClass.getSimpleName()))
                .domainSimpleClassName(aClass.getSimpleName())
                .domainFullyQualifiedClass(aClass.getName())
                .build();
        for (ModelEntity.Detail detail : parseFactory.getModel().getDetails()) {
            if (Boolean.TRUE.equals(detail.getIsPrimaryKey())) {
                codeWrapper.setPrimaryKeyAttrType(detail.getJavaDataType());
                codeWrapper.setPrimaryKeyAttrName(underlineToCamel(detail.getFiledName()));
                break;
            }
        }
        if (isNotBlank(cgProperties.getRemovePrefix()) && cgProperties.getRemovePrefix().length() > 0) {
            String domainSimpleClassName = removeIgnoreCase(codeWrapper.getDomainSimpleClassName(), cgProperties.getRemovePrefix());
            String domainCamelcaseName = removeIgnoreCase(codeWrapper.getDomainCamelcaseName(), cgProperties.getRemovePrefix());
            codeWrapper.setDomainSimpleClassName(domainSimpleClassName);
            codeWrapper.setDomainCamelcaseName(firstToLowerCase(domainCamelcaseName));
        }
        return codeWrapper;
    }

    /**
     * The Absolute Filename Of Source Code
     *
     * @param cgProperties     MyBatis-Plus code generation configuration properties
     * @param codeWrapper      mybatis-plus code wrapper to integrate metadata
     * @param templateResource A template resource of velocity '.vm'
     * @return The Absolute Filename Of Source Code
     */
    private String getAbsoluteFilename(CodeGeneratorProperties cgProperties, MyBatisPlusCodeWrapper codeWrapper, String templateResource) {
        String basicPath = "";
        String absoluteFilename = "";

        String modulePath = cgProperties.getModulePath();
        String modulePackagePath = codeWrapper.getModulePackagePath();

        String javaSuffix = ".java";
        String xmlSuffix = ".xml";

        String fileParentPathname;
        if ("Controller.java".equals(templateResource) && cgProperties.getIncludeController().equals(true))
            fileParentPathname = "controller";
        else if ("IService.java".equals(templateResource) && cgProperties.getIncludeInterface().equals(true)) {
            fileParentPathname = "service";
            templateResource = StringUtils.removeStartIgnoreCase(templateResource, "I");
        } else if ("ServiceImpl.java".equals(templateResource) && cgProperties.getIncludeInterface().equals(true))
            fileParentPathname = "service/impl";
        else
            fileParentPathname = templateResource.split("\\.")[0].toLowerCase();

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

        String domainSimpleClassName = codeWrapper.getDomainSimpleClassName();
        if (isNotBlank(cgProperties.getRemovePrefix()) && cgProperties.getRemovePrefix().length() > 0) {
            domainSimpleClassName = removeStartIgnoreCase(domainSimpleClassName, cgProperties.getRemovePrefix());
        }

        if (templateResource.endsWith(javaSuffix))
            absoluteFilename = MessageFormat.format("{0}/{1}/{2}{3}", basicPath, fileParentPathname, domainSimpleClassName, templateResource);

        if (templateResource.endsWith(xmlSuffix))
            absoluteFilename = MessageFormat.format("{0}/{1}{2}", basicPath, domainSimpleClassName, templateResource);

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
         * The model class name of your domain object, i.e: MyBatisPlusCodeWrapper
         */
        private String modelEntityName;
        /**
         * The package name of your module
         */
        private String modulePackage;
        /**
         * The simple class name of your domain object，i.e: myBatisPlusCodeWrapper
         */
        private String domainCamelcaseName;
        /**
         * The simple class name of your domain object, i.e: MyBatisPlusCodeWrapper
         */
        private String domainSimpleClassName;
        /**
         * The fully qualified class name of your domain object, i.e: cn.alphahub.dtt.plus.config.support.MyBatisPlusCodeGeneratorConfigurer.MyBatisPlusCodeWrapper
         */
        private String domainFullyQualifiedClass;
        /**
         * The description for domain object
         */
        @Builder.Default
        private String domainDescription = "";
        /**
         * The java type of primary key
         */
        private String primaryKeyAttrType;
        /**
         * The name of primary key
         */
        private String primaryKeyAttrName;

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
