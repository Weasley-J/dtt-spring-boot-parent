package cn.alphahub.dtt.plus.framework.core.reflect;

import java.io.Serializable;
import java.util.function.Function;

/**
 * java实体类方法名获取属性名属性可序列化函数接口
 *
 * @author liuwenjing
 */
@FunctionalInterface
public interface FieldFunction<T, R> extends Function<T, R>, Serializable {

}
