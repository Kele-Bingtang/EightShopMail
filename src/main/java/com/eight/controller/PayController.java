package com.eight.controller;

import com.alipay.api.AlipayApiException;
import com.eight.bean.Alipay;
import com.eight.bean.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PayController {
    @Autowired
    Alipay alipay;
    @PostMapping(value = "alipay")
    @ResponseBody
//    String outTradeNo, String subject, String totalAmount, String body
    public String alipay(AlipayBean alipayBean) throws AlipayApiException {
//        String pay = alipay.pay(alipayBean);
//
//        pay.replace("&quot;","'");
//        System.out.println("alipay：" + pay);
        return alipay.pay(alipayBean);
    }
}
