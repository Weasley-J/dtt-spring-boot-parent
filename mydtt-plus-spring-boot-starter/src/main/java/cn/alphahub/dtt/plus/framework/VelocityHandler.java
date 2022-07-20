package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * velocity engine config
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/11
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(annotation = {EnableDtt.class})
public class VelocityHandler {
    /**
     * @return VelocityEngine
     */
    @Bean
    public VelocityEngine velocityEngine() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        ve.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        ve.setProperty("resource.loader.file.class", ClasspathResourceLoader.class.getName());
        ve.init();
        return ve;
    }
}
