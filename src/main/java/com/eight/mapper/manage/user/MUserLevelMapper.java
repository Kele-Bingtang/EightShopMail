package com.eight.mapper.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserLevelMapper")
public interface MUserLevelMapper {

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
     * @param userLevelPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserLevel> queryUserLevelPage(@Param("userLevelPage") Page<UserLevel> userLevelPage, @Param("param") String param);

    /**
     * 根据用户积分id查询用户积分
     * @param userLevelId 用户积分id
     * @return 用户积分
     */
    UserLevel queryUserLevelById(Integer userLevelId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserLevelCount();
}
