package com.eight.service;


import com.eight.bean.User;
import com.eight.bean.UserHead;

public interface UserService {

    User login(String username, String password);

    User queryUserByUsername(String username);

    UserHead queryUserHead(Long userId);

    void saveUser(User user);
}
