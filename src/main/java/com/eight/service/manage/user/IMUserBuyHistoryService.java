package com.eight.service.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserBuyHistory;

import java.util.List;

public interface IMUserBuyHistoryService {

    /**
     * 通过用户购买历史名查询用户购买历史
     * @param userBuyHistory 用户购买历史
     * @return 用户购买历史
     */
    public UserBuyHistory queryUserBuyHistoryByUsername(UserBuyHistory userBuyHistory);

    /**
     * 查询所有用户购买历史
     * @return 用户购买历史
     */
    public List<UserBuyHistory> queryUserBuyHistoryList();

    /**
     * 添加用户购买历史
     * @param userBuyHistory 用户购买历史
     * @return 受影响的行数
     */
    public int addUserBuyHistory(UserBuyHistory userBuyHistory);
    /**
     * 删除用户购买历史
     * @param userBuyHistory 用户购买历史
     * @return 受影响的行数
     */
    public int deleteUserBuyHistory(UserBuyHistory userBuyHistory);
    /**
     * 修改用户购买历史
     * @param userBuyHistory 用户购买历史
     * @return 受影响的行数
     */
    public int modifyUserBuyHistory(UserBuyHistory userBuyHistory);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserBuyHistory> queryUserBuyHistoryPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户购买历史id查询用户购买历史
     * @param userBuyHistoryId 用户购买历史id
     * @return 用户购买历史
     */
    UserBuyHistory queryUserBuyHistoryById(Integer userBuyHistoryId);
}
