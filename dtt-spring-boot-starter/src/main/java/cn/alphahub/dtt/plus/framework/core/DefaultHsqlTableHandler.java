package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.HsqlDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The default table creation implementation of HSQL
 * <p>
 * <ul>
 *      <li><a href="http://hsqldb.org/doc/2.0/guide/databaseobjects-chapt.html#dbc_commenting">Schemas and Database Objects</a></li>
 *      <li><a href="http://hsqldb.org/web/hsqlDocsFrame.html">HyperSQL version 2.7 Documentation</a></li>
 *      <li><a href="http://hsqldb.org/web/features200.html">How to</a></li>
 *      <li><a href="http://hsqldb.org/web/features200.html">New Features in HyperSQL 2.6.1</a></li>
 * </ul>
 *
 * @author weasley
 * @version 1.3.5
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultHsqlTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ApplicationContext applicationContext;
    private final HsqlDataMapperProperties hsqlDataMapperProperties;

    public DefaultHsqlTableHandler(ApplicationContext applicationContext, HsqlDataMapperProperties hsqlDataMapperProperties) {
        this.applicationContext = applicationContext;
        this.hsqlDataMapperProperties = hsqlDataMapperProperties;
    }

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用HSQL默认建表实现:{}", JacksonUtil.toJson(model));
        if (null == model || ObjectUtils.isEmpty(model.getDetails())) {
            logger.warn("HSQL的表结构元数据解析结果不能为空 {}", model);
            return null;
        }
        if (StringUtils.isNotBlank(model.getDatabaseName())) {
            model.setDatabaseName("\"" + model.getDatabaseName() + "\".");
        }
        ContextWrapper contextWrapper = applicationContext.getBean(ContextWrapper.class);
        deduceDecimalPrecision(model);
        handlePropertiesOfModel(() -> model, contextWrapper);
        if (hsqlDataMapperProperties.getEnableColumnUpperCase().equals(true)) modelPropertiesToUppercase(() -> model);
        if (logger.isInfoEnabled()) logger.info("正在组建建表语句，模型数据: {}", JacksonUtil.toJson(model));
        String template = resolve(() -> model);
        execute(template);
        return template;
    }

    @Override
    public void handlePropertiesOfModel(ParseFactory<ModelEntity> parseFactory, ContextWrapper contextWrapper) {
        ModelEntity model = parseFactory.getModel();
        List<ModelEntity.Detail> details = model.getDetails();
        if (ObjectUtils.isNotEmpty(details)) {
            for (ModelEntity.Detail detail : details) {
                processInitialValue(detail);
                if (Enum.class.getSimpleName().compareToIgnoreCase(detail.getJavaDataType()) == 0) {
                    String actuallyDbDataType = contextWrapper.getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                    handleEnumerationTypeToString(hsqlDataMapperProperties.getMappingProperties(), detail, actuallyDbDataType);
                }
                if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'"))
                    detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
                if (detail.getFiledComment().contains(";"))
                    detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
            }
        }
    }
}
