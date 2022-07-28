package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.datamapper.PostgresqlDataMapperProperties;
import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * postgresql默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultPostgresqlTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultPostgresqlTableHandler.class);

    @Autowired
    private PostgresqlDataMapperProperties postgresqlDataMapperProperties;


    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用postgresql默认建表实现 {}", JacksonUtil.toJson(model));

        if (null == model || CollectionUtils.isEmpty(model.getDetails())) {
            logger.error("Model cannot be null or empty");
            return null;
        }

        Properties mappingProperties = postgresqlDataMapperProperties.getMappingProperties();
        model.getDetails().forEach(detail -> {
            if (Objects.equals(Enum.class.getSimpleName(), detail.getJavaDataType())) {
                String actuallyDbDataType = SpringUtil.getBean(ContextWrapper.class).getCommentParser().deduceDbDataTypeWithLength(detail.getFiledName());
                handlingEnumerationTypeToString(mappingProperties, detail, actuallyDbDataType);
            }
            if (detail.getFiledComment().startsWith("\\'") || detail.getFiledComment().endsWith("\\'")) {
                detail.setFiledComment(detail.getFiledComment().replace("\\'", ""));
            }
            if (detail.getFiledComment().contains(";")) {
                detail.setFiledComment(detail.getFiledComment().replace(";", "；"));
            }
        });

        String databaseName = model.getDatabaseName();
        if (StringUtils.isNoneBlank(databaseName)) model.setDatabaseName("\"" + databaseName + "\"" + ".");

        String template = resolve(() -> model);

        List<String> dirtySqlList = Arrays.stream(StringUtils.split(template, ";")).collect(Collectors.toList());
        String[] pureSqlArray = dirtySqlList.stream().map(dirtySql -> {
            if (!dirtySql.startsWith("\n") && StringUtils.isNoneBlank(dirtySql)) return dirtySql;
            if (dirtySql.startsWith("\n")) return dirtySql.replace("\n", "");
            return "";
        }).filter(StringUtils::isNoneBlank).toArray(String[]::new);

        for (int i = 1; i <= CREATE_TABLE_RETRY_MAX_COUNT; i++) {
            boolean success;
            try {
                batchExecute(pureSqlArray);
                success = true;
            } catch (DataAccessException e) {
                if (logger.isWarnEnabled()) logger.warn("{}", e.getLocalizedMessage(), e);
                success = false;
            }
            if (success) break;
        }

        return template;
    }
}
