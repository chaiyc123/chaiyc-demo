package com.chaiyc.springboot.service.user;

import com.chaiyc.springboot.entities.user.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    /**
     * 通过 id 查找 用户
     * @return
     */
    User getUserById(String dataId) throws Exception;;

    /**
     * 查询所有的用户，后续改进使用分页
     * @return
     */
    List<User> getAllUser() throws Exception;;

    /**
     * 添加用户
     * @param user
     */
    void saveUser(User user) throws Exception;;

    /**
     * 修改用户
     * @param user
     */
    void saveUpdate(User user) throws Exception;;

    /**
     * 通过id删除用户
     * @param id
     */
    void deleteUserById(String dataId) throws Exception;;

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password) throws Exception;;

    PageInfo<User> getPageUser(int pageNo, int pageSize) throws Exception;;

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
}
