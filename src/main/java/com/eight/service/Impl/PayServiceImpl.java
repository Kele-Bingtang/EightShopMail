package com.eight.service.Impl;

import com.alipay.api.AlipayApiException;
import com.eight.bean.Alipay;
import com.eight.bean.AlipayBean;
import com.eight.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
