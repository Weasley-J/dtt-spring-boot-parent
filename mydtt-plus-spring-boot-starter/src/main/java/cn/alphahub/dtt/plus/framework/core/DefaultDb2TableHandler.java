package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * DB2默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultDb2TableHandler extends DttTableRunner implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDb2TableHandler.class);

    @Override
    public String create(ParsedModel<ModelEntity> parsedModel) {
        if (logger.isInfoEnabled()) logger.info("使用DB2默认建表实现 {}", JacksonUtil.toJson(parsedModel.getModel()));

        // TODO document why this method is empty
        return null;
    }
}
