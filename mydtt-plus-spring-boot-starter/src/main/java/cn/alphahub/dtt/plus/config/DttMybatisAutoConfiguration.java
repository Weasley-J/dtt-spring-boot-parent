package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.framework.ClassScanningProvider;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.interceptor.DefaultDttMybatisInterceptor;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static cn.alphahub.dtt.plus.config.DttProperties.DttMybatisOrmSupportProperties;

/**
 * The configuration for dtt-mybatis
 *
 * @author weasley
 * @version 1.0.0
 */
@Component
@Lazy(value = false)
@ConditionalOnClass({SqlSessionFactory.class})
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({DttMybatisOrmSupportProperties.class})
@AutoConfigureAfter(name = {"mybatisAutoConfiguration", "mybatisPlusAutoConfiguration"})
public class DttMybatisAutoConfiguration implements InitializingBean {
    /**
     * The type aliases map of mybatis
     * <p>
     * key:The simple name of class(Lower case, small camel case), value: The class
     */
    public static final Map<String, Class<?>> TYPE_ALIASES_MAP = new ConcurrentHashMap<>(768);

    private static final String[] MYBATIS_PROP_PREFIX = {"mybatis-plus.type-aliases-package", "mybatis.type-aliases-package"};
    private final ClassScanningProvider classScanningProvider;
    /**
     * The list of 'SqlSessionFactory'
     */
    private final List<SqlSessionFactory> sqlSessionFactories;

    /**
     * The default interceptor of mybatis-pro
     */
    private final DefaultDttMybatisInterceptor defaultDttMybatisInterceptor;


    public DttMybatisAutoConfiguration(ClassScanningProvider classScanningProvider, List<SqlSessionFactory> sqlSessionFactories, DefaultDttMybatisInterceptor defaultDttMybatisInterceptor) {
        this.classScanningProvider = classScanningProvider;
        this.sqlSessionFactories = sqlSessionFactories;
        this.defaultDttMybatisInterceptor = defaultDttMybatisInterceptor;
    }

    @Override
    public void afterPropertiesSet() {
        sqlSessionFactories.forEach(sqlSessionFactory -> {
            Configuration configuration = sqlSessionFactory.getConfiguration();
            if (null != configuration && !configuration.getInterceptors().contains(defaultDttMybatisInterceptor)) {
                configuration.addInterceptor(defaultDttMybatisInterceptor);
            }
        });

        for (String mybatisPropPrefix : MYBATIS_PROP_PREFIX) {
            String property = SpringUtil.getProperty(mybatisPropPrefix);
            if (StringUtils.isNoneBlank(property)) {
                String[] typeAliasesPackages = StringUtils.split(property, ",");
                if (ObjectUtils.isNotEmpty(typeAliasesPackages)) {
                    Set<Class<?>> classes = classScanningProvider.scanBasePackage(typeAliasesPackages).stream().filter(aClass -> !aClass.getSimpleName().endsWith(Constants.BUILDER_SUFFIX)).collect(Collectors.toSet());
                    if (CollectionUtils.isNotEmpty(classes)) {
                        ConcurrentMap<String, ? extends Class<?>> classConcurrentMap = classes.stream().collect(Collectors.toConcurrentMap((key -> com.baomidou.mybatisplus.core.toolkit.StringUtils.firstToLowerCase(key.getSimpleName())), (value -> value)));
                        TYPE_ALIASES_MAP.putAll(classConcurrentMap);
                    }
                }
            }
        }
    }
}
