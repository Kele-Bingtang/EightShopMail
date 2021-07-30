package com.eight.service.consume;


import com.eight.bean.User;
import com.eight.bean.UserHead;

public interface IUserService {

    User login(String username, String password);

    User queryUserByUsername(String username);

    UserHead queryUserHead(Long userId);

    void saveUser(User user);
}
