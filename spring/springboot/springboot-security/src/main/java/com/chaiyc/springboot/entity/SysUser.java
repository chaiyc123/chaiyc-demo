package com.chaiyc.springboot.entity;

import java.io.Serializable;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:07
 * @description: TODO
 */
public class SysUser implements Serializable {

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
