package com.chaiyc.springboot.service.impl;

import com.chaiyc.springboot.entity.SysRole;
import com.chaiyc.springboot.mapper.SysRoleMapper;
import com.chaiyc.springboot.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:24
 * @description: TODO
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public SysRole selectById(Integer id) {
        return sysRoleMapper.selectById(id);
    }
}
