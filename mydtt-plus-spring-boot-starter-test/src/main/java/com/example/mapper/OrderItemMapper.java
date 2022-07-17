package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
