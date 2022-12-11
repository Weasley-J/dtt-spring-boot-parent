package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.dtt.DttMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * The mybatis MAPPER interface of 用户信息
 */
@Mapper
public interface DttMemberMapper extends BaseMapper<DttMember> {

}
