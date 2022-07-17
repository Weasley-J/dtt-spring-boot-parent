package cn.alphahub.dtt.plus.util;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.exception.ParseException;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * DTT Class Util
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/17
 */
public class ClassUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ClassUtil.class);

    private ClassUtil() {

    }

    /**
     * Reflection to get the return value of the given method, no args
     *
     * @param method the given method
     * @param aClass which Class be invoked
     * @return value of the given method，default value
     */
    @SuppressWarnings("all")
    public static <T> T invoke(Method method, Class<?> aClass) {
        method.setAccessible(true);
        try {
            return (T) method.invoke(ClassUtils.newInstance(aClass));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }

    /**
     * 获取所有公共GETTER方法
     *
     * @param aClass class 对象
     * @return all public getter methods
     */
    public static List<Method> getPublicGetterMethods(Class<?> aClass) {
        return cn.hutool.core.util.ClassUtil.getPublicMethods(aClass, method -> method.getName().startsWith(Constants.GET) && !method.getName().equals("getClass"));
    }

    /**
     * load class
     *
     * @param fullyQualifiedClassName fully qualified class name
     * @return the class represented by className using the current thread's context class loader(class be initialized)
     */
    public static Class<?> loadClass(String fullyQualifiedClassName) {
        try {
            return org.apache.commons.lang3.ClassUtils.getClass(fullyQualifiedClassName);
        } catch (ClassNotFoundException e) {
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }

    /**
     * get declared field by class and field name
     *
     * @param fieldName the name of the field
     * @param aClass    the given Class
     */
    public static Field getDeclaredField(Class<?> aClass, String fieldName) {
        try {
            return aClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }
}
