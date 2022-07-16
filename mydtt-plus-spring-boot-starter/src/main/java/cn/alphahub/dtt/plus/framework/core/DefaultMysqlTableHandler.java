package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.VelocityHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * mysql默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultMysqlTableHandler extends DttTableRunner implements DttTableHandler<ModelEntity> {
    /**
     * 数据表DDL集合
     */
    public static final List<String> TABLES = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(DefaultMysqlTableHandler.class);
    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * create table
     *
     * @param parsedModel 数据模型解析结果
     */
    @Override
    public String create(ParsedModel<ModelEntity> parsedModel) {
        logger.info("使用mysql默认建表实现 {}", JacksonUtil.toJson(parsedModel));
        ModelEntity entity = parsedModel.getModel();
        if (null == entity || CollectionUtils.isEmpty(entity.getDetails())) {
            logger.warn("表结构元数据解析结果不能为空 {}", JacksonUtil.toJson(parsedModel));
            return null;
        }
        if (logger.isInfoEnabled()) {
            logger.info("组建建表语句, 模型: {}", JacksonUtil.toJson(entity));
        }
        VelocityContext context = new VelocityContext();
        // 处理主键
        handlePrimaryKey(entity, context);

        context.put("dropTableBeforeCreate", InitDttHandler.getEnableDtt().dropTableBeforeCreate());
        context.put("modelName", entity.getModelName());
        context.put("modelComment", entity.getModelComment());
        context.put("details", entity.getDetails());
        // 渲染模型数据
        StringWriter writer = new StringWriter();
        Template template = velocityEngine.getTemplate(VelocityHandler.getTemplate(DatabaseType.MYSQL), StandardCharsets.UTF_8.name());
        template.merge(context, writer);

        // 运行创建 DDL 语句
        super.execute(writer.toString());

        return writer.toString();
    }

}
