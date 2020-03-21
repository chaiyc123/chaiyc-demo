package com.chaiyc.springboot.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * 测试控制器
 */
//@RestController

@Controller
public class HelloController {

    /*@Autowired
    private StudentProperties studentProperties;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello SpringBoot!!"  + studentProperties.getName() + "," + studentProperties.getAge());

        return "Hello SpringBoot!! 你妹的" + studentProperties.getName() + "," + studentProperties.getAge();
    }*/

    @RequestMapping("/")
    public String index(Model model){
         return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        return "hello";
    }

}
