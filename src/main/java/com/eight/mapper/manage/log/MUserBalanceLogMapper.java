package com.eight.mapper.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserBalanceLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserBalanceLogMapper")
public interface MUserBalanceLogMapper {

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
     * @param userBalanceLogPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserBalanceLog> queryUserBalanceLogPage(@Param("userBalanceLogPage") Page<UserBalanceLog> userBalanceLogPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userBalanceLogId 用户地址id
     * @return 用户地址
     */
    UserBalanceLog queryUserBalanceLogById(Integer userBalanceLogId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserBalanceLogCount();
}
