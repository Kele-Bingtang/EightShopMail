package com.eight.service.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserLevel;

import java.util.List;

public interface IMUserLevelService {

    /**
     * 通过用户积分名查询用户积分
     * @param userLevel 用户积分
     * @return 用户积分
     */
    public UserLevel queryUserLevelByUsername(UserLevel userLevel);

    /**
     * 查询所有用户积分
     * @return 用户积分
     */
    public List<UserLevel> queryUserLevelList();

    /**
     * 添加用户积分
     * @param userLevel 用户积分
     * @return 受影响的行数
     */
    public int addUserLevel(UserLevel userLevel);
    /**
     * 删除用户积分
     * @param userLevel 用户积分
     * @return 受影响的行数
     */
    public int deleteUserLevel(UserLevel userLevel);
    /**
     * 修改用户积分
     * @param userLevel 用户积分
     * @return 受影响的行数
     */
    public int modifyUserLevel(UserLevel userLevel);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserLevel> queryUserLevelPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户积分id查询用户积分
     * @param userLevelId 用户积分id
     * @return 用户积分
     */
    UserLevel queryUserLevelById(Integer userLevelId);
}
