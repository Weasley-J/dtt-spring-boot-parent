package cn.alphahub.dtt.plus.config;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

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
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource[] resources = Arrays.stream(PROPERTIES_FILES).map(ClassPathResource::new).collect(Collectors.toList()).toArray(new Resource[PROPERTIES_FILES.length]);
        for (Resource resource : resources) {
            try {
                environment.getPropertySources().addLast(new ResourcePropertySource(resource));
            } catch (IOException ex) {
                throw new IllegalStateException("加载配置文件失败:'" + resource + "'", ex);
            }
        }
    }
}
