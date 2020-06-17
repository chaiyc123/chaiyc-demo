package com.chaiyc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Security 学习 博客：https://blog.csdn.net/yuanlaijike/category_9283872.html
 */
@SpringBootApplication
@MapperScan(value = "com.chaiyc.springboot.mapper")  //扫描mapper
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }



}
