package com.eight.controller;

import com.eight.bean.User;
import com.eight.bean.UserHead;
import com.eight.service.UserService;
import com.eight.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录，判断是否选中自动登陆，插入cookie
    @RequestMapping(value = "/login")
    @ResponseBody
    public User login(String username, String password, int remember, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = userService.login(username, password);
        if (user != null) {
            Cookie cookie = CookieUtils.createSingleCookie("userId", user.getUserId().toString(), 30, "/");
            response.addCookie(cookie);
            cookie = CookieUtils.createSingleCookie("loginUserHis", user.getUsername(), 60 * 60 * 24 * 7, "/");
            response.addCookie(cookie);
            cookie = CookieUtils.createSingleCookie("loginInfo-Success", "登陆成功", 1, "/");
            response.addCookie(cookie);
            cookie = CookieUtils.createSingleCookie("isLoginHead", "-1", -2, "/");
            response.addCookie(cookie);
            session.setAttribute("user", user);
            if (remember == 1) {
                cookie = CookieUtils.createSingleCookie("rememberLogin", user.getPassword(), 60 * 60 * 24 * 7, "/");
                response.addCookie(cookie);
            } else if (remember == 0) {
                Cookie rememberCookie = CookieUtils.getCookie(request.getCookies(), "rememberLogin");
                if (rememberCookie != null) {
                    CookieUtils.deleteCookie(response, rememberCookie);
                }
            }
            return user;
        } else {
            Cookie cookie = CookieUtils.createSingleCookie("loginInfo-Error", "用户名或者密码错误", 1, "/");
            response.addCookie(cookie);
            return null;
        }
    }

    @RequestMapping("loginUserUI")
    public void loginUserUI(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {

        }
    }
    //查询用户名
    @RequestMapping(value = "/queryUsername")
    @ResponseBody
    public User queryUserByUsername(String username) {
        return userService.queryUserByUsername(username);
    }
    //从session获取用户信息，查询头像
    @RequestMapping("/headAndInfo")
    @ResponseBody
    public UserHead headAndInfo(String isLoginHead, HttpServletRequest request) {
        if (isLoginHead != null) {
            User user = (User) request.getSession().getAttribute("user");
            UserHead userHead = userService.queryUserHead(user.getUserId());
            return userService.queryUserHead(user.getUserId());
        }
        return null;
    }
    //用户注册，添加注册的用户名cookie
    @RequestMapping("register")
    @ResponseBody
    public User register(User user, HttpServletResponse response) {
        userService.saveUser(user);
        Cookie cookie = CookieUtils.createSingleCookie("loginUserHis", user.getUsername(), 60 * 60 * 24 * 7, "/");
        response.addCookie(cookie);
        return user;
    }

}
