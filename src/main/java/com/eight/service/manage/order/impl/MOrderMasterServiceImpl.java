package com.eight.service.manage.order.impl;

import com.eight.bean.OrderMaster;
import com.eight.bean.Page;
import com.eight.mapper.manage.order.MOrderMasterMapper;
import com.eight.service.manage.order.IMOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mOrderMasterServiceImpl")
public class MOrderMasterServiceImpl implements IMOrderMasterService {
    @Autowired
    private MOrderMasterMapper mOrderMasterMapper;
    @Override
    public OrderMaster queryOrderMasterByUsername(OrderMaster orderMaster) {
        return mOrderMasterMapper.queryOrderMasterByUsername(orderMaster);
    }

    @Override
    public List<OrderMaster> queryOrderMasterList() {
        return mOrderMasterMapper.queryOrderMasterList();
    }

    @Override
    public int addOrderMaster(OrderMaster orderMaster) {
        return mOrderMasterMapper.addOrderMaster(orderMaster);
    }

    @Override
    public int deleteOrderMaster(OrderMaster orderMaster) {
        return mOrderMasterMapper.deleteOrderMaster(orderMaster);
    }

    @Override
    public int modifyOrderMaster(OrderMaster orderMaster) {
        return mOrderMasterMapper.modifyOrderMaster(orderMaster);
    }

    @Override
    public Page<OrderMaster> queryOrderMasterPage(int currentNum, int singlePageSize, String param) {
        Page<OrderMaster> orderMasterPage = new Page<>(currentNum,singlePageSize);
        List<OrderMaster> orderMasterItem = mOrderMasterMapper.queryOrderMasterPage(orderMasterPage, param);
        orderMasterPage.setItem(orderMasterItem);
        orderMasterPage.setTotalPageCount(mOrderMasterMapper.queryOrderMasterCount());
        return orderMasterPage;
    }

    @Override
    public OrderMaster queryOrderMasterById(Integer orderMasterId) {
        return mOrderMasterMapper.queryOrderMasterById(orderMasterId);
    }
}
