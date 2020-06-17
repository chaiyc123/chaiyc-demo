package com.chaiyc.springboot.mapper;

import com.chaiyc.springboot.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 14:16
 * @description: TODO
 */
@Mapper
public interface SysUserRoleMapper {
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
}
