package com.chaiyc.springboot.mapper;

import com.chaiyc.springboot.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:15
 * @description: TODO
 */
@Mapper
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);
}

