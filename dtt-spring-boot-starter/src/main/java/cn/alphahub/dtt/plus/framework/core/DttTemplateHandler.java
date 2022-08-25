package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

import java.util.Collections;
import java.util.Map;

import static cn.alphahub.dtt.plus.constant.Constants.PRIMARY_KEY_MARK;
import static cn.alphahub.dtt.plus.entity.ModelEntity.Detail;

/**
 * Dtt Runner
 * <ul>
 *     <li>Resolve Templates</li>
 *     <li>Execute Statements</li>
 * </ul>
 * 模版处理器
 *
 * @author weasley
 * @version 1.1.0
 */
public interface DttTemplateHandler<T> extends DttContext<T> {
    /**
     * Resolve template
     *
     * @param parseFactory The analysis results  of model
     * @return table statement
     */
    default String resolve(ParseFactory<T> parseFactory) {
        return null;
    }

    /**
     * Resolve template
     *
     * @param parseFactory The factory of parsed object
     * @param context      The context of Velocity
     * @return table statement
     */
    default String resolve(ParseFactory<ModelEntity> parseFactory, VelocityContext context) {
        return null;
    }

    /**
     * Execute table statement
     *
     * @param table table statement
     */
    default void execute(String table) {
    }

    /**
     * Handle the primary key
     *
     * @param model   model
     * @param context velocity context
     */
    default void handlePrimaryKey(ModelEntity model, VelocityContext context) {
        for (Detail detail : model.getDetails()) {
            if (Boolean.TRUE.equals(detail.getIsPrimaryKey())) {
                context.put(PRIMARY_KEY_MARK, detail.getFiledName());
                if (StringUtils.isBlank(detail.getFiledComment())) {
                    detail.setFiledComment("主键id");
                }
                break;
            }
        }
        if (null == context.get(PRIMARY_KEY_MARK) || StringUtils.isBlank(context.get(PRIMARY_KEY_MARK).toString())) {
            context.put(PRIMARY_KEY_MARK, "id");
            Detail detail = new Detail().setFiledName("id").setIsPrimaryKey(true).setFiledComment("自增主键id").setJavaDataType("Long");
            DatabaseType inferDatabaseType = SpringUtil.getBean(DatabaseHandler.class).getDbType();
            Map<DatabaseType, String> primaryKeyMapper = SpringUtil.getBean(DttProperties.class).getPrimaryKeyMapper();
            primaryKeyMapper.forEach((dbType, dataType) -> {
                if (inferDatabaseType == dbType) {
                    detail.setDatabaseDataType(dataType);
                }
            });
            model.getDetails().add(detail);
            //Move the manually added 'id' column to the position of the first column
            Collections.swap(model.getDetails(), 0, model.getDetails().size() - 1);
        }
    }
}
