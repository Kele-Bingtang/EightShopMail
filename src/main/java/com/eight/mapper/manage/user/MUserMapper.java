package com.eight.mapper.manage.user;

import com.eight.bean.Page;
import com.eight.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserMapper")
public interface MUserMapper {

    public User queryUserByUsername(User user);

    public User queryUserIdByUsername(String username);

    public List<User> queryUserList();

    public List<User> queryUserPage(@Param("userPage") Page<User> userPage,@Param("param") String param);

    public int addUser(User user);

    public int deleteUser(User user);

    public int modifyPassword(User user);

    public int queryUserCount();

    User queryUserById(Long userId);
}
