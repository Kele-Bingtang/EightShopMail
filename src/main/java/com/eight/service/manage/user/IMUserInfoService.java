package com.eight.service.manage.user;

import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.bean.UserInfo;

import java.util.List;

public interface IMUserInfoService {

    /**
     * 通过用户信息名查询用户信息
     * @param userInfo 用户信息
     * @return 用户信息
     */
    public UserInfo queryUserInfoByUsername(UserInfo userInfo);

    /**
     * 查询所有用户信息
     * @return 用户信息
     */
    public List<UserInfo> queryUserInfoList();

    /**
     * 添加用户信息
     * @param userInfo 用户信息
     * @return 受影响的行数
     */
    public int addUserInfo(UserInfo userInfo);
    /**
     * 删除用户信息
     * @param userInfo 用户信息
     * @return 受影响的行数
     */
    public int deleteUserInfo(UserInfo userInfo);
    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 受影响的行数
     */
    public int modifyUserInfo(UserInfo userInfo);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserInfo> queryUserInfoPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户信息id查询用户信息
     * @param userInfoId 用户信息id
     * @return 用户信息
     */
    UserInfo queryUserInfoById(Integer userInfoId);

    public List<User> queryUserList();
}
