package com.eight.mapper.manage;

import com.eight.bean.ManagerInfo;
import com.eight.bean.ManagerPower;
import com.eight.bean.Page;
import com.eight.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("managerMapper")
public interface ManageLoginMapper {

    public ManagerInfo queryManageByUsername(ManagerInfo managerInfo);

    public ManagerInfo queryManageIDByUsername(String managerUsername);

    public List<ManagerInfo> queryManagerPowerListByCode(String managerCode);

    public List<ManagerPower> queryManagePowerList();

    public List<ManagerPower> queryManagePowerByParentCode(String powerCode);
}
