package com.eight.controller.consume;

import com.eight.bean.User;
import com.eight.bean.UserHead;
import com.eight.service.consume.IUserService;
import com.eight.utils.CookieUtils;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@Controller("userController")
@RequestMapping("/eight/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //用户登录，判断是否选中自动登陆，插入cookie
    @RequestMapping(value = "/login")
    @ResponseBody
    public HashMap<String, Object> login(String username, String password, int remember, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = userService.login(username, password);
        if (user != null) {
            Cookie cookie = CookieUtils.createSingleCookie("loginUserHis", user.getUsername(), 60 * 60 * 24 * 7, "/");
            response.addCookie(cookie);
            cookie = CookieUtils.createSingleCookie("loginInfo-Success", "登陆成功", 1, "/");
            response.addCookie(cookie);
            cookie = CookieUtils.createSingleCookie("isLoginHead", user.getUserId().toString(), -2, "/");
            response.addCookie(cookie);
            session.setAttribute(user.getUserId().toString(), user);
            if (remember == 1) {
                cookie = CookieUtils.createSingleCookie("rememberLogin", user.getPassword(), 60 * 60 * 24 * 7, "/");
                response.addCookie(cookie);
                cookie = CookieUtils.createSingleCookie("JSESSIONID", request.getSession().getId(), 60 * 60 * 24 * 7, "/");
                response.addCookie(cookie);
            } else if (remember == 0) {
                Cookie rememberCookie = CookieUtils.getCookie(request.getCookies(), "rememberLogin");
                if (rememberCookie != null) {
                    CookieUtils.deleteCookie(response, rememberCookie);
                }
            }
            return ResultMapUtils.loginResult("登录成功", "1", null);
        } else {
            Cookie cookie = CookieUtils.createSingleCookie("loginInfo-Error", "用户名或者密码错误", 1, "/");
            response.addCookie(cookie);
            return ResultMapUtils.loginResult("登录失败", "2", null);
        }
    }
    //自动登录
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
    public UserHead headAndInfo(String isLoginHead, String userId,HttpServletRequest request) {
        User user;
        if (!isLoginHead.equals("null")) {
            user = (User) request.getSession().getAttribute(isLoginHead);
        }else {
            user = (User) request.getSession().getAttribute(userId);
        }
        if(user == null){
            return userService.queryUserHead((Long) request.getSession().getAttribute("isLoginHead"));
        }
        return userService.queryUserHead(user.getUserId());
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

    @RequestMapping("exitsLogin")
    @ResponseBody
    public void exitsLogin(String userId,HttpSession session,HttpServletResponse response,HttpServletRequest request){
        //如果禁用cookie，这里需要重写URL，待解决
        User user = (User) session.getAttribute(userId);
        if(user != null){
            session.removeAttribute(userId);
        }
        Cookie isLoginHead = CookieUtils.getCookie(request.getCookies(), "isLoginHead");
        CookieUtils.deleteCookie(response,isLoginHead);
        CookieUtils.deleteCookie(response, CookieUtils.getCookie(request.getCookies(), "JSESSIONID"));
    }

    @RequestMapping("cart")
    public String orderCart(){
        return null;
    }
}
