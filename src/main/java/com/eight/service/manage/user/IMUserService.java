package com.eight.service.manage.user;

import com.eight.bean.Page;
import com.eight.bean.User;

import java.util.List;

public interface IMUserService {
    /**
     * 通过用户名查询用户
     * @param user 用户
     * @return 用户
     */
    public User queryUserByUsername(User user);

    /**
     * 查询所有用户
     * @return 用户
     */
    public List<User> queryUserList();

    /**
     * 添加用户
     * @param user 用户
     * @return 受影响的行数
     */
    public int addUser(User user);
    /**
     * 删除用户
     * @param user 用户
     * @return 受影响的行数
     */
    public int deleteUser(User user);
    /**
     * 修改用户密码
     * @param user 用户
     * @return 受影响的行数
     */
    public int modifyPassword(User user);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<User> queryUserPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据id查询用户
     * @param userId 用户id
     * @return 用户
     */
    User queryUserById(Integer userId);

    public User queryUserIdByUsername(String username);
}
