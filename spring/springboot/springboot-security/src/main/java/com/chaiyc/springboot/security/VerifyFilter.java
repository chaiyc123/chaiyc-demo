package com.chaiyc.springboot.security;

import org.springframework.security.authentication.DisabledException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chaiyc
 * @version 1.0
 * @date 20/06/18 10:15
 * @description: 使用过滤器的方式验证 验证码是否正确
 */
public class VerifyFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher =new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
           HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (isProtectedUrl(httpServletRequest)){
            String verifyCode = httpServletRequest.getParameter("verifyCode");
            if(!validateVerify(verifyCode)){
                //手动设置异常
                httpServletRequest.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION",new DisabledException("验证码输入错误"));
                // 转发到错误Url
                httpServletRequest.getRequestDispatcher("/login/error").forward(httpServletRequest,httpServletResponse);
            } else {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }
        }else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

    }

    private boolean validateVerify(String inputVerify) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 不分区大小写
        // 这个validateCode是在servlet中存入session的名字
        String validateCode = ((String) request.getSession().getAttribute("validateCode")).toLowerCase();
        inputVerify = inputVerify.toLowerCase();

        System.out.println("验证码：" + validateCode + "用户输入：" + inputVerify);
        return validateCode.equals(inputVerify);
    }

    // 拦截 /login的POST请求
    private boolean isProtectedUrl(HttpServletRequest request) {
        return "POST".equals(request.getMethod()) && pathMatcher.match("/login", request.getServletPath());
    }
}
