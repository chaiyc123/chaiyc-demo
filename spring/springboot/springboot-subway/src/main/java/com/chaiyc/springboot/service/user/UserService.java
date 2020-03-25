package com.chaiyc.springboot.service.user;

import com.chaiyc.springboot.entities.user.User;

import java.util.List;

public interface UserService {

    /**
     * 通过 id 查找 用户
     * @return
     */
    User getUserById();

    /**
     * 查询所有的用户，后续改进使用分页
     * @return
     */
    List<User> getAllUser();

    /**
     * 添加用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void saveUpdate(User user);

    /**
     * 通过id删除用户
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
