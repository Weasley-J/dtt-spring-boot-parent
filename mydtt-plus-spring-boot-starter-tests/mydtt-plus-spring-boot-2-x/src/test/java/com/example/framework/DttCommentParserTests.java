package com.example.framework;

import cn.alphahub.dtt.plus.framework.core.DefaultAnnotationParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/19
 */
@SpringBootTest
public class DttCommentParserTests {

    @Autowired
    DefaultAnnotationParser commentParser;

    @Test
    void contextLoads() {
    }

}
