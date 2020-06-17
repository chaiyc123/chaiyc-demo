package com.chaiyc.springboot.config;

import com.chaiyc.springboot.servlet.VerifyServlet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/17 17:29
 * @description: TODO
 */
@Configuration
public class MyMvcConfig {


    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }


}
