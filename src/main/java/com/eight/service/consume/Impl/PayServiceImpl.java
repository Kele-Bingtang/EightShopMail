package com.eight.service.consume.Impl;

import com.alipay.api.AlipayApiException;
import com.eight.alipay.Alipay;
import com.eight.alipay.AlipayBean;
import com.eight.service.consume.IPayService;
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
