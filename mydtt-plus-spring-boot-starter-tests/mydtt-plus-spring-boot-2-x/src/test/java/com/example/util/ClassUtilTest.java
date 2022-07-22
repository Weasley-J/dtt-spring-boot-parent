package com.example.util;

import cn.alphahub.dtt.plus.framework.reflect.ReflectionUtil;
import cn.alphahub.dtt.plus.util.ClassUtil;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.dtt.DttMember;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassUtil Test
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/17
 */
class ClassUtilTest {


    @Test
    void contextLoads() {
        Field memberType = ClassUtil.getAllDeclaredFields(DttMember.class, "memberType");
        String[] enumTypeStringValues = ClassUtil.getEnumTypeStringValues(memberType);
        System.out.println(JacksonUtil.toJson(enumTypeStringValues));
    }


    @Test
    void contextLoads2() {
        List<Method> methods = ClassUtil.getAllPublicGetterMethods(DttMember.class);
        methods.forEach(method -> {
            System.out.println(ReflectionUtil.methodNameToProperty(method.getName()) + " <---> " + ReflectionUtil.methodNameToUnderline(method.getName()));
        });
    }


}
