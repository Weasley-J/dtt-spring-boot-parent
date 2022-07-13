package com.example.domain.payment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 成本关系明细
 * </p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CostRelationDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 成本关系表id
     */
    private Integer costRelationId;

    /**
     * 成本部门id
     */
    private Integer costDepartmentId;

    /**
     * 业务单元id
     */
    private Integer costBusinessUnitId;

    /**
     * 是否删除 0:未删除   1:删除
     */
    private Integer deleted;


}
