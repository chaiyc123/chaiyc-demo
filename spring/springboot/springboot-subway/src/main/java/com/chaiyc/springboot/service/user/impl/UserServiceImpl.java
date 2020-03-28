package com.chaiyc.springboot.service.user.impl;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.mapper.user.UserMapper;
import com.chaiyc.springboot.service.user.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById (String dataId) throws Exception {
        return userMapper.getUserById(dataId);
    }

    @Override
    public List<User> getAllUser() throws Exception {
        return userMapper.getAllUser();
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }

    @Override
    public void saveUpdate(User user) throws Exception {
        userMapper.saveUpdate(user);
    }

    @Override
    public void deleteUserById(String dataId) throws Exception {
        userMapper.deleteUserById(dataId);
    }

    @Override
    public User login(String username, String password) throws Exception {
        return userMapper.login(username,password);
    }

    @Override
    public PageInfo<User> getPageUser(int pageNo, int pageSize)  throws Exception{
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.getPageUser();
        return new PageInfo<User>(list);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
