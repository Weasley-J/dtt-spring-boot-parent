package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.dtt.DttMember;
import com.example.mapper.DttMemberMapper;
import org.springframework.stereotype.Service;

/**
 * The service handle class of 用户信息
 */
@Service
public class DttMemberService extends ServiceImpl<DttMemberMapper, DttMember> implements IService<DttMember> {

}
