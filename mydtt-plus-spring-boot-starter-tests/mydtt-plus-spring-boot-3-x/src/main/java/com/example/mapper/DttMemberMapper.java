package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.dtt.DttMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * The mybatis mapper interface of 用户信息-DttMember
 */
@Mapper
public interface DttMemberMapper extends BaseMapper<DttMember> {

}
