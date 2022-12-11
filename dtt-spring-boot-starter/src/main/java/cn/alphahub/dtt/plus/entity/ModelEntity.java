package cn.alphahub.dtt.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 域模型信息
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ModelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 数据库名称
     */
    private String databaseName;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 模型描述
     */
    private String modelComment;

    /**
     * 模型元数据细节
     */
    private List<Detail> details;

    /**
     * model metadata detail
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Detail implements Serializable {
        private static final long serialVersionUID = 1L;
        /**
         * 是否是主键
         */
        private Boolean isPrimaryKey = Boolean.FALSE;
        /**
         * 数据库数据类型
         */
        private String databaseDataType;
        /**
         * Java数据类型
         */
        private String javaDataType;
        /**
         * 字段名
         */
        private String filedName;
        /**
         * 字段注释
         */
        private String filedComment;
        /**
         * 初始值
         */
        private String initialValue;

    }
}
