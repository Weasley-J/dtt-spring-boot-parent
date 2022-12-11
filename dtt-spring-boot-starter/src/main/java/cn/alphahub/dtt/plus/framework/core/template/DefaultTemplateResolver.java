package cn.alphahub.dtt.plus.framework.core.template;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.framework.InitDttHandler;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DttTemplateHandler;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static cn.alphahub.dtt.plus.config.DttProperties.TemplateProperties;

/**
 * Dtt Resolver
 * <p>
 * To resolve DTT template
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/20
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@EnableConfigurationProperties({TemplateProperties.class, DttProperties.class})
public class DefaultTemplateResolver implements DttTemplateHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultTemplateResolver.class);
    @Autowired
    private DttProperties dttProperties;
    @Autowired
    private VelocityEngine velocityEngine;
    @Autowired
    private DatabaseHandler databaseHandler;
    @Autowired
    private TemplateProperties templateProperties;

    @Override
    public String resolve(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        VelocityContext context = new VelocityContext();
        handlePrimaryKey(model, context);
        StringWriter writer = processTemplate(context, model);
        return writer.toString();
    }

    @Override
    public String resolve(ParseFactory<ModelEntity> parseFactory, VelocityContext context) {
        ModelEntity model = parseFactory.getModel();
        handlePrimaryKey(model, context);
        StringWriter writer = processTemplate(context, model);
        return writer.toString();
    }

    /**
     * Process templates
     *
     * @param context The context of Velocity
     * @param model   The model
     * @return The 'StringWriter' of template
     */
    protected StringWriter processTemplate(VelocityContext context, ModelEntity model) {
        context.put("dropTableBeforeCreate", InitDttHandler.getEnableDtt().dropTableBeforeCreate());
        context.put("databaseName", model.getDatabaseName());
        context.put("modelName", model.getModelName());
        context.put("modelComment", model.getModelComment());
        context.put("details", model.getDetails());
        StringWriter writer = new StringWriter();
        Template template = velocityEngine.getTemplate(getTemplate(), StandardCharsets.UTF_8.name());
        template.merge(context, writer);
        if (logger.isDebugEnabled() || dttProperties.getShowSql().equals(true)) {
            logger.info("数据库建表语句: \n{}", writer);
        }
        return writer;
    }

    /**
     * Get the corresponding table creation template from the database type(Automatically infer DB type)
     *
     * @return Return the template file, such as: mysql.vm
     */
    public String getTemplate() {
        String dbTypeLowerCase = databaseHandler.getDbType().name().toLowerCase();
        String templateName = getTemplateName(dbTypeLowerCase);
        return templateProperties.getPath() + "/" + dbTypeLowerCase + "/" + templateName + templateProperties.getSuffix();
    }

    /**
     * Get the corresponding table creation template from the database type
     *
     * @param databaseType database type
     * @return Return the template file, such as: mysql.vm
     */
    public String getTemplate(DatabaseType databaseType) {
        String dbTypeLowerCase = databaseType.name().toLowerCase();
        String templateName = getTemplateName(dbTypeLowerCase);
        return templateProperties.getPath() + "/" + dbTypeLowerCase + "/" + templateName + templateProperties.getSuffix();
    }

    /**
     * Get template name
     *
     * @param filename template file name
     * @return template name
     * @since 1.0.4
     */
    public String getTemplateName(String filename) {
        //TODO Multi-version template file name control logic
        return filename;
    }
}
