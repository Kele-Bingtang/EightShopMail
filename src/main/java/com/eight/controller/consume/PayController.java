package com.eight.controller.consume;

import com.alipay.api.AlipayApiException;
import com.eight.alipay.Alipay;
import com.eight.alipay.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/eight/product")
public class PayController {
    @Autowired
    Alipay alipay;
    @PostMapping(value = "/alipay")
    @ResponseBody
//    String outTradeNo, String subject, String totalAmount, String body
    public String alipay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
