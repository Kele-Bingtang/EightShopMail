package com.eight;

import com.eight.bean.*;
import com.eight.mapper.consume.IndexMapper;
import com.eight.mapper.manage.ManageLoginMapper;
import com.eight.mapper.manage.user.MUserMapper;
import com.eight.service.consume.Impl.UserServiceImpl;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class EightsmApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MUserMapper mUserMapper;
    @Autowired
    private ManageLoginMapper manageLoginMapper;
    @Autowired
    private IndexMapper indexMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void queryUsernameAndPassword(){
        User user = userService.queryUserByUsername("kele");
        System.out.println("running ..." + user);
    }

    @Test
    public void queryUserPage() {
        Page<User> userPage = new Page<>(1,10);
        List<User> page = mUserMapper.queryUserPage(userPage, null);
        System.out.println(page);
    }

    @Test
    public void queryManager(){
        HashMap<ManagerPower,List<ManagerPower>> managerAndPowerMap = new HashMap<>();
        List<ManagerPower> managerPowerList = new ArrayList<>();
        ManagerInfo managerInfo = manageLoginMapper.queryManageIDByUsername("admin");
        List<ManagerInfo> managerInfos = manageLoginMapper.queryManagerPowerListByCode(managerInfo.getManagerCode());
        for (ManagerInfo Info : managerInfos) {
            for (ManagerPower managerPower : Info.getManagerPowers()) {
                List<ManagerPower> managerPowers = manageLoginMapper.queryManagePowerByParentCode(managerPower.getPowerCode());
                managerPowerList.addAll(managerPowers); //往list增加list 使用addAll
                managerAndPowerMap.put(managerPower,managerPowerList);
                managerPowerList = new ArrayList<>();
            }
        }
        for (Map.Entry<ManagerPower, List<ManagerPower>> entry : managerAndPowerMap.entrySet()) {
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }

    }

    @Test
    public void test01(){
        List<ProductComment> productComments = indexMapper.queryCommentArticleByNum(1);
        for (ProductComment productComment : productComments) {
            System.out.println(productComment);
        }
    }
}
