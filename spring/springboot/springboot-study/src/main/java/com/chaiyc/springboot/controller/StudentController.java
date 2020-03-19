package com.chaiyc.springboot.controller;

import com.chaiyc.springboot.mapper.StudentMapper;
import com.chaiyc.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Student 的控制器
 */
@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/findStudent")
    public String listStudent(Model model){
        List<Student> lists = studentMapper.findAll();
        model.addAttribute("students",lists);
        return "student";
    }
}
