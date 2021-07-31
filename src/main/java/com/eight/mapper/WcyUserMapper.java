package com.eight.mapper;

import com.eight.bean.UpdateInfo;
import com.eight.bean.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface WcyUserMapper {

    UserInfo info(String userId);

    UpdateInfo updateInfo(UpdateInfo updateInfo);/*更新页面获取信息*/

    void update(UpdateInfo updateInfo);/*修改信息*/

    UserInfo returnPage(String userInfoId);/*返回个人资料页面*/

}
