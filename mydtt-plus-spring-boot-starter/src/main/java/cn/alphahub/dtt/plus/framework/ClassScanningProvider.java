package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.exception.ParseException;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class scanning provider
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/17
 * @since 1.0.4
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConditionalOnBean(annotation = {EnableDtt.class})
public class ClassScanningProvider {
    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    protected final Log logger = LogFactory.getLog(getClass());

    private Environment environment;

    /**
     * The classes base package
     *
     * @param basePackage The given package
     * @return classes of The package
     */
    public Set<Class<?>> scanBasePackage(String basePackage) {
        Assert.isTrue(StringUtils.hasText(basePackage), "'basePackage' must be not blank");
        Set<Class<?>> candidates = new LinkedHashSet<>();
        try {
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + resolveBasePackage(basePackage) + '/' + DEFAULT_RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
            boolean traceEnabled = logger.isTraceEnabled();
            boolean debugEnabled = logger.isDebugEnabled();
            for (Resource resource : resources) {
                if (traceEnabled) logger.trace("Scanning " + resource);
                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                String className = metadataReader.getClassMetadata().getClassName();
                Class<?> aClass = ClassUtils.forName(className, Thread.currentThread().getContextClassLoader());
                candidates.add(aClass);
            }
        } catch (Exception ex) {
            throw new ParseException("I/O failure during classpath scanning", ex);
        }
        return candidates;
    }


    /**
     * The classes of given basePackages
     *
     * @param basePackages The given packages
     * @return classes of The package
     */
    public Set<Class<?>> scanBasePackage(String... basePackages) {
        Assert.notEmpty(basePackages, "basePackages must be not empty");
        String[] noneBlankPackages = Arrays.stream(basePackages).filter(StringUtils::hasText).toArray(String[]::new);
        Set<Class<?>> candidates = new LinkedHashSet<>();
        Arrays.stream(noneBlankPackages).filter(StringUtils::hasText).collect(Collectors.toList())
                .forEach(basePackage -> candidates.addAll(this.scanBasePackage(basePackage)));
        return candidates;
    }

    /**
     * The classes of given basePackages and annotation
     *
     * @param basePackages The given packages
     * @param annotation   The given annotation
     * @return classes of The package
     */
    public Set<Class<?>> scanBasePackageWithAnnotation(String[] basePackages, Class<? extends Annotation> annotation) {
        Assert.notEmpty(basePackages, "basePackages must be not empty");
        Assert.notNull(annotation, "annotation must be not empty");
        Set<Class<?>> candidates = new LinkedHashSet<>();
        Arrays.stream(basePackages).filter(StringUtils::hasText).collect(Collectors.toList())
                .forEach(basePackage -> {
                    Set<Class<?>> purelyClasses = scanBasePackage(basePackage).stream()
                            .filter(aClass -> aClass.getAnnotation(annotation) != null).collect(Collectors.toSet());
                    candidates.addAll(purelyClasses);
                });
        return candidates;
    }

    /**
     * Resolve the specified base package into a pattern specification for
     * the package search path.
     * <p>The default implementation resolves placeholders against system properties,
     * and converts a "."-based package path to a "/"-based resource path.
     *
     * @param basePackage the base package as specified by the user
     * @return the pattern specification to be used for package searching
     */
    protected String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(getEnvironment().resolveRequiredPlaceholders(basePackage));
    }

    public final Environment getEnvironment() {
        if (this.environment == null) {
            this.environment = new StandardEnvironment();
        }
        return this.environment;
    }
}
