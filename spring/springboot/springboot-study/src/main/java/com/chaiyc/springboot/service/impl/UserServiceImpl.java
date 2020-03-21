package com.chaiyc.springboot.service.impl;

import com.chaiyc.springboot.bean.study.Student;
import com.chaiyc.springboot.mapper.study.StudentMapper;
import com.chaiyc.springboot.mapper.user.UserMapper;
import com.chaiyc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findUser() {
        return studentMapper.findAll();
    }
}
