package com.eight.config;

import com.eight.bean.ManagerInfo;
import com.eight.bean.User;
import com.eight.service.manage.IManagerLoginService;
import com.eight.service.manage.user.IMUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 权限认证
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IManagerLoginService iManagerLoginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        ManagerInfo loginManager = new ManagerInfo();
        loginManager.setManagerUsername(username);
        ManagerInfo managerInfo = iManagerLoginService.queryManageByUsername(loginManager);
        if(managerInfo == null){
            return null;
        }
        return new SimpleAuthenticationInfo(managerInfo,managerInfo.getManagerPassword(),getName());
    }
}
