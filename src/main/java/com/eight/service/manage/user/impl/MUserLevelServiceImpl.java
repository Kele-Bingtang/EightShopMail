package com.eight.service.manage.user.impl;

import com.eight.bean.Page;
import com.eight.bean.UserLevel;
import com.eight.mapper.manage.user.MUserLevelMapper;
import com.eight.mapper.manage.user.MUserMapper;
import com.eight.service.manage.user.IMUserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserLevelServiceImpl")
public class MUserLevelServiceImpl implements IMUserLevelService {
    @Autowired
    private MUserLevelMapper mUserLevelMapper;
    @Override
    public UserLevel queryUserLevelByUsername(UserLevel userLevel) {
        return mUserLevelMapper.queryUserLevelByUsername(userLevel);
    }

    @Override
    public List<UserLevel> queryUserLevelList() {
        return mUserLevelMapper.queryUserLevelList();
    }

    @Override
    public int addUserLevel(UserLevel userLevel) {
        return mUserLevelMapper.addUserLevel(userLevel);
    }

    @Override
    public int deleteUserLevel(UserLevel userLevel) {
        return mUserLevelMapper.deleteUserLevel(userLevel);
    }

    @Override
    public int modifyUserLevel(UserLevel userLevel) {
        return mUserLevelMapper.modifyUserLevel(userLevel);
    }

    @Override
    public Page<UserLevel> queryUserLevelPage(int currentNum, int singlePageSize, String param) {
        Page<UserLevel> userLevelPage = new Page<>(currentNum,singlePageSize);
        List<UserLevel> userLevelItem = mUserLevelMapper.queryUserLevelPage(userLevelPage, param);
        userLevelPage.setItem(userLevelItem);
        userLevelPage.setTotalPageCount(mUserLevelMapper.queryUserLevelCount());
        return userLevelPage;
    }

    @Override
    public UserLevel queryUserLevelById(Integer userLevelId) {
        return mUserLevelMapper.queryUserLevelById(userLevelId);
    }

}
