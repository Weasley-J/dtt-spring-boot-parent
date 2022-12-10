package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.dtt.DttPerson;
import com.example.mapper.DttPersonMapper;
import org.springframework.stereotype.Service;

/**
 * The service handle class of DttPerson
 */
@Service
public class DttPersonService extends ServiceImpl<DttPersonMapper, DttPerson> implements IService<DttPerson> {

}
