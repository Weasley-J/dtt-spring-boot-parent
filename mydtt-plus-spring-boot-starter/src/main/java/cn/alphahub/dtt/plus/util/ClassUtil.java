package cn.alphahub.dtt.plus.util;

import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.exception.ParseException;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
     * Reflection to Get  the return value of the given method, no args
     *
     * @param <T>    The return type
     * @param method The given method
     * @param aClass which Class be invoked
     * @return value of the given method，default value
     */
    public static <T> T invoke(Method method, Class<?> aClass) {
        try {
            method.setAccessible(true);
            return (T) method.invoke(ClassUtils.newInstance(aClass));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }

    /**
     * Get  Enum type values
     * <p>Example:
     * <pre>
     * {@code @Getter}
     * {@code @AllArgsConstructor}
     * public enum MemberType {
     *   ORDINARY("普通会员"),
     *   STUDENT("学生会员"),
     *   GUNMETAL("青铜会员"),
     *   SILVER("白银会员"),
     *   GOLD("黄金会员"),
     *   DIAMOND("钻石会员"),
     *   SPORTS("体育会员"),
     *   PLUS("plus会员");
     *
     *   private final String desc;
     * }
     *
     * {@code @Data}
     * public static class DttMember implements Serializable {
     *   private static final long serialVersionUID = 1L;
     *   private MemberType memberType = MemberType.ORDINARY;
     * }
     * </pre>
     * <p>Usage:
     * <pre>
     * ClassUtil.getEnumTypeStringValues(ClassUtil.getDeclaredField(DttMember.class, "memberType")) = ["ORDINARY","STUDENT","GUNMETAL","SILVER","GOLD","DIAMOND","SPORTS","PLUS"]
     * </pre>
     *
     * @param field Filed of Enum type
     * @return Enum  values
     */
    public static String[] getEnumTypeStringValues(Field field) {
        if (!field.getType().isEnum()) return new String[0];

        Object[] enumConstants = field.getType().getEnumConstants();
        if (ObjectUtils.isEmpty(enumConstants)) return new String[0];

        return Arrays.stream(enumConstants).map(String::valueOf).collect(Collectors.toList()).toArray(new String[enumConstants.length]);
    }


    /**
     * 获取所有公共GETTER方法
     *
     * @param aClass class 对象
     * @return all public getter methods
     */
    public static List<Method> getAllPublicGetterMethods(Class<?> aClass) {
        if (null == aClass) return Collections.emptyList();
        List<Field> fields = getAllDeclaredFields(aClass);
        List<Method> methods = Arrays.stream(aClass.getDeclaredMethods())
                .distinct().collect(Collectors.toList()).stream()
                .filter(method -> method.getName().startsWith(Constants.GET) && !method.getName().equals("getClass"))
                .collect(Collectors.toList());

        List<Method> orderConsistentMethods = new ArrayList<>();
        // keep the order of all getter methods consistent
        fields.forEach(field -> methods.forEach(method -> {
            String fieldPropertyFromMethod = StringUtils.firstToLowerCase(method.getName().substring(Constants.GET.length()));
            if (Objects.equals(field.getName(), fieldPropertyFromMethod)) {
                orderConsistentMethods.add(method);
            }
        }));

        return orderConsistentMethods;
    }


    /**
     * Get all private properties Field collection of given Class
     * <p>
     * Exclude the type of field Type in the following cases:
     * <ul>
     *     <li>isArray</li>
     *     <li>isInterface</li>
     *     <li>serialVersionUID</li>
     * </ul>
     *
     * @param aClass class对象
     * @return All private declared fields
     */
    public static List<Field> getAllDeclaredFields(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields()).collect(Collectors.toList()).stream()
                .filter(field -> !Constants.SERIAL_VERSION_UID.equals(field.getName()))
                .filter(field -> !field.getType().isInterface())
                .filter(field -> !field.getType().isArray())
                .collect(Collectors.toList());
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
     * Get declared field by class and field name
     *
     * @param fieldName the name of the field
     * @param aClass    the given class
     * @return Field
     */
    public static Field getAllDeclaredFields(Class<?> aClass, String fieldName) {
        try {
            return aClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new ParseException(e.getLocalizedMessage(), e);
        }
    }
}
