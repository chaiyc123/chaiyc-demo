package com.chaiyc.springboot.service;

import com.chaiyc.springboot.bean.study.Student;

import java.util.List;

public interface UserService {

    List<Student> findUser();
}
