package com.eight.service.consume.Impl;

import com.eight.bean.UserAddr;
import com.eight.bean.UserInfo;
import com.eight.bean.UserLevel;
import com.eight.mapper.manage.user.MUserAddrMapper;
import com.eight.mapper.manage.user.MUserInfoMapper;
import com.eight.service.consume.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoServiceImpl")
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private MUserInfoMapper userInfoMapper;
    @Autowired
    private MUserAddrMapper userAddrMapper;
    @Override
    public UserInfo queryUserInfoByUserId(Long userId) {
        return userInfoMapper.queryUserInfoByUserId(userId);
    }

    @Override
    public int modifyUserInfo(UserInfo userInfo) {
        return userInfoMapper.modifyUserInfo(userInfo);
    }

    @Override
    public UserInfo queryAllUserInfoByUserId(Long userId) {
        UserInfo userInfo = userInfoMapper.queryAllUserInfoByUserId(userId);
        /*UserLevel userLevel = userInfoMapper.queryUserLvel(userInfo);
        userInfo.setUserLevel(userLevel);*/
        return userInfo;
    }

    @Override
    public int modifyPersonInfo(UserInfo userInfo) {
        return userInfoMapper.modifyPersonInfo(userInfo);
    }

    @Override
    public int modifyPersonSecurity(UserInfo userInfo) {
        if(userInfo.getIdentityCardTypeStr().equals("身份证")){
            userInfo.setIdentityCardType(1);
        }else if(userInfo.getIdentityCardTypeStr().equals("军官证")){
            userInfo.setIdentityCardType(2);
        }else {
            userInfo.setIdentityCardType(3);
        }
        return userInfoMapper.modifyPersonSecurity(userInfo);
    }

    @Override
    public int modifyPersonAddress(UserAddr userAddr) {
        return userAddrMapper.modifyUserAddr(userAddr);
    }
}
