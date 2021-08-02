package com.eight.service.manage.log.impl;

import com.eight.bean.Page;
import com.eight.bean.UserBalanceLog;
import com.eight.mapper.manage.log.MUserBalanceLogMapper;
import com.eight.service.manage.log.IMUserBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserBalanceLogServiceImpl")
public class MUserBalanceLogServiceImpl implements IMUserBalanceLogService {
    @Autowired
    private MUserBalanceLogMapper mUserBalanceLogMapper;
    @Override
    public UserBalanceLog queryUserBalanceLogByUsername(UserBalanceLog userBalanceLog) {
        return mUserBalanceLogMapper.queryUserBalanceLogByUsername(userBalanceLog);
    }

    @Override
    public List<UserBalanceLog> queryUserBalanceLogList() {
        return mUserBalanceLogMapper.queryUserBalanceLogList();
    }

    @Override
    public int addUserBalanceLog(UserBalanceLog userBalanceLog) {
        return mUserBalanceLogMapper.addUserBalanceLog(userBalanceLog);
    }

    @Override
    public int deleteUserBalanceLog(UserBalanceLog userBalanceLog) {
        return mUserBalanceLogMapper.deleteUserBalanceLog(userBalanceLog);
    }

    @Override
    public int modifyUserBalanceLog(UserBalanceLog userBalanceLog) {
        return mUserBalanceLogMapper.modifyUserBalanceLog(userBalanceLog);
    }

    @Override
    public Page<UserBalanceLog> queryUserBalanceLogPage(int currentNum, int singlePageSize, String param) {
        Page<UserBalanceLog> userBalanceLogPage = new Page<>(currentNum,singlePageSize);
        List<UserBalanceLog> userBalanceLogItem = mUserBalanceLogMapper.queryUserBalanceLogPage(userBalanceLogPage, param);
        userBalanceLogPage.setItem(userBalanceLogItem);
        userBalanceLogPage.setTotalPageCount(mUserBalanceLogMapper.queryUserBalanceLogCount());
        return userBalanceLogPage;
    }

    @Override
    public UserBalanceLog queryUserBalanceLogById(Integer userBalanceLogId) {
        return mUserBalanceLogMapper.queryUserBalanceLogById(userBalanceLogId);
    }
}
