package com.example.mapper.dtt;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.dtt.DttMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberPlusMapper extends BaseMapper<DttMember> {

}
