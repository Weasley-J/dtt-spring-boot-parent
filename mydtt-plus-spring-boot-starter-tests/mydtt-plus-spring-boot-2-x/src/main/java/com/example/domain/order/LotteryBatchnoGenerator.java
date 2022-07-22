package com.example.domain.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 年会抽奖批次号生成
 * </p>
 *
 * @author Mybatis Plus Generator
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LotteryBatchnoGenerator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;


}
