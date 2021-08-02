package com.eight.service.consume;

import com.eight.bean.UserAddr;
import com.eight.bean.UserInfo;


public interface IUserInfoService {

    /*通过用户id获取个人信息表*/
    UserInfo queryUserInfoByUserId(Long userId);

    /*修改信息*/
    int modifyUserInfo(UserInfo userInfo);

    UserInfo queryAllUserInfoByUserId(Long userId);

    int modifyPersonInfo(UserInfo userInfo);

    int modifyPersonSecurity(UserInfo userInfo);

    int modifyPersonAddress(UserAddr userAddr);
}

