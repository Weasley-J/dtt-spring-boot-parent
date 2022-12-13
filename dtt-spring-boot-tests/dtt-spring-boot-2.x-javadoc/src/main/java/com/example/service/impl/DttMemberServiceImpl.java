package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.dtt.DttMember;
import com.example.mapper.DttMemberMapper;
import com.example.service.DttMemberService;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service实现
 */
@Service
public class DttMemberServiceImpl extends ServiceImpl<DttMemberMapper, DttMember> implements DttMemberService {

}
