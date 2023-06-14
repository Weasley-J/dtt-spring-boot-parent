package cn.alphahub.dtt.plus.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Yaml to Java Properties
 */
@SuppressWarnings({"unchecked"})
public final class YamlUtil {

    private static final Logger logger = LoggerFactory.getLogger(YamlUtil.class);

    private YamlUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Converts Yaml to Properties
     *
     * @param in yaml文件的输入流
     * @return Properties
     * @apiNote 使用Yaml InputStream读取，只能读一个yml文件
     * @see YamlUtil#toProperties(String...)
     */
    public static Properties toProperties(InputStream in) {
        Yaml yaml = new Yaml();
        TreeMap<String, Map<String, Object>> config = yaml.loadAs(in, TreeMap.class);
        //logger.info("{}", String.format("%s%n\nConverts to Properties:%n%n%s", config.toString(), toPropertiesString(config)).var);
        return toProperties(config);
    }

    /**
     * Converts Yaml to Properties
     *
     * @param yaml classpath下的yaml文件名，相对路径: "application.yml","application-dev.yml"
     * @return Properties
     * @apiNote 使用YamlPropertiesFactoryBean读取，支持多个yml文件
     */
    public static Properties toProperties(String... yaml) {
        if (yaml == null || yaml.length == 0) {
            if (logger.isWarnEnabled()) {
                logger.warn("yaml name of classpath cannot be null!");
            }
            return new Properties();
        }
        ClassPathResource[] resources = new ClassPathResource[yaml.length];
        for (int i = 0; i < yaml.length; i++) {
            resources[i] = new ClassPathResource(yaml[i]);
        }
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resources);
        return factoryBean.getObject();
    }

    private static String toPropertiesString(TreeMap<String, Map<String, Object>> config) {
        StringBuilder sb = new StringBuilder();
        config.forEach((k, v) -> sb.append(toString(k, v)));
        return sb.toString();
    }

    private static Properties toProperties(TreeMap<String, Map<String, Object>> config) {
        Properties properties = new Properties();
        String formatted = toPropertiesString(config);
        String separator = System.getProperty("line.separator");
        String[] splits = formatted.split(separator);
        for (String str : splits) {
            String[] split = str.split("=");
            String key = split[0];
            String value = str.substring(key.length() + 1);
            properties.put(key, value);
        }
        return properties;
    }

    private static String toString(String key, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                sb.append(toString(String.format("%s.%s", key, mapKey), (Map<String, Object>) value));
            } else {
                sb.append(String.format("%s.%s=%s%n", key, mapKey, value.toString()));
            }
        }
        return sb.toString();
    }
}
