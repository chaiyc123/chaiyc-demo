package com.chaiyc.springboot.service;

import com.chaiyc.springboot.entity.SysUserRole;

import java.util.List;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:23
 * @description: TODO
 */
public interface SysUserRoleService {
    List<SysUserRole> listByUserId(Integer userId);
}
