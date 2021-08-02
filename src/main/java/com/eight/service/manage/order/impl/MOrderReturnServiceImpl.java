package com.eight.service.manage.order.impl;

import com.eight.bean.OrderDetail;
import com.eight.bean.OrderReturn;
import com.eight.bean.Page;
import com.eight.mapper.manage.order.MOrderReturnMapper;
import com.eight.service.manage.order.IMOrderDetailService;
import com.eight.service.manage.order.IMOrderReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mOrderReturnServiceImpl")
public class MOrderReturnServiceImpl implements IMOrderReturnService {
    @Autowired
    private MOrderReturnMapper mOrderReturnMapper;
    @Autowired
    private IMOrderDetailService mOrderDetailService;
    @Override
    public OrderReturn queryOrderReturnByUsername(OrderReturn orderReturn) {
        return mOrderReturnMapper.queryOrderReturnByUsername(orderReturn);
    }

    @Override
    public List<OrderReturn> queryOrderReturnList() {
        return mOrderReturnMapper.queryOrderReturnList();
    }

    @Override
    public int addOrderReturn(OrderReturn orderReturn) {
        return mOrderReturnMapper.addOrderReturn(orderReturn);
    }

    @Override
    public int deleteOrderReturn(OrderReturn orderReturn) {
        return mOrderReturnMapper.deleteOrderReturn(orderReturn);
    }

    @Override
    public int modifyOrderReturn(OrderReturn orderReturn,Long orderDetailId) {
        OrderDetail orderDetail = new OrderDetail();
        System.out.println(orderDetailId);
        orderDetail.setOrderDetailId(orderDetailId);
        if(orderReturn.getReturnState().equals("1")){
            mOrderDetailService.deleteOrderDetail(orderDetail);
        }
        return mOrderReturnMapper.modifyOrderReturn(orderReturn);
    }

    @Override
    public Page<OrderReturn> queryOrderReturnPage(int currentNum, int singlePageSize, String param) {
        Page<OrderReturn> orderReturnPage = new Page<>(currentNum,singlePageSize);
        List<OrderReturn> orderReturnItem = mOrderReturnMapper.queryOrderReturnPage(orderReturnPage, param);
        orderReturnPage.setItem(orderReturnItem);
        orderReturnPage.setTotalPageCount(mOrderReturnMapper.queryOrderReturnCount());
        return orderReturnPage;
    }

    @Override
    public OrderReturn queryOrderReturnById(Integer orderReturnId) {
        return mOrderReturnMapper.queryOrderReturnById(orderReturnId);
    }
}
