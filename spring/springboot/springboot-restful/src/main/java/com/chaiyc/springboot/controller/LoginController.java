package com.chaiyc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, String> maps, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html"; //登陆成功，防止表单重复提交，使用重定向到主页，主页路径在视图解析器中已经添加映射
        }else{
            maps.put("msg","用户或密码错误！");
            return "login";
        }
    }
}
