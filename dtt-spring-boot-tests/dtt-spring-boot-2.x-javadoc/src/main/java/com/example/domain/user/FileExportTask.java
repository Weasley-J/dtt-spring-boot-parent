package com.example.domain.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件导出历史
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FileExportTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件id
     */
    private String fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件下载地址
     */
    private String fileDownloadUrl;

    /**
     * 文件长度
     */
    private Long fileLength;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件来源 1,订单列表 2,退款列表
     */
    private Integer fileSource;

    /**
     * 状态:0 处理中 1 处理完成 2 处理错误
     */
    private Integer fileStatus;

    /**
     * 错误
     */
    private String fileErrorMsg;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
