package com.chaiyc.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            // 已登陆，放行请求
            return true;
        }

    }
}
