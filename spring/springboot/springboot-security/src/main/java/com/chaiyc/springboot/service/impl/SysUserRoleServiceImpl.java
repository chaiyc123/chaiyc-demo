package com.chaiyc.springboot.service.impl;

import com.chaiyc.springboot.entity.SysUserRole;
import com.chaiyc.springboot.mapper.SysUserRoleMapper;
import com.chaiyc.springboot.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:24
 * @description: TODO
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUserRole> listByUserId(Integer userId) {
        return sysUserRoleMapper.listByUserId(userId);
    }
}
