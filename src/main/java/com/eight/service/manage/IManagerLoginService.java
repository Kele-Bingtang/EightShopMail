package com.eight.service.manage;

import com.eight.bean.ManagerInfo;
import com.eight.bean.ManagerPower;

import java.util.List;


public interface IManagerLoginService {
    /**
     * 通过用户名查询用户
     * @param managerInfo 用户
     * @return 用户
     */
    public ManagerInfo queryManageByUsername(ManagerInfo managerInfo);

    public ManagerInfo queryManageIDByUsername(String managerUsername);

    public List<ManagerInfo> queryManagerPowerListByCode(String managerCode);

    public List<ManagerPower> queryManagePowerList();

    public List<ManagerPower> queryManagePowerByParentCode(String powerCode);

}
