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
        //String ofStringType = commentParser.deduceLengthOfStringType("user_tel", "varchar");
        //System.err.println("ofStringType = " + ofStringType);

        //ofStringType = commentParser.deduceLengthOfStringType("user_msg", "varchar");
        //System.err.println("ofStringType = " + ofStringType);

        //ofStringType = commentParser.deduceLengthOfStringType("user_request", "varchar");
        //System.err.println("ofStringType = " + ofStringType);

        String ofStringType2 = commentParser.deduceLengthOfStringType("deduce_data_type_of_database", "varchar");
        System.err.println("ofStringType2 = " + ofStringType2);
    }

}
