package com.eight.controller.manage;

import com.eight.bean.ManagerInfo;
import com.eight.bean.ManagerPower;
import com.eight.service.manage.IManagerLoginService;
import com.eight.utils.ResultMapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/eight/manage")
public class MUserLoginController {

    @Autowired
    private IManagerLoginService managerLoginService;

    @RequestMapping("/login")
    public String willLogin(){
        return "manage/login";
    }

    @RequestMapping("/logging")
    @ResponseBody
    public HashMap<String,Object> login(String username, String password, HttpServletRequest request){
        if(username == null || password == null){
            return ResultMapUtils.loginResult("用户名或者密码不能为空", "2",null);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResultMapUtils.loginResult("用户名不存在","2",null);
        }catch (IncorrectCredentialsException e){
            return ResultMapUtils.loginResult("密码错误","2",null);
        }
        request.getSession().setAttribute("username", username);
        return ResultMapUtils.loginResult("验证成功","1",username);
    }
    /**
     * 转向后台管理首页
     */
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        HashMap<ManagerPower, List<ManagerPower>> managePowerResultMap = managePowerResultMap(username);
        model.addAttribute("managePowers", managePowerResultMap);
        return "manage/index";
    }

    /**
    * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        request.getSession().removeAttribute("username");
        return "redirect:eight/manage/login";
    }

    /**
     * 权限获取菜单
     */
    public HashMap<ManagerPower,List<ManagerPower>> managePowerResultMap(String username){
        HashMap<ManagerPower,List<ManagerPower>> managerAndPowerMap = new HashMap<>();
        List<ManagerPower> managerPowerList = new ArrayList<>();
        ManagerInfo managerInfo = managerLoginService.queryManageIDByUsername(username);
        List<ManagerInfo> managerInfos = managerLoginService.queryManagerPowerListByCode(managerInfo.getManagerCode());
        for (ManagerInfo Info : managerInfos) {
            for (ManagerPower managerPower : Info.getManagerPowers()) {
                List<ManagerPower> managerPowers = managerLoginService.queryManagePowerByParentCode(managerPower.getPowerCode());
                managerPowerList.addAll(managerPowers); //往list增加list 使用addAll
                managerAndPowerMap.put(managerPower,managerPowerList);
                managerPowerList = new ArrayList<>();
            }
        }
        return managerAndPowerMap;
    }

}
