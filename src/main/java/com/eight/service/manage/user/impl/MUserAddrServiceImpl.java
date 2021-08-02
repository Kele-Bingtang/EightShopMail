package com.eight.service.manage.user.impl;

import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.bean.UserAddr;
import com.eight.mapper.manage.user.MUserAddrMapper;
import com.eight.mapper.manage.user.MUserMapper;
import com.eight.service.manage.user.IMUserAddrService;
import com.eight.service.manage.user.IMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserAddrServiceImpl")
public class MUserAddrServiceImpl implements IMUserAddrService {
    @Autowired
    private MUserAddrMapper mUserAddrMapper;
    @Autowired
    private IMUserService imUserService;
    @Override
    public UserAddr queryUserAddrByUsername(UserAddr userAddr) {
        return mUserAddrMapper.queryUserAddrByUsername(userAddr);
    }

    @Override
    public List<UserAddr> queryUserAddrList() {
        return mUserAddrMapper.queryUserAddrList();
    }

    @Override
    public int addUserAddr(String username,UserAddr userAddr) {
        User user = imUserService.queryUserIdByUsername(username);
        return mUserAddrMapper.addUserAddr(userAddr,user.getUserId());
    }

    @Override
    public int deleteUserAddr(UserAddr userAddr) {
        return mUserAddrMapper.deleteUserAddr(userAddr);
    }

    @Override
    public int modifyUserAddr(UserAddr userAddr) {
        return mUserAddrMapper.modifyUserAddr(userAddr);
    }

    @Override
    public Page<UserAddr> queryUserAddrPage(int currentNum, int singlePageSize, String param) {
        Page<UserAddr> userAddrPage = new Page<>(currentNum,singlePageSize);
        List<UserAddr> userAddrItem = mUserAddrMapper.queryUserAddrPage(userAddrPage, param);
        userAddrPage.setItem(userAddrItem);
        userAddrPage.setTotalPageCount(mUserAddrMapper.queryUserAddrCount());
        return userAddrPage;
    }

    @Override
    public UserAddr queryUserAddrById(Integer userAddrId) {
        return mUserAddrMapper.queryUserAddrById(userAddrId);
    }

    @Override
    public List<User> queryUserList() {
        return imUserService.queryUserList();
    }
}
