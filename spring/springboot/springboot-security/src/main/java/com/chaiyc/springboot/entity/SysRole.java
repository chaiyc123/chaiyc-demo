package com.chaiyc.springboot.entity;

import java.io.Serializable;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:11
 * @description: TODO
 */
public class SysRole implements Serializable {

    private Integer id;

    private String name;

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
}
