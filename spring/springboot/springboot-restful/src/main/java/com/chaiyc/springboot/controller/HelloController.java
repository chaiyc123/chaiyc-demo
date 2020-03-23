package com.chaiyc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String hello( Map<String,Object> map){
        map.put("msg","我是后台的model");

        map.put("users", Arrays.asList("张三","李四","王五"));

        return "hello/hello";
    }
}
