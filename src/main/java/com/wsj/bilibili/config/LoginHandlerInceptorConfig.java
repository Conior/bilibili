package com.wsj.bilibili.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/205:41 下午
 */
public class LoginHandlerInceptorConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (null == loginUser){
            request.setAttribute("msg","没有权限，请先登陆");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        } else {
            return true;
        }
    }
}
