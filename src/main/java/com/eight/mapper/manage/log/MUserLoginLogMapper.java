package com.eight.mapper.manage.log;

import com.eight.bean.UserLoginLog;
import com.eight.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserLoginLogMapper")
public interface MUserLoginLogMapper {

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
     * @param userLoginLogPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserLoginLog> queryUserLoginLogPage(@Param("userLoginLogPage") Page<UserLoginLog> userLoginLogPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userLoginLogId 用户地址id
     * @return 用户地址
     */
    UserLoginLog queryUserLoginLogById(Integer userLoginLogId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserLoginLogCount();
}
