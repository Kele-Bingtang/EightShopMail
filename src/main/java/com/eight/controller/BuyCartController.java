package com.eight.controller;

import com.eight.bean.ProductInfo;
import com.eight.service.IBuyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/pay")
public class BuyCartController {
    @Autowired
    private IBuyCartService buyCartService;


    @GetMapping("buyCart")
    public String BuyCart(Long productId, Model model) {
        ProductInfo productInfo = buyCartService.viewBuyCart(productId);

        System.out.println(productInfo);

        model.addAttribute("picUrl",productInfo.getProductPicInfo().getPicUrl());
        model.addAttribute("picDesc",productInfo.getProductPicInfo().getPicDesc());
        model.addAttribute("productName",productInfo.getProductName());
        model.addAttribute("Desc",productInfo.getDescript());
        model.addAttribute("Price",productInfo.getPrice());
        model.addAttribute("Pw",productInfo.getProductWarehouse().getCurrentCnt());
        model.addAttribute("Ps",productInfo.getProductWarehouse().getProductSales());
        return "buycart";
    }
}
