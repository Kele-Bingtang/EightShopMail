package com.eight.service.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserPointLog;

import java.util.List;

public interface IMUserPointLogService {

    /**
     * 通过用户地址名查询用户地址
     * @param userPointLog 用户地址
     * @return 用户地址
     */
    public UserPointLog queryUserPointLogByUsername(UserPointLog userPointLog);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<UserPointLog> queryUserPointLogList();

    /**
     * 添加用户地址
     * @param userPointLog 用户地址
     * @return 受影响的行数
     */
    public int addUserPointLog(UserPointLog userPointLog);
    /**
     * 删除用户地址
     * @param userPointLog 用户地址
     * @return 受影响的行数
     */
    public int deleteUserPointLog(UserPointLog userPointLog);
    /**
     * 修改用户地址
     * @param userPointLog 用户地址
     * @return 受影响的行数
     */
    public int modifyUserPointLog(UserPointLog userPointLog);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserPointLog> queryUserPointLogPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userPointLogId 用户地址id
     * @return 用户地址
     */
    UserPointLog queryUserPointLogById(Integer userPointLogId);
}
