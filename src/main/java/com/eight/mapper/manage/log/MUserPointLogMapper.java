package com.eight.mapper.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserPointLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserPointLogMapper")
public interface MUserPointLogMapper {

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
     * @param userPointLogPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserPointLog> queryUserPointLogPage(@Param("userPointLogPage") Page<UserPointLog> userPointLogPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userPointLogId 用户地址id
     * @return 用户地址
     */
    UserPointLog queryUserPointLogById(Integer userPointLogId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserPointLogCount();
}
