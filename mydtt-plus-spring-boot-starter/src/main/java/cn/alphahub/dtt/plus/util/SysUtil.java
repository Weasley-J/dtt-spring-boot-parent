package cn.alphahub.dtt.plus.util;

/**
 * 系统工具类
 *
 * @author weasley
 * @version 1.0.0
 */
public class SysUtil extends cn.hutool.system.SystemUtil {
    /**
     * 系统文件路径分隔符
     * <ul>
     *     <li>windows: "\"</li>
     *     <li>linux: "/"</li>
     * </ul>
     *
     * @return file.separator
     */
    public static String getFileSeparator() {
        return getProps().get("file.separator").toString();
    }

    /**
     * 系统换行符
     * <ul>
     *     <li>Linux: "\n"</li>
     * </ul>
     *
     * @return line.separator
     */
    public static String getLineSeparator() {
        return getProps().get("line.separator").toString();
    }

    /**
     * 工作目录
     * <p>
     * "user.dir": "/Users/weasley/Development/IdeaProjects/domain-to-table-spring-boot",
     *
     * @return user.dir
     */
    public static String getUserDir() {
        return getProps().get("user.dir").toString();
    }

    /**
     * jar包全限定文件路径<br>
     * String path = System.getProperty("java.class.path");
     *
     * @return java.class.path
     */
    public static String getJarPath() {
        return getProps().get("java.class.path").toString();
    }

}
