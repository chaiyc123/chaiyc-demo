package com.chaiyc.springboot.service.user.impl;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.mapper.user.UserMapper;
import com.chaiyc.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById() {
        return userMapper.getUserById();
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void saveUpdate(User user) {
        userMapper.saveUpdate(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }
}
