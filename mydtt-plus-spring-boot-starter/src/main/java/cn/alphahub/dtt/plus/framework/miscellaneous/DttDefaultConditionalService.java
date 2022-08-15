package cn.alphahub.dtt.plus.framework.miscellaneous;

import cn.alphahub.dtt.plus.entity.ContextWrapper;
import cn.alphahub.dtt.plus.entity.DttManualActEntity;
import cn.alphahub.dtt.plus.entity.DttManualActRequest;
import cn.alphahub.dtt.plus.entity.ModelEntity;
import cn.alphahub.dtt.plus.framework.InitDttClient;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.core.DefaultAnnotationParser;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.ParseFactory;
import cn.alphahub.dtt.plus.util.ClassUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manually specify the fully qualified class name to call DTT to create a table.
 * <p>Maybe useful in some condition.
 *
 * @author weasley
 * @version 1.3.1
 */
@Data
@Component
@ConditionalOnBean(annotation = {EnableDtt.class})
@AutoConfigureAfter({InitDttClient.class, ContextWrapper.class})
public class DttDefaultConditionalService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApplicationContext applicationContext;

    public DttDefaultConditionalService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Manually specify a collection of fully qualified Class names to create database tables
     *
     * @param request The request data for dtt manual automatically create database tables
     * @return The list of 'DttManualActEntity'
     */
    public List<DttManualActEntity> manualCreate(DttManualActRequest request) {
        if (CollectionUtils.isEmpty(request.getFullyQualifiedClassNames())) {
            logger.warn("'fullyQualifiedClassNames' must be not empty.");
            return Collections.emptyList();
        }

        DttCommentParser<ModelEntity> dttCommentParser;
        URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        ContextWrapper contextWrapper = applicationContext.getBean(ContextWrapper.class);
        if (ObjectUtils.isNull(contextWrapper)) {
            logger.warn("'cn.alphahub.dtt.plus.entity.ContextWrapper' must be not null.");
            return Collections.emptyList();
        }
        // if APP run with type of Jar environment dtt Comment Parser takes Default Annotation Parser
        if (ResourceUtils.isJarURL(location))
            dttCommentParser = applicationContext.getBean(DefaultAnnotationParser.class);
        else dttCommentParser = contextWrapper.getCommentParser();

        List<Class<?>> classes = new ArrayList<>();
        for (String classFullyQualifyName : request.getFullyQualifiedClassNames()) {
            try {
                Class<?> aClass = ClassUtil.loadClass(classFullyQualifyName);
                classes.add(aClass);
            } catch (Exception e) {
                if (logger.isErrorEnabled()) {
                    logger.error("{}", e.getLocalizedMessage(), e);
                }
            }
        }

        List<DttManualActEntity> dttManualActEntities = new ArrayList<>();
        for (Class<?> aClass : classes) {
            ParseFactory<ModelEntity> parseFactory = dttCommentParser.parse(aClass.getName());
            if (null != parseFactory.getModel() && CollectionUtils.isNotEmpty(parseFactory.getModel().getDetails())) {
                String tableStatement = contextWrapper.getTableHandler().create(parseFactory);
                dttManualActEntities.add(new DttManualActEntity(aClass.getName(), tableStatement));
            }
        }

        return dttManualActEntities;
    }
}
