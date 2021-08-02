package com.eight.service.manage;

import com.eight.bean.ManagerInfo;
import com.eight.bean.ManagerPower;
import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.mapper.manage.ManageLoginMapper;
import com.eight.mapper.manage.user.MUserMapper;
import com.eight.service.manage.user.IMUserService;
import com.eight.utils.EnMsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerServiceImpl")

public class ManagerLoginServiceImpl implements IManagerLoginService {
    @Autowired
    private ManageLoginMapper manageLoginMapper;
    @Override
    public ManagerInfo queryManageByUsername(ManagerInfo managerInfo) {
        return manageLoginMapper.queryManageByUsername(managerInfo);
    }

    @Override
    public ManagerInfo queryManageIDByUsername(String managerUsername) {
        return manageLoginMapper.queryManageIDByUsername(managerUsername);
    }

    @Override
    public List<ManagerInfo> queryManagerPowerListByCode(String managerCode) {
        return manageLoginMapper.queryManagerPowerListByCode(managerCode);
    }

    @Override
    public List<ManagerPower> queryManagePowerList() {
        return manageLoginMapper.queryManagePowerList();
    }

    @Override
    public List<ManagerPower> queryManagePowerByParentCode(String powerCode) {
        return manageLoginMapper.queryManagePowerByParentCode(powerCode);
    }

}
