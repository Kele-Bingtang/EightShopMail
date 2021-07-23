package com.eight.service.Impl;

import com.eight.mapper.UserMapper;
import com.eight.bean.User;
import com.eight.bean.UserHead;
import com.eight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

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
    public void saveUser(User user) {
        userMapper.saveUser(user);
        System.out.println(user.getUserId());
        userMapper.saveUserHead(user);
    }

}
