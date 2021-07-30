package com.eight.service.manage.order.impl;

import com.eight.bean.OrderDetail;
import com.eight.bean.Page;
import com.eight.mapper.manage.order.MOrderDetailMapper;
import com.eight.service.manage.order.IMOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mOrderDetailServiceImpl")
public class MOrderDetailServiceImpl implements IMOrderDetailService {
    @Autowired
    private MOrderDetailMapper mOrderDetailMapper;
    @Override
    public OrderDetail queryOrderDetailByUsername(OrderDetail orderDetail) {
        return mOrderDetailMapper.queryOrderDetailByUsername(orderDetail);
    }

    @Override
    public List<OrderDetail> queryOrderDetailList() {
        return mOrderDetailMapper.queryOrderDetailList();
    }

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return mOrderDetailMapper.addOrderDetail(orderDetail);
    }

    @Override
    public int deleteOrderDetail(OrderDetail orderDetail) {
        return mOrderDetailMapper.deleteOrderDetail(orderDetail);
    }

    @Override
    public int modifyOrderDetail(OrderDetail orderDetail) {
        return mOrderDetailMapper.modifyOrderDetail(orderDetail);
    }

    @Override
    public Page<OrderDetail> queryOrderDetailPage(int currentNum, int singlePageSize, String param) {
        Page<OrderDetail> orderDetailPage = new Page<>(currentNum,singlePageSize);
        List<OrderDetail> orderDetailItem = mOrderDetailMapper.queryOrderDetailPage(orderDetailPage, param);
        orderDetailPage.setItem(orderDetailItem);
        orderDetailPage.setTotalPageCount(mOrderDetailMapper.queryOrderDetailCount());
        return orderDetailPage;
    }

    @Override
    public OrderDetail queryOrderDetailById(Integer orderDetailId) {
        return mOrderDetailMapper.queryOrderDetailById(orderDetailId);
    }
}
