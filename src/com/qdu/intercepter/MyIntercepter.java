/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author qdu
 */
public class MyIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println(request.getServletPath());

        if (request.getServletPath().startsWith("/user") && !(request.getServletPath().endsWith("/toLogin"))) {
            if (null == request.getSession().getAttribute("user")&& !(request.getServletPath().endsWith("/login")) ) {
                response.sendRedirect(request.getContextPath() + "/user/toLogin");
                return false;
            }else
                return true;




        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1,
            Object o, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1,
            Object o, Exception excptn) throws Exception {
    }

}
