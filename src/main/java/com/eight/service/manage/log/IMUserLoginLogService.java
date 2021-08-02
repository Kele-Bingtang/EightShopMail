package com.eight.service.manage.log;

import com.eight.bean.UserLoginLog;
import com.eight.bean.Page;

import java.util.List;

public interface IMUserLoginLogService {

    /**
     * 通过用户地址名查询用户地址
     * @param userLoginLog 用户地址
     * @return 用户地址
     */
    public UserLoginLog queryUserLoginLogByUsername(UserLoginLog userLoginLog);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<UserLoginLog> queryUserLoginLogList();

    /**
     * 添加用户地址
     * @param userLoginLog 用户地址
     * @return 受影响的行数
     */
    public int addUserLoginLog(UserLoginLog userLoginLog);
    /**
     * 删除用户地址
     * @param userLoginLog 用户地址
     * @return 受影响的行数
     */
    public int deleteUserLoginLog(UserLoginLog userLoginLog);
    /**
     * 修改用户地址
     * @param userLoginLog 用户地址
     * @return 受影响的行数
     */
    public int modifyUserLoginLog(UserLoginLog userLoginLog);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserLoginLog> queryUserLoginLogPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userLoginLogId 用户地址id
     * @return 用户地址
     */
    UserLoginLog queryUserLoginLogById(Integer userLoginLogId);
}
