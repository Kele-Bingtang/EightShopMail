package com.eight.service.consume;

import com.alipay.api.AlipayApiException;
import com.eight.alipay.AlipayBean;

/**
 * 支付服务
 */
public interface IPayService {

    /**
     * 支付宝支付接口
     *
     * @param alipayBean 阿里bean类
     * @return 支付
     * @throws AlipayApiException 异常
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
