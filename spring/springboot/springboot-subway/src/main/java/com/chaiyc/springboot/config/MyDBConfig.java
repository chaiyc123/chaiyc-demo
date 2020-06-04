package com.chaiyc.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据库配置类
 */
@ComponentScan("com.chaiyc.springboot.entities")
@Configuration
@PropertySource("classpath:test\\db.properties")
public class MyDBConfig {


}
