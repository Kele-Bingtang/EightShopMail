package com.eight.aop;

import com.eight.bean.HostHolder;
import com.eight.bean.User;
import com.eight.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private HostHolder hostHolder;
    /**
     * 购物，等需要登录才能执行的操作
     * 判断用户是否登录，没登录跳转登录页，登录返回用户信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie isLoginHead = CookieUtils.getCookie(request.getCookies(), "isLoginHead");
        if(isLoginHead == null){
            response.sendRedirect("/static/userLoginAndReg/loginUser.html");
            return false;
        }
        User user = (User) request.getSession().getAttribute(isLoginHead.getValue());
        if(user == null){
            response.sendRedirect("/static/userLoginAndReg/loginUser.html");
            return false;
        }
        hostHolder.setUser(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if(user != null && modelAndView != null){
            modelAndView.addObject("user", user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
