package com.eight.service.manage.order.impl;

import com.eight.bean.OrderCart;
import com.eight.bean.Page;
import com.eight.mapper.manage.order.MOrderCartMapper;
import com.eight.service.manage.order.IMOrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mOrderCartServiceImpl")
public class MOrderCartServiceImpl implements IMOrderCartService {
    @Autowired
    private MOrderCartMapper mOrderCartMapper;
    @Override
    public OrderCart queryOrderCartByUsername(OrderCart orderCart) {
        return mOrderCartMapper.queryOrderCartByUsername(orderCart);
    }

    @Override
    public List<OrderCart> queryOrderCartList() {
        return mOrderCartMapper.queryOrderCartList();
    }

    @Override
    public int addOrderCart(OrderCart orderCart) {
        return mOrderCartMapper.addOrderCart(orderCart);
    }

    @Override
    public int deleteOrderCart(OrderCart orderCart) {
        return mOrderCartMapper.deleteOrderCart(orderCart);
    }

    @Override
    public int modifyOrderCart(OrderCart orderCart) {
        return mOrderCartMapper.modifyOrderCart(orderCart);
    }

    @Override
    public Page<OrderCart> queryOrderCartPage(int currentNum, int singlePageSize, String param) {
        Page<OrderCart> orderCartPage = new Page<>(currentNum,singlePageSize);
        List<OrderCart> orderCartItem = mOrderCartMapper.queryOrderCartPage(orderCartPage, param);
        orderCartPage.setItem(orderCartItem);
        orderCartPage.setTotalPageCount(mOrderCartMapper.queryOrderCartCount());
        return orderCartPage;
    }

    @Override
    public OrderCart queryOrderCartById(Integer orderCartId) {
        return mOrderCartMapper.queryOrderCartById(orderCartId);
    }
}
