package com.eight.service.manage.user.impl;

import com.eight.bean.Page;
import com.eight.bean.UserBuyHistory;
import com.eight.mapper.manage.user.MUserBuyHistoryMapper;
import com.eight.service.manage.user.IMUserBuyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserBuyHistoryServiceImpl")
public class MUserBuyHistoryServiceImpl implements IMUserBuyHistoryService {
    @Autowired
    private MUserBuyHistoryMapper mUserBuyHistoryMapper;
    @Override
    public UserBuyHistory queryUserBuyHistoryByUsername(UserBuyHistory userBuyHistory) {
        return mUserBuyHistoryMapper.queryUserBuyHistoryByUsername(userBuyHistory);
    }

    @Override
    public List<UserBuyHistory> queryUserBuyHistoryList() {
        return mUserBuyHistoryMapper.queryUserBuyHistoryList();
    }

    @Override
    public int addUserBuyHistory(UserBuyHistory userBuyHistory) {
        return mUserBuyHistoryMapper.addUserBuyHistory(userBuyHistory);
    }

    @Override
    public int deleteUserBuyHistory(UserBuyHistory userBuyHistory) {
        return mUserBuyHistoryMapper.deleteUserBuyHistory(userBuyHistory);
    }

    @Override
    public int modifyUserBuyHistory(UserBuyHistory userBuyHistory) {
        return mUserBuyHistoryMapper.modifyUserBuyHistory(userBuyHistory);
    }

    @Override
    public Page<UserBuyHistory> queryUserBuyHistoryPage(int currentNum, int singlePageSize, String param) {
        Page<UserBuyHistory> userBuyHistoryPage = new Page<>(currentNum,singlePageSize);
        List<UserBuyHistory> userBuyHistoryItem = mUserBuyHistoryMapper.queryUserBuyHistoryPage(userBuyHistoryPage, param);
        userBuyHistoryPage.setItem(userBuyHistoryItem);
        userBuyHistoryPage.setTotalPageCount(mUserBuyHistoryMapper.queryUserBuyHistoryCount());
        return userBuyHistoryPage;
    }

    @Override
    public UserBuyHistory queryUserBuyHistoryById(Integer userBuyHistoryId) {
        return mUserBuyHistoryMapper.queryUserBuyHistoryById(userBuyHistoryId);
    }
}
