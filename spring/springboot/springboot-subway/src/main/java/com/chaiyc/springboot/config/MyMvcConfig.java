package com.chaiyc.springboot.config;

import com.chaiyc.springboot.component.LoginHandlerInterceptor;
import com.chaiyc.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加自己的首页的视图解析器
     * 通过@Bean 注册到容器中
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("index").setViewName("login");
                registry.addViewController("main.html").setViewName("main");  //登陆成功后重定向到这里，防止表单重复提交
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                String[] exclude = new String[]{"/index.html", "index", "/", "/user/login","/static/**","/asserts/**","/webjars/**"};
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns(exclude);
            }

        };

        return configurer;
    }

    /**
     * 添加自己的区域信息解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
