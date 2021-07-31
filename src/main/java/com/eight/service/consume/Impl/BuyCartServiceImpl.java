package com.eight.service.consume.Impl;

import com.eight.bean.OrderDetail;
import com.eight.bean.OrderMaster;
import com.eight.bean.ProductInfo;
import com.eight.bean.UserInfo;
import com.eight.mapper.consume.BuyCartMapper;
import com.eight.mapper.consume.UserMapper;
import com.eight.mapper.manage.user.MUserInfoMapper;
import com.eight.service.consume.IBuyCartService;
import com.eight.service.manage.user.IMUserInfoService;
import com.eight.service.manage.user.impl.MUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BuyCartServiceImpl implements IBuyCartService {
    @Autowired
    private BuyCartMapper buyCartMapper;
    @Autowired
    private IMUserInfoService imUserInfoService;

    @Override
    public ProductInfo viewProduct(Long productId) {
        return buyCartMapper.viewProduct(productId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)  //异常自动回滚
    public void addOrder(OrderMaster orderMaster) {
        ProductInfo productInfo = orderMaster.getProductInfo();
        //判断支付时金额是否有优惠，有就加回来，获得实际总价
        BigDecimal realMoney = orderMaster.getPaymentMoney();
        if(orderMaster.getDistrictMoney() != null){
            realMoney = realMoney.add(orderMaster.getDistrictMoney());
            if(orderMaster.getShippingMoney() != null){
                realMoney = realMoney.add(orderMaster.getShippingMoney());
            }
        }
        //订单主表类存数据，然后插入数据库
        orderMaster.setOrderMoney(realMoney);
        orderMaster.setPaymentMoney(orderMaster.getPaymentMoney());
        orderMaster.setShoppingMailName("八八商城");
        UserInfo userInfo = imUserInfoService.queryUserInfoByUserId(orderMaster.getUserId());
        orderMaster.setShippingUser(userInfo.getUsername());
        int i = buyCartMapper.addOrderMaster(orderMaster);
        //订单明细表存数据，插入数据库，包括从上面获取的订单主表主键和订单号

        OrderDetail orderDetail = new OrderDetail();
        Long orderId = orderMaster.getOrderId();
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId(productInfo.getProductId());
        orderDetail.setProductName(productInfo.getProductName());
        orderDetail.setProductPrice(productInfo.getPrice());
        orderDetail.setProductAmount(realMoney.intValue() / productInfo.getPrice().intValue());
        orderDetail.setFreeMoney(orderMaster.getDistrictMoney());
        buyCartMapper.addOrderDetail(orderDetail);
        if(i == 1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
}
