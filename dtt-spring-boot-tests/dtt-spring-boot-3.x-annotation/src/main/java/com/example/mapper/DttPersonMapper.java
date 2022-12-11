package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.dtt.DttPerson;
import org.apache.ibatis.annotations.Mapper;

/**
 * The mybatis MAPPER interface of 用户信息-DttPerson
 */
@Mapper
public interface DttPersonMapper extends BaseMapper<DttPerson> {

}
