package com.wsj.bilibili.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/205:41 下午
 */
public class UserHandlerInceptorConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        Object msg = request.getSession().getAttribute("msg");

        if (null == loginUser){
            request.setAttribute("msg","没有权限，请先登陆");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }

        return true;
    }
}
