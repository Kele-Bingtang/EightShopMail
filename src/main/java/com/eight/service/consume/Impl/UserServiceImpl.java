package com.eight.service.consume.Impl;

import com.eight.bean.UserInfo;
import com.eight.mapper.consume.UserMapper;
import com.eight.bean.User;
import com.eight.bean.UserHead;
import com.eight.service.consume.IUserInfoService;
import com.eight.service.consume.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    IUserInfoService userInfoService;

    public UserMapper getUserMapper(){
        return userMapper;
    }

    public User login(String username, String password) {
        return userMapper.queryUsernameAndPassword(username, password);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public UserHead queryUserHead(Long userId) {
        return userMapper.queryUserHead(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)  //异常自动回滚
    public void saveUser(User user) {
        userMapper.saveUser(user);
        UserHead userHead = new UserHead();
        userHead.setUserId(user.getUserId());
        userMapper.saveUserHead(userHead);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setUsername(user.getUsername());
        userInfoService.registerAddUserInfo(userInfo);
    }

}
