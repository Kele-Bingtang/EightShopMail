package com.eight.mapper.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserInfoMapper")
public interface MUserInfoMapper {

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
     * @param userInfoPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserInfo> queryUserInfoPage(@Param("userInfoPage") Page<UserInfo> userInfoPage, @Param("param") String param);

    /**
     * 根据用户信息id查询用户信息
     * @param userInfoId 用户信息id
     * @return 用户信息
     */
    UserInfo queryUserInfoById(Integer userInfoId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserInfoCount();


}
