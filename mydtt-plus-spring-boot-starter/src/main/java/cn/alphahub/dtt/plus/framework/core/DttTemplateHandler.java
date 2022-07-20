package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

import java.util.Collections;

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
     * Execute table statement
     *
     * @param table table statement
     */
    default void execute(String table) {
    }

    /**
     * Handling primary key
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
            switch (DatabaseType.getDbType()) {
                case MYSQL:
                    detail.setDatabaseDataType("bigint");
                    break;
                case ORACLE:
                    detail.setDatabaseDataType("ORACLE");
                    break;
                case DB2:
                    detail.setDatabaseDataType("DB2");
                    break;
                case SQLSERVER:
                    detail.setDatabaseDataType("SQLSERVER");
                    break;
                case MARIADB:
                    detail.setDatabaseDataType("MARIADB");
                    break;
                case POSTGRESQL:
                    detail.setDatabaseDataType("POSTGRESQL");
                    break;
                default:
                    break;
            }
            model.getDetails().add(detail);
            //Move the manually added 'id' column to the position of the first column
            Collections.swap(model.getDetails(), 0, model.getDetails().size() - 1);
        }
    }
}
