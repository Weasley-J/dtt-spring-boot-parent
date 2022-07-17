package com.example.util;

import cn.alphahub.dtt.plus.util.PackageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static cn.alphahub.dtt.plus.constant.Constants.BUILDER_SUFFIX;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@SpringBootTest
class PackageUtilTests {

    @Test
    void contextLoads() {
        Set<Class<?>> classes = PackageUtil.scanPackages("com.example.domain.oms");
        int i = 0;
        for (Class<?> aClass : classes) {
            if (!aClass.getSimpleName().endsWith(BUILDER_SUFFIX)) {
                i++;
                String simpleName = aClass.getSimpleName();
                System.out.println(simpleName);
            }
        }
        System.out.println(i);
    }

}
