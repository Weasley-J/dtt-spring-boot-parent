package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

import static cn.alphahub.dtt.plus.constant.Constants.PROPERTIES_FILES;

/**
 * extra properties loader
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/11
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultExtraPropertiesLoader implements EnvironmentPostProcessor {

    @Override
    @SuppressWarnings({"all"})
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        for (String propertiesFile : PROPERTIES_FILES) {
            Resource resource = new ClassPathResource(propertiesFile);
            Properties properties = new Properties();
            if (!resource.exists()) {
                throw new IllegalArgumentException("资源'" + resource + "'不存在");
            }
            try {
                properties.load(resource.getInputStream());
                PropertySource<?> propertySource = new PropertiesPropertySource(resource.getFilename(), properties);
                environment.getPropertySources().addLast(propertySource);
            } catch (IOException ex) {
                throw new IllegalStateException("加载配置文件失败" + resource, ex);
            }
        }
    }
}
