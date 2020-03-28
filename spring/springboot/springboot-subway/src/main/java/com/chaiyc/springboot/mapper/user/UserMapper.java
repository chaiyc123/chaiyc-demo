package com.chaiyc.springboot.mapper.user;

import com.chaiyc.springboot.entities.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper  启动类中配置了自动扫描
public interface UserMapper {

    @Select("select * from T_USER where USER_ACCT_ID = #{dataId}")
    User getUserById(String dataId);

    @Select("select * from T_USER")
    List<User> getAllUser();

    /**
     * 分页查询
     * @return
     */
    List<User> getPageUser();


    void saveUser(User user);

    void saveUpdate(User user);

    @Delete("delete from T_USER where USER_ACCT_ID=#{dataId}")
    void deleteUserById(String dataId);

    /*@Select("SELECT * FROM T_USER WHERE login_Account=#{username} and login_Password=#{password}")*/
    User login(String username, String password);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
}
