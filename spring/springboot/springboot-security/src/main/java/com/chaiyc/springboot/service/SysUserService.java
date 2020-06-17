package com.chaiyc.springboot.service;

import com.chaiyc.springboot.entity.SysUser;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:22
 * @description: TODO
 */
public interface SysUserService {

    public SysUser selectById(Integer id);

    public SysUser selectByName(String name);

}
