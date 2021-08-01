package com.eight.service.consume.Impl;

import com.eight.bean.UserInfo;
import com.eight.mapper.manage.user.MUserInfoMapper;
import com.eight.service.consume.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoServiceImpl")
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private MUserInfoMapper userInfoMapper;
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
        return userInfoMapper.queryAllUserInfoByUserId(userId);
    }

    @Override
    public int modifyPersonInfo(UserInfo userInfo) {
        return userInfoMapper.modifyPersonInfo(userInfo);
    }

    @Override
    public int modifyPersonSecurity(UserInfo userInfo) {
        return userInfoMapper.modifyPersonSecurity(userInfo);
    }
}
