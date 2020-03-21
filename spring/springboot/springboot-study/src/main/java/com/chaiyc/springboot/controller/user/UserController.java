package com.chaiyc.springboot.controller.user;

import com.chaiyc.springboot.bean.study.Student;
import com.chaiyc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理控制器
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model){

        List<Student> lists = userService.findUser();

        model.addAttribute("lists",lists);

        return "user/user_list";
    }

}
