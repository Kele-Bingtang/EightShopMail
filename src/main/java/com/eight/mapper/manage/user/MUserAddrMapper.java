package com.eight.mapper.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserAddr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mUserAddrMapper")
public interface MUserAddrMapper {

    /**
     * 通过用户地址名查询用户地址
     * @param userAddr 用户地址
     * @return 用户地址
     */
    public UserAddr queryUserAddrByUsername(UserAddr userAddr);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<UserAddr> queryUserAddrList();

    /**
     * 添加用户地址
     * @param userAddr 用户地址
     * @return 受影响的行数
     */
    public int addUserAddr(@Param("userAddr") UserAddr userAddr,@Param("userId") Long userId);
    /**
     * 删除用户地址
     * @param userAddr 用户地址
     * @return 受影响的行数
     */
    public int deleteUserAddr(UserAddr userAddr);
    /**
     * 修改用户地址
     * @param userAddr 用户地址
     * @return 受影响的行数
     */
    public int modifyUserAddr(UserAddr userAddr);

    /**
     * 分页查询
     * @param userAddrPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<UserAddr> queryUserAddrPage(@Param("userAddrPage") Page<UserAddr> userAddrPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userAddrId 用户地址id
     * @return 用户地址
     */
    UserAddr queryUserAddrById(Integer userAddrId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryUserAddrCount();
}
