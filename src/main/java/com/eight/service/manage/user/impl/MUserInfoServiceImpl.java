package com.eight.service.manage.user.impl;

import com.eight.bean.Page;
import com.eight.bean.User;
import com.eight.bean.UserInfo;
import com.eight.mapper.manage.user.MUserInfoMapper;
import com.eight.service.manage.user.IMUserInfoService;
import com.eight.service.manage.user.IMUserService;
import com.eight.utils.EnMsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mUserInfoServiceImpl")
public class MUserInfoServiceImpl implements IMUserInfoService {
    @Autowired
    private MUserInfoMapper mUserInfoMapper;
    @Autowired
    private IMUserService imUserService;
    @Override
    public UserInfo queryUserInfoByUsername(UserInfo userInfo) {
        return mUserInfoMapper.queryUserInfoByUsername(userInfo);
    }

    @Override
    public List<UserInfo> queryUserInfoList() {
        return mUserInfoMapper.queryUserInfoList();
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        User user = imUserService.queryUserIdByUsername(userInfo.getUsername());
        //存入用户id
        userInfo.setUserId(user.getUserId());
        return mUserInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(UserInfo userInfo) {
        return mUserInfoMapper.deleteUserInfo(userInfo);
    }

    @Override
    public int modifyUserInfo(UserInfo userInfo) {
        return mUserInfoMapper.modifyUserInfo(userInfo);
    }

    @Override
    public Page<UserInfo> queryUserInfoPage(int currentNum, int singlePageSize, String param) {
        Page<UserInfo> userInfoPage = new Page<>(currentNum,singlePageSize);
        List<UserInfo> userInfoItem = mUserInfoMapper.queryUserInfoPage(userInfoPage, param);
        //1 身份证，2 军官证，3 护照
        for (UserInfo userInfo : userInfoItem) {
            if(userInfo.getIdentityCardType() == 1){
                userInfo.setIdentityCardTypeStr(EnMsgType.IDENTITYCARDTYPE1);
            }else if(userInfo.getIdentityCardType() == 2){
                userInfo.setIdentityCardTypeStr(EnMsgType.IDENTITYCARDTYPE2);
            }else if(userInfo.getIdentityCardType() == 3){
                userInfo.setIdentityCardTypeStr(EnMsgType.IDENTITYCARDTYPE3);
            }
          /*  //日期减少八小时
            userInfo.setRegisterTime(DateUtil.timestamp8HBefor(userInfo.getRegisterTime()));
            userInfo.setModifiedTime(DateUtil.timestamp8HBefor(userInfo.getModifiedTime()));*/
        }
        userInfoPage.setItem(userInfoItem);
        userInfoPage.setTotalPageCount(mUserInfoMapper.queryUserInfoCount());
        return userInfoPage;
    }

    @Override
    public UserInfo queryUserInfoById(Integer userInfoId) {
        return mUserInfoMapper.queryUserInfoById(userInfoId);
    }

    public List<User> queryUserList(){
        return imUserService.queryUserList();
    }

    @Override
    public UserInfo queryUserInfoByUserId(Long userId) {
        return mUserInfoMapper.queryUserInfoByUserId(userId);
    }
}
