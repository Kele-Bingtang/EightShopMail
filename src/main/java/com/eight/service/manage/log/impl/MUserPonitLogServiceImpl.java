package com.eight.service.manage.log.impl;

import com.eight.bean.Page;
import com.eight.bean.UserPointLog;
import com.eight.mapper.manage.log.MUserPointLogMapper;
import com.eight.service.manage.log.IMUserPointLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserPointLogServiceImpl")
public class MUserPonitLogServiceImpl implements IMUserPointLogService {
    @Autowired
    private MUserPointLogMapper mUserPointLogMapper;
    @Override
    public UserPointLog queryUserPointLogByUsername(UserPointLog userPointLog) {
        return mUserPointLogMapper.queryUserPointLogByUsername(userPointLog);
    }

    @Override
    public List<UserPointLog> queryUserPointLogList() {
        return mUserPointLogMapper.queryUserPointLogList();
    }

    @Override
    public int addUserPointLog(UserPointLog userPointLog) {
        return mUserPointLogMapper.addUserPointLog(userPointLog);
    }

    @Override
    public int deleteUserPointLog(UserPointLog userPointLog) {
        return mUserPointLogMapper.deleteUserPointLog(userPointLog);
    }

    @Override
    public int modifyUserPointLog(UserPointLog userPointLog) {
        return mUserPointLogMapper.modifyUserPointLog(userPointLog);
    }

    @Override
    public Page<UserPointLog> queryUserPointLogPage(int currentNum, int singlePageSize, String param) {
        Page<UserPointLog> userPointLogPage = new Page<>(currentNum,singlePageSize);
        List<UserPointLog> userPointLogItem = mUserPointLogMapper.queryUserPointLogPage(userPointLogPage, param);
        userPointLogPage.setItem(userPointLogItem);
        userPointLogPage.setTotalPageCount(mUserPointLogMapper.queryUserPointLogCount());
        return userPointLogPage;
    }

    @Override
    public UserPointLog queryUserPointLogById(Integer userPointLogId) {
        return mUserPointLogMapper.queryUserPointLogById(userPointLogId);
    }
}
