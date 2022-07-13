package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.core.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * sqlserver默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultSqlserverTableHandler extends DttRunner implements TableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultSqlserverTableHandler.class);

    @Override
    public void create(ParsedModel<ModelEntity> parsedModel) {
        logger.info("使用sqlserver默认建表实现 {}", JacksonUtil.toJson(parsedModel));
        // TODO document why this method is empty
    }
}
