package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.DerbyDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * The default table creation implementation of DERBY database
 * <p>
 * <ul>
 *     <li><a href="https://db.apache.org/derby/docs/10.16/ref/refderby.pdf">Jump to derby official documents</a></li>
 *     <li><a href="https://issues.apache.org/jira/browse/DERBY-7008">Does Derby support table and column comments?</a></li>
 * </ul>
 *
 * @author weasley
 * @version 1.3.5
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultDerbyTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApplicationContext applicationContext;
    private final DerbyDataMapperProperties derbyDataMapperProperties;

    public DefaultDerbyTableHandler(ApplicationContext applicationContext, DerbyDataMapperProperties derbyDataMapperProperties) {
        this.applicationContext = applicationContext;
        this.derbyDataMapperProperties = derbyDataMapperProperties;
    }

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用DERBY默认建表实现:{}", JacksonUtil.toJson(model));
        if (null == model || ObjectUtils.isEmpty(model.getDetails())) {
            logger.warn("DERBY的表结构元数据解析结果不能为空 {}", model);
            return null;
        }

        deduceDecimalPrecision(model);
        handlePropertiesOfModel(() -> model, applicationContext.getBean(ContextWrapper.class));

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) model.setDatabaseName("\"" + databaseName + "\".");

        if (derbyDataMapperProperties.getEnableColumnUpperCase().equals(true)) modelPropertiesToUppercase(() -> model);

        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));

        String template = resolve(() -> model, new VelocityContext());
        String[] pureSQLScripts = parseTemplateToPureSQLScripts(template.split(";"));
        for (String sql : pureSQLScripts) {
            boolean success = false;
            for (int i = 0; i < CREATE_TABLE_RETRY_MAX_COUNT; i++) {
                if (success) break;
                try {
                    execute(sql);
                    success = true;
                } catch (Exception e) {
                    if (logger.isWarnEnabled()) logger.warn("{}", e.getMessage());
                }
            }
        }
        return template;
    }

    @Override
    public void handlePropertiesOfModel(ParseFactory<ModelEntity> parseFactory, ContextWrapper contextWrapper) {
        parseFactory.getModel().getDetails().forEach(detail -> {
            if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'"))
                detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
            if (detail.getFiledComment().contains(";"))
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
            if (Objects.equals(Enum.class.getSimpleName(), detail.getJavaDataType())) {
                String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handleEnumerationTypeToString(derbyDataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
            }
        });
    }
}
