package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.enums.DatabaseType;
import cn.alphahub.dtt.plus.util.SysUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 创建数据库建表语句上层接口
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface DttTableHandler<T> extends DttContext<T> {

    /**
     * create table
     *
     * @param parsedModel 数据模型解析结果
     * @return table statement
     */
    @Override
    String create(ParsedModel<T> parsedModel);

    /**
     * 批量操作所有建表语语句聚合
     *
     * @param modelSet 解析结果
     * @return all tables (ALl IN ONE)
     */
    default String bulkOps(Set<ParsedModel<T>> modelSet) {
        if (CollectionUtils.isEmpty(modelSet)) {
            return null;
        }
        return StringUtils.join(modelSet.parallelStream().map(this::create).collect(Collectors.toList()), SysUtil.getLineSeparator());
    }

    /**
     * 处理主键
     *
     * @param entity  model entity
     * @param context velocity context
     */
    default void handlePrimaryKey(ModelEntity entity, VelocityContext context) {
        for (ModelEntity.Detail detail : entity.getDetails()) {
            if (Boolean.TRUE.equals(detail.getIsPrimaryKey())) {
                context.put(Constants.PRIMARY_KEY_MARK, detail.getFiledName());
                break;
            }
        }
        if (null == context.get(Constants.PRIMARY_KEY_MARK)
                || StringUtils.isBlank(context.get(Constants.PRIMARY_KEY_MARK).toString())) {
            context.put(Constants.PRIMARY_KEY_MARK, "id");
            ModelEntity.Detail filedComment = new ModelEntity.Detail()
                    .setFiledName("id")
                    .setIsPrimaryKey(true)
                    .setFiledComment("自增主键id")
                    .setJavaDataType("Long");
            switch (DatabaseType.getDbType()) {
                case MYSQL:
                    filedComment.setDatabaseDataType("bigint");
                    break;
                //TODO 调整主键类型
                case ORACLE:
                    filedComment.setDatabaseDataType("ORACLE");
                    break;
                //TODO 调整主键类型
                case DB2:
                    filedComment.setDatabaseDataType("DB2");
                    break;
                //TODO 调整主键类型
                case SQLSERVER:
                    filedComment.setDatabaseDataType("SQLSERVER");
                    break;
                //TODO 调整主键类型
                case MARIADB:
                    filedComment.setDatabaseDataType("MARIADB");
                    break;
                //TODO 调整主键类型
                case POSTGRESQL:
                    filedComment.setDatabaseDataType("POSTGRESQL");
                    break;
                default:
                    break;
            }
            entity.getDetails().add(filedComment);
            //Move the manually added 'id' column to the position of the first column
            Collections.swap(entity.getDetails(), 0, entity.getDetails().size() - 1);
        }
    }
}
