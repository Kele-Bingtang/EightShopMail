package com.eight.service.manage.user.impl;

import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.bean.UserInfo;
import com.eight.mapper.manage.user.MUserMapper;
import com.eight.service.manage.user.IMUserService;
import com.eight.utils.EnMsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserServiceImpl")
public class MUserServiceImpl implements IMUserService {
    @Autowired
    private MUserMapper mUserMapper;
    @Override
    public User queryUserByUsername(User user) {
        return mUserMapper.queryUserByUsername(user);
    }

    @Override
    public List<User> queryUserList() {
        return mUserMapper.queryUserList();
    }

    public int addUser(User user){
        return mUserMapper.addUser(user);
    }

    public int deleteUser(User user){
        return mUserMapper.deleteUser(user);
    }

    public int modifyPassword(User user){
        return mUserMapper.modifyPassword(user);
    }

    @Override
    public Page<User> queryUserPage(int currentNum, int singlePageSize, String param) {
        Page<User> userPage = new Page<>(currentNum,singlePageSize);
        List<User> users = mUserMapper.queryUserPage(userPage, param);
        for (User user : users) {
            if(user.getUserStatus() == 0){ //0.离线，1.在线
                user.setUserStatusStr(EnMsgType.USERSTATUSOUT);;
            }else if(user.getUserStatus() == 1){
                user.setUserStatusStr(EnMsgType.USERSTATUSON);;
            }
        }
        userPage.setItem(users);
        userPage.setTotalPageCount(mUserMapper.queryUserCount());
        return userPage;
    }

    @Override
    public User queryUserById(Long userId) {
        return mUserMapper.queryUserById(userId);
    }

    @Override
    public User queryUserIdByUsername(String username) {
        return mUserMapper.queryUserIdByUsername(username);
    }



}
