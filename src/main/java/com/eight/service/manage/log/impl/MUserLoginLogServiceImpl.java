package com.eight.service.manage.log.impl;

import com.eight.bean.UserLoginLog;
import com.eight.bean.Page;
import com.eight.mapper.manage.log.MUserLoginLogMapper;
import com.eight.service.manage.log.IMUserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserLoginLogServiceImpl")
public class MUserLoginLogServiceImpl implements IMUserLoginLogService {
    @Autowired
    private MUserLoginLogMapper mUserLoginLogMapper;
    @Override
    public UserLoginLog queryUserLoginLogByUsername(UserLoginLog userLoginLog) {
        return mUserLoginLogMapper.queryUserLoginLogByUsername(userLoginLog);
    }

    @Override
    public List<UserLoginLog> queryUserLoginLogList() {
        return mUserLoginLogMapper.queryUserLoginLogList();
    }

    @Override
    public int addUserLoginLog(UserLoginLog userLoginLog) {
        return mUserLoginLogMapper.addUserLoginLog(userLoginLog);
    }

    @Override
    public int deleteUserLoginLog(UserLoginLog userLoginLog) {
        return mUserLoginLogMapper.deleteUserLoginLog(userLoginLog);
    }

    @Override
    public int modifyUserLoginLog(UserLoginLog userLoginLog) {
        return mUserLoginLogMapper.modifyUserLoginLog(userLoginLog);
    }

    @Override
    public Page<UserLoginLog> queryUserLoginLogPage(int currentNum, int singlePageSize, String param) {
        Page<UserLoginLog> userLoginLogPage = new Page<>(currentNum,singlePageSize);
        List<UserLoginLog> userLoginLogItem = mUserLoginLogMapper.queryUserLoginLogPage(userLoginLogPage, param);
        userLoginLogPage.setItem(userLoginLogItem);
        userLoginLogPage.setTotalPageCount(mUserLoginLogMapper.queryUserLoginLogCount());
        return userLoginLogPage;
    }

    @Override
    public UserLoginLog queryUserLoginLogById(Integer userLoginLogId) {
        return mUserLoginLogMapper.queryUserLoginLogById(userLoginLogId);
    }
}
