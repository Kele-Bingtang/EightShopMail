package com.eight.service;

import com.eight.bean.UpdateInfo;
import com.eight.bean.UserInfo;

public interface WcyIUserService {

    /*获取个人信息表*/
    UserInfo info(String userId);

    UpdateInfo updateInfo(UpdateInfo updateInfo);

    /*修改信息*/
    void update(UpdateInfo updateInfo);

    /*返回个人资料页面*/
    UserInfo returnPage(String userInfoId);


    /**
     * 收货地址
     */
}

