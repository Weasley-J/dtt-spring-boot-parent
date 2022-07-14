package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Set;

/**
 * 创建数据库建表语句上层接口
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@FunctionalInterface
public interface TableHandler<T> extends DttContext<T> {

    /**
     * create table
     *
     * @param parsedModel 数据模型解析结果
     */
    @Override
    void create(ParsedModel<T> parsedModel);

    /**
     * 批量操作
     *
     * @param modelSet 解析结果
     */
    default void bulkOps(Set<ParsedModel<T>> modelSet) {
        if (!CollectionUtils.isEmpty(modelSet)) {
            modelSet.parallelStream().forEach(this::create);
        }
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
            entity.getDetails().add(new ModelEntity.Detail().setIsPrimaryKey(true).setDatabaseDataType("bigint").setJavaDataType("Long").setFiledName("id").setFiledComment("自增主键id"));
            //Move the manually added 'id' column to the position of the first column
            Collections.swap(entity.getDetails(), 0, entity.getDetails().size() - 1);
        }
    }
}
