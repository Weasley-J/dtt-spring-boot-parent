package cn.alphahub.dtt.plus.framework;

import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.SysUtil;
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
     * sql模板文件路径
     */
    public static final String TEMPLATE_DIR = "META-INF/sql-templates";
    /**
     * sql模板文件名后缀
     */
    public static final String TEMPLATE_SUFFIX = ".vm";

    /**
     * 由数据库类型获取对应上午建表模版
     *
     * @param databaseType 数据库类型
     * @return 返回模版文件, 如: mysql.vm
     */
    public static String getTemplate(DatabaseType databaseType) {
        String dbTypeLowerCase = databaseType.name().toLowerCase();
        String templateName = getTemplateName(dbTypeLowerCase);
        return TEMPLATE_DIR + SysUtil.getFileSeparator() + dbTypeLowerCase + SysUtil.getFileSeparator() + templateName + TEMPLATE_SUFFIX;
    }

    /**
     * get template name
     *
     * @param filename template file name
     * @return template name
     * @since 1.0.4
     */
    private static String getTemplateName(String filename) {

        // todo Multi-version template file name control logic

        return filename;
    }

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
