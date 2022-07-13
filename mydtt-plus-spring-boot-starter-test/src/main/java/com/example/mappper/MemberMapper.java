package com.example.mappper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.dtt.DttMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * 输入类描述
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/12
 */
@Mapper
public interface MemberMapper extends BaseMapper<DttMember> {
}
