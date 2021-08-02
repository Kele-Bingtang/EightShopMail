package com.eight.service.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserBalanceLog;

import java.util.List;

public interface IMUserBalanceLogService {

    /**
     * 通过用户地址名查询用户地址
     * @param userBalanceLog 用户地址
     * @return 用户地址
     */
    public UserBalanceLog queryUserBalanceLogByUsername(UserBalanceLog userBalanceLog);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<UserBalanceLog> queryUserBalanceLogList();

    /**
     * 添加用户地址
     * @param userBalanceLog 用户地址
     * @return 受影响的行数
     */
    public int addUserBalanceLog(UserBalanceLog userBalanceLog);
    /**
     * 删除用户地址
     * @param userBalanceLog 用户地址
     * @return 受影响的行数
     */
    public int deleteUserBalanceLog(UserBalanceLog userBalanceLog);
    /**
     * 修改用户地址
     * @param userBalanceLog 用户地址
     * @return 受影响的行数
     */
    public int modifyUserBalanceLog(UserBalanceLog userBalanceLog);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserBalanceLog> queryUserBalanceLogPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userBalanceLogId 用户地址id
     * @return 用户地址
     */
    UserBalanceLog queryUserBalanceLogById(Integer userBalanceLogId);
}
