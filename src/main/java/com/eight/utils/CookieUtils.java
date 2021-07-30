package com.eight.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieUtils {

    public static Cookie createSingleCookie(String name, String value, int maxAge, String path) {
        Cookie cookie = new Cookie(name, value);
        if (maxAge != -2) {
            cookie.setMaxAge(maxAge);
        }
        if (path == null) {
            cookie.setPath("/");
        } else {
            cookie.setPath(path);
        }
        return cookie;
    }


    public static Cookie getCookie(Cookie[] cookies, String cookieKey) {
        if (cookieKey == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieKey.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
        if(cookie != null){
            cookie.setMaxAge(0);//表示马上删除，不需要等待浏览器关闭
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    public static Object getSession(HttpSession session,String sessionId){
        return session.getAttribute(sessionId);
    }
}
