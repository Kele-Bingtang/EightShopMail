package com.eight.service.manage;

import com.eight.bean.Page;
import com.eight.bean.ShoppingMail;
import com.eight.mapper.manage.MShoppingMailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mShoppingMailServiceImpl")
public class MShoppingMailServiceImpl implements IMShoppingMailService {
    @Autowired
    private MShoppingMailMapper mShoppingMailMapper;
    @Override
    public ShoppingMail queryShoppingMailByUsername(ShoppingMail shoppingMail) {
        return mShoppingMailMapper.queryShoppingMailByUsername(shoppingMail);
    }

    @Override
    public List<ShoppingMail> queryShoppingMailList() {
        return mShoppingMailMapper.queryShoppingMailList();
    }

    @Override
    public int addShoppingMail(ShoppingMail shoppingMail) {
        return mShoppingMailMapper.addShoppingMail(shoppingMail);
    }

    @Override
    public int deleteShoppingMail(ShoppingMail shoppingMail) {
        return mShoppingMailMapper.deleteShoppingMail(shoppingMail);
    }

    @Override
    public int modifyShoppingMail(ShoppingMail shoppingMail) {
        return mShoppingMailMapper.modifyShoppingMail(shoppingMail);
    }

    @Override
    public Page<ShoppingMail> queryShoppingMailPage(int currentNum, int singlePageSize, String param) {
        Page<ShoppingMail> shoppingMailPage = new Page<>(currentNum,singlePageSize);
        List<ShoppingMail> shoppingMailItem = mShoppingMailMapper.queryShoppingMailPage(shoppingMailPage, param);
        shoppingMailPage.setItem(shoppingMailItem);
        shoppingMailPage.setTotalPageCount(mShoppingMailMapper.queryShoppingMailCount());
        return shoppingMailPage;
    }

    @Override
    public ShoppingMail queryShoppingMailById(Integer shoppingMailId) {
        return mShoppingMailMapper.queryShoppingMailById(shoppingMailId);
    }
}
