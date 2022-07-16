package cn.alphahub.dtt.plus.framework.core;


import cn.alphahub.dtt.plus.constant.Constants;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.util.SysUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
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
     * 将所有建表语聚合
     *
     * @param modelSet 解析结果
     * @return all tables (ALl IN ONE)
     */
    default String tableAllInOne(Set<ParsedModel<T>> modelSet) {
        if (CollectionUtils.isEmpty(modelSet))
            return null;
        List<String> tables = modelSet.parallelStream().map(this::create).collect(Collectors.toList());
        return StringUtils.join(tables, SysUtil.getLineSeparator());
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
