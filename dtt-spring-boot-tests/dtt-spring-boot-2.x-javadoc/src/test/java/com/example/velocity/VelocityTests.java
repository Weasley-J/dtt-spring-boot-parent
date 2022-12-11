package com.example.velocity;

import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.core.template.DefaultTemplateResolver;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringWriter;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/11
 */
@SpringBootTest
class VelocityTests {

    @Autowired
    private VelocityEngine ve;
    @Autowired
    private DefaultTemplateResolver resolver;

    @Test
    void test() {
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");

        Template template = ve.getTemplate("foo.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);

        System.out.println("content:" + sw.toString());
    }


    @Test
    void renderTemplate() {
        VelocityContext context = new VelocityContext();
        context.put("modelName", "member");
        context.put("filedName", "id");
        context.put("primaryKey", "id");
        //渲染模板
        StringWriter writer = new StringWriter();
        Template template = ve.getTemplate(resolver.getTemplate(DatabaseType.MYSQL), "UTF-8");
        template.merge(context, writer);

        System.err.println(writer);
    }

    @Test
    void generateSqlTemplate() {
        VelocityContext context = new VelocityContext();
        context.put("modelName", "member");
        context.put("filedName", "id");
        context.put("primaryKey", "id");
        //渲染模板
        StringWriter writer = new StringWriter();
        String templateName = resolver.getTemplate(DatabaseType.MYSQL);
        Template template = ve.getTemplate(templateName, "UTF-8");
        template.merge(context, writer);

        String path = "/Users/weasley/Development/IdeaProjects/domain-to-table-spring-boot/dtt-spring-boot-starter-test/src/main/resources/";

        System.err.println(writer);

        for (DatabaseType value : DatabaseType.values()) {
            String _path = path + resolver.getTemplate(value);
            System.err.println(_path);
            IoUtil.writeUtf8(FileUtil.getOutputStream(_path), true, writer.toString());
        }
    }
}
