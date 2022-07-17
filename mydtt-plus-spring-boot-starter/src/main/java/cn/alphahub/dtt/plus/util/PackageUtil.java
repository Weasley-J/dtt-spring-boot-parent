package cn.alphahub.dtt.plus.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 包工具类根据package路径加载class
 */
public class PackageUtil {

    /**
     * 扫描'scanPackages'下的文件的匹配符
     */
    protected static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    private static final Logger LOG = LoggerFactory.getLogger(PackageUtil.class);

    private PackageUtil() {
    }

    /**
     * 结合spring的类扫描方式
     * 根据需要扫描的包路径及相应的注解，获取最终测method集合
     * 仅返回public方法，如果方法是非public类型的，不会被返回
     * 可以扫描工程下的class文件及jar中的class文件
     *
     * @param annotation   annotation
     * @param scanPackages scan packages
     * @return methods
     */
    public static Set<Method> findClassAnnotationMethods(String scanPackages, Class<? extends Annotation> annotation) {
        //获取所有的类
        Set<String> clazzSet = findPackageClass(scanPackages);
        Set<Method> methods = new LinkedHashSet<>();
        //遍历类，查询相应的annotation方法
        for (String clazz : clazzSet) {
            Set<Method> ms = findAnnotationMethods(clazz, annotation);
            methods.addAll(ms);
        }
        return methods;
    }

    /**
     * 根据扫描包的,查询下面的所有类
     *
     * @param scanPackages 扫描的package路径
     * @return 查询下面的所有类
     */
    public static Set<String> findPackageClass(String scanPackages) {
        if (StringUtils.isBlank(scanPackages)) {
            return new LinkedHashSet<>();
        }
        //验证及排重包路径,避免父子路径多次扫描
        Set<String> packages = checkPackage(scanPackages);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        Set<String> clazzSet = new LinkedHashSet<>();
        for (String basePackage : packages) {
            if (StringUtils.isBlank(basePackage)) {
                continue;
            }
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage)) + '/' + DEFAULT_RESOURCE_PATTERN;
            try {
                Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
                for (Resource resource : resources) {
                    //检查resource，这里的resource都是class
                    String clazz = loadClassName(metadataReaderFactory, resource);
                    clazzSet.add(clazz);
                }
            } catch (Exception e) {
                LOG.error("获取包下面的类信息失败, package: {}", basePackage, e);
            }

        }
        return clazzSet;
    }

    /**
     * 根据扫描包的,查询下面的所有类
     *
     * @param scanPackages 扫描的package路径,多个用","隔开
     * @return Classes
     */
    public static Set<Class<?>> scanPackages(String scanPackages) {
        if (StringUtils.isBlank(scanPackages)) {
            return Collections.emptySet();
        }
        //验证及排重包路径,避免父子路径多次扫描
        Set<String> packages = checkPackage(scanPackages);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        Set<Class<?>> clazzSet = new LinkedHashSet<>();
        for (String basePackage : packages) {
            if (StringUtils.isBlank(basePackage)) {
                continue;
            }
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage)) + '/' + DEFAULT_RESOURCE_PATTERN;
            try {
                Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
                for (Resource resource : resources) {
                    //检查resource，这里的resource都是class
                    String clazz = loadClassName(metadataReaderFactory, resource);
                    Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass(clazz);
                    clazzSet.add(loadClass);
                }
            } catch (Exception e) {
                LOG.error("获取包下面的类信息失败, package: {}", basePackage, e);
            }

        }
        return clazzSet;
    }

    /**
     * 排重、检测package父子关系，避免多次扫描
     *
     * @param scanPackages 要扫描的包
     * @return 返回检查后有效的路径集合
     */
    @SuppressWarnings({"AlL"})
    private static Set<String> checkPackage(String scanPackages) {
        if (StringUtils.isBlank(scanPackages)) {
            return Collections.emptySet();
        }
        Set<String> packages = new LinkedHashSet<>();
        //排重路径
        Collections.addAll(packages, scanPackages.split(","));
        for (String pInArr : packages.toArray(new String[packages.size()])) {
            if (StringUtils.isBlank(pInArr) || pInArr.startsWith(".")) {
                continue;
            }
            if (pInArr.endsWith(".")) {
                pInArr = pInArr.substring(0, pInArr.length() - 1);
            }
            Iterator<String> packageIte = packages.iterator();
            boolean needAdd = true;
            while (packageIte.hasNext()) {
                String pack = packageIte.next();
                if (pInArr.startsWith(pack + ".")) {
                    //如果待加入的路径是已经加入的pack的子集，不加入
                    needAdd = false;
                } else if (pack.startsWith(pInArr + ".")) {
                    //如果待加入的路径是已经加入的pack的父集，删除已加入的pack
                    packageIte.remove();
                }
            }
            if (needAdd) {
                packages.add(pInArr);
            }
        }
        return packages;
    }


    /**
     * 加载资源，根据resource获取className
     *
     * @param metadataReaderFactory spring中用来读取resource为class的工具
     * @param resource              这里的资源就是一个Class
     * @return 加载资源，根据resource获取className
     */
    private static String loadClassName(MetadataReaderFactory metadataReaderFactory, Resource resource) {
        try {
            if (resource.isReadable()) {
                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                return metadataReader.getClassMetadata().getClassName();
            }
        } catch (Exception e) {
            LOG.error("根据resource获取类名称失败", e);
        }
        return null;
    }

    /**
     * 把action下面的所有method遍历一次，标记他们是否需要进行敏感词验证
     * 如果需要，放入cache中
     *
     * @param fullClassName 全限定类名
     * @param anno          annotation
     * @return methods
     */
    public static Set<Method> findAnnotationMethods(String fullClassName, Class<? extends Annotation> anno) {
        Set<Method> methodSet = new LinkedHashSet<>();
        Class<?> clz;
        try {
            clz = Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
            LOG.error("找不到类异常", e);
            return Collections.emptySet();
        }
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getModifiers() != Modifier.PUBLIC) {
                continue;
            }
            Annotation annotation = method.getAnnotation(anno);
            if (annotation != null) {
                methodSet.add(method);
            }
        }
        return methodSet;
    }
}
