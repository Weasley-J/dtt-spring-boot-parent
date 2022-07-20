package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * mariadb默认建表实现
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultPostgresqlTableHandler implements DttTableHandler<ModelEntity> {
    private static final Logger logger = LoggerFactory.getLogger(DefaultPostgresqlTableHandler.class);

    @Autowired
    private DefaultTemplateExecutor defaultTemplateExecutor;
    @Autowired
    private DefaultTemplateResolver defaultTemplateResolver;

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        if (logger.isInfoEnabled()) logger.info("使用mariadb默认建表实现 {}", JacksonUtil.toJson(parseFactory.getModel()));
        // TODO document why this method is empty
        return null;
    }
}
