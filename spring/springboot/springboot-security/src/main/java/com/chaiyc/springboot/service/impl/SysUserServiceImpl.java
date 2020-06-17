package com.chaiyc.springboot.service.impl;

import com.chaiyc.springboot.entity.SysUser;
import com.chaiyc.springboot.mapper.SysUserMapper;
import com.chaiyc.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:23
 * @description: TODO
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public SysUser selectByName(String name) {
        return sysUserMapper.selectByName(name);
    }
}
