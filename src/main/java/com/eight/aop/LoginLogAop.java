package com.eight.aop;

import com.eight.bean.User;
import com.eight.bean.UserLoginLog;
import com.eight.service.consume.IUserService;
import com.eight.service.manage.log.IMUserLoginLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * 登录日志
 */
@Aspect
@Component
public class LoginLogAop {

    @Autowired
    private IMUserLoginLogService mUserLoginLogService;
    @Autowired
    private IUserService userService;

    @Pointcut("execution(public * com.eight.service.consume.Impl.UserServiceImpl.login(..))")
    public void login(){}


    @AfterReturning(value = "login()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求地址
        String url = request.getRequestURL().toString();
        //请求方法
        String method = request.getMethod();
        //请求IP
        String host = request.getRemoteHost();
        //uri
        String uri = request.getRequestURI();
        // result的值就是被拦截方法的返回值
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setLoginIp(request.getRemoteHost());
        userLoginLog.setLoginTime(new Timestamp(System.currentTimeMillis()));
        //切点的参数值
        Object[] arg =joinPoint.getArgs();
        String username = (String) arg[0];
        User user = userService.queryUserByUsername(username);
        userLoginLog.setUserId(user.getUserId());
        if(result != null){
            userLoginLog.setLoginType(1);
        }else {
            userLoginLog.setLoginType(0);
        }
        mUserLoginLogService.addUserLoginLog(userLoginLog);
    }
}
