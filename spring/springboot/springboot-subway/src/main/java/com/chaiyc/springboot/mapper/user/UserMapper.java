package com.chaiyc.springboot.mapper.user;

import com.chaiyc.springboot.entities.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {

    User getUserById();

    @Select("select * from T_USER")
    List<User> getAllUser();

    void saveUser(User user);

    void saveUpdate(User user);

    @Delete("delete from T_USER where userAcctId=id")
    void deleteUserById(Integer id);

    /*@Select("SELECT * FROM T_USER WHERE login_Account=#{username} and login_Password=#{password}")*/
    User login(String username, String password);
}
