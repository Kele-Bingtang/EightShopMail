package com.eight.service;

import com.alipay.api.AlipayApiException;
import com.eight.bean.AlipayBean;

/**
 * 支付服务
 */
public interface IPayService {

    /**
     * 支付宝支付接口
     *
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
