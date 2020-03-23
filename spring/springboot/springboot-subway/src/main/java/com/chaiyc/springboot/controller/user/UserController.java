package com.chaiyc.springboot.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户管理控制器
 */
@Controller
public class UserController {

    @GetMapping("/main")
    public String index(){
        return "main";
    }

    @GetMapping("/user/list")
    public String list(){

        return "user/user_list";
    }
}
