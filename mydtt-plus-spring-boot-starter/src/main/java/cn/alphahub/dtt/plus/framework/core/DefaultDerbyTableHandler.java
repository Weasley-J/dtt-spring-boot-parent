package cn.alphahub.dtt.plus.framework.core;

import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * The default table creation implementation of DERBY database
 *
 * @author weasley
 * @version 1.3.5
 */
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
public class DefaultDerbyTableHandler extends DttAggregationRunner implements DttTableHandler<ModelEntity> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String create(ParseFactory<ModelEntity> parseFactory) {
        ModelEntity model = parseFactory.getModel();
        if (logger.isInfoEnabled()) logger.info("使用DERBY默认建表实现:{}", JacksonUtil.toJson(model));
        if (null == model || ObjectUtils.isEmpty(model.getDetails())) {
            logger.warn("DERBY的表结构元数据解析结果不能为空 {}", model);
            return null;
        }
        deduceDecimalPrecision(model);

        // TODO: DERBY logic

        return null;
    }

}
