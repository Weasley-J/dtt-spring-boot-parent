package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 加载classpath下的yaml文件到spring环境
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultExtraYamlSourceLoader {

    /**
     * 使用YamlPropertiesFactoryBean加载yaml配置文件
     *
     * @return dttPropertySourcesPlaceholderConfigurer
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer dttYamlPropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource(Constants.DDT_DATA_TYPE_MAPPER));
        configurer.setProperties(Objects.requireNonNull(factoryBean.getObject()));
        return configurer;
    }
}
