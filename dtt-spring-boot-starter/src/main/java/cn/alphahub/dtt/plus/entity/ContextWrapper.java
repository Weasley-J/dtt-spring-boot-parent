package cn.alphahub.dtt.plus.entity;

import cn.alphahub.dtt.plus.config.DttProperties;
import cn.alphahub.dtt.plus.framework.DatabaseHandler;
import cn.alphahub.dtt.plus.framework.core.DttCommentParser;
import cn.alphahub.dtt.plus.framework.core.DttTableHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper;
import static cn.alphahub.dtt.plus.config.DttProperties.HighPrecisionDataMapper.PrecisionConfigurationProperties;
import static cn.alphahub.dtt.plus.config.DttProperties.StringLengthMapper;

/**
 * DTT上下文信息包装类
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ContextWrapper implements Serializable {
    /**
     * Uptime statistics
     */
    private DttRunDetail dttRunDetail;
    /**
     * The config properties for dtt
     */
    private DttProperties dttProperties;
    /**
     * Database handler
     */
    private DatabaseHandler databaseHandler;
    /**
     * DTT work thread
     */
    private AtomicReference<Thread> threadReference;
    private transient DttCommentParser<ModelEntity> commentParser;
    private transient DttTableHandler<ModelEntity> tableHandler;
    /**
     * text length handler
     */
    private TextLengthHandler textLengthHandler;
    private HighPrecisionDataHandler highPrecisionDataHandler;

    /**
     * 运行时间
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DttRunDetail implements Serializable {
        /**
         * 开始时间
         */
        private LocalDateTime dttStartTime;
        /**
         * 结束时间
         */
        private LocalDateTime dttEndTime;

        public DttRunDetail(LocalDateTime dttStartTime) {
            this.dttStartTime = dttStartTime;
        }
    }

    /**
     * Text length handler
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextLengthHandler implements Serializable {
        /**
         * String length mapper
         */
        private transient StringLengthMapper stringLengthMapper;
        /**
         * key: _id,_no,number,name,code,_code,_name
         * <br>
         * value: 128
         */
        private Map<String, Integer> textLengthProperties;
    }

    /**
     * High precision data  handler
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HighPrecisionDataHandler implements Serializable {
        /**
         * High precision data mapper
         */
        private HighPrecisionDataMapper highPrecisionDataMapper;
        /**
         * key: Some text of column
         * <br>
         * value: The precision configuration properties
         */
        private Map<String, PrecisionConfigurationProperties> highPrecisionDataConfigMap;
    }
}
