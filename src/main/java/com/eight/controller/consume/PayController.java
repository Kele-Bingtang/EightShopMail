package com.eight.controller.consume;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.eight.alipay.Alipay;
import com.eight.alipay.AlipayBean;
import com.eight.alipay.AlipayProperties;
import com.eight.bean.OrderMaster;
import com.eight.bean.ProductInfo;
import com.eight.service.consume.IBuyCartService;
import com.eight.utils.CookieUtils;
import com.eight.utils.DateUtil;
import com.eight.utils.EnMsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
@RequestMapping("/eight")
public class PayController {
    @Autowired
    Alipay alipay;

    @Autowired
    private IBuyCartService buyCartService;
    @Autowired
    private AlipayProperties alipayProperties;

    @GetMapping("/viewProduct")
    public String viewProduct(Long productId, Model model) {
        ProductInfo productInfo = buyCartService.viewProduct(productId);
        model.addAttribute("productInfo", productInfo);
        return "comsume/buycart";
    }

    /**
     * 跳转支付宝网页
     */
    @PostMapping(value = "/alipay")
    @ResponseBody
//    String outTradeNo, String subject, String totalAmount, String body
    public String alipay(AlipayBean alipayBean, OrderMaster orderMaster,ProductInfo productInfo, HttpSession session,HttpServletRequest request) throws AlipayApiException {
        //判断是否登录
        if(orderMaster.getUserId() == null){
            return EnMsgType.LOGINNEED;
        }
        orderMaster.setProductInfo(productInfo);
        session.setAttribute("orderMaster", orderMaster);
        return alipay.pay(alipayBean);
    }

    @RequestMapping("/sucessPay")
    public ModelAndView sucessPay(HttpServletRequest request, ModelAndView modelAndView) throws UnsupportedEncodingException, AlipayApiException {
        //获取支付成后的信息，包括订单号，支付时间等
        HashMap<String, String> orderHashMap = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        //遍历参数，解析参数的key和value，存入HashMap中
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            orderHashMap.put(name, valueStr);
        }
        //调用支付宝SDK，进行验签
        boolean signVerified = AlipaySignature.rsaCheckV1(orderHashMap, alipayProperties.getPublicKey(), alipayProperties.getCharset(), alipayProperties.getSign_type());
        //判断是否支付成功
        if (signVerified) {
            // 订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 交易金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            modelAndView.addObject("out_trade_no", out_trade_no);
            modelAndView.addObject("trade_no", trade_no);
            modelAndView.addObject("total_amount", total_amount);

            OrderMaster orderMaster = (OrderMaster) request.getSession().getAttribute("orderMaster");
            orderMaster.setOrderSn(out_trade_no);
            orderMaster.setPaymentMoney(new BigDecimal(total_amount));
            orderMaster.setPaymentMethod(2); //支付方式为支付宝
            orderMaster.setCreateTime(DateUtil.dataConvertTimeStamp(orderHashMap.get("timestamp")));
            orderMaster.setPayTime(DateUtil.dataConvertTimeStamp(orderHashMap.get("timestamp")));
            buyCartService.addOrder(orderMaster);


        } else {
            //TODO 验签失败业务处理
        }
        //设置返回视图
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
