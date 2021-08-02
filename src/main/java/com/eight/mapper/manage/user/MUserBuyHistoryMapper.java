package com.eight.mapper.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserBuyHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserBuyHistoryMapper")
public interface MUserBuyHistoryMapper {

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
     * @param userBuyHistoryPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserBuyHistory> queryUserBuyHistoryPage(@Param("userBuyHistoryPage") Page<UserBuyHistory> userBuyHistoryPage, @Param("param") String param);

    /**
     * 根据用户购买历史id查询用户购买历史
     * @param userBuyHistoryId 用户购买历史id
     * @return 用户购买历史
     */
    UserBuyHistory queryUserBuyHistoryById(Integer userBuyHistoryId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserBuyHistoryCount();
}
