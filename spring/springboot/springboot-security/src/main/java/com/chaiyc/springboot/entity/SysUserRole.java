package com.chaiyc.springboot.entity;

import java.io.Serializable;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:12
 * @description: TODO
 */
public class SysUserRole implements Serializable {

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
