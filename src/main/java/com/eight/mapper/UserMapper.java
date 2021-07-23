package com.eight.mapper;

import com.eight.bean.User;
import com.eight.bean.UserHead;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {

    /**
     * 登录判断用户名和密码是否正确
     *
     * @param username 用户名
     * @param password 密码
     * @return 正常返回User(存储数据库的User数据)，错误返回null
     */
    public User queryUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查询用户信息
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 如果返回 null,说明没有这个用户。反之亦然
     */
    User queryUserByUsername(String username);


    void saveUser(User user);

    UserHead queryUserHead(Long userId);

    void saveUserHead(User user);
}
