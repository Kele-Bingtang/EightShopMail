package com.eight.service.manage.user;

import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.bean.UserAddr;

import java.util.List;

public interface IMUserAddrService {

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
    public int addUserAddr(String username,UserAddr userAddr);
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
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<UserAddr> queryUserAddrPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param userAddrId 用户地址id
     * @return 用户地址
     */
    UserAddr queryUserAddrById(Integer userAddrId);

    public List<User> queryUserList();
}
