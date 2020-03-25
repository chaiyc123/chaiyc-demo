package com.chaiyc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.chaiyc.springboot.mapper")
@SpringBootApplication
public class SpringbootSubwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSubwayApplication.class, args);
    }

}
