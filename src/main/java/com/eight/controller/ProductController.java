package com.eight.controller;

import com.eight.bean.ProductInfo;
import com.eight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> queryAllProductInfo() {
        return productService.queryAllProductInfo();
    }

    public List<ProductInfo> queryProductInfosByName(String productName) {
        return null;
    }

    public ProductInfo queryProductInfoByName(String productName) {
        return null;
    }

    @RequestMapping(value = "/catrgory/*", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> queryProductInfosByCategory(String catrgoryId) {
        return productService.queryProductInfoByCategory(catrgoryId);
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> queryProductInfoBySeckill() {
        return productService.queryProductInfoBySeckill();
    }

    @RequestMapping(value = "/box")
    @ResponseBody
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code) {
        return productService.queryProductInfoByBox(boxName, code);
    }


    @GetMapping("viewProduct")
    public String viewProduct(HttpServletRequest request, HttpSession session) {
        //把数据准备好，放入request作用域
//        System.out.println(productService.getProductById()
        request.setAttribute("productInfos", productService.viewProduct());
        return "product";
    }
    @GetMapping("getProductById")
    public String getProductById(String productId, Model model) {

        model.addAttribute("productIdInfos", productService.getProductById(productId).getProductId());
//        商品信息
        model.addAttribute("productCoreInfos", productService.getProductById(productId).getProductCore());
        model.addAttribute("productNameInfos", productService.getProductById(productId).getProductName());
        model.addAttribute("productPrices", productService.getProductById(productId).getPrice());
//        图片
        model.addAttribute("productPicInfos",productService.getPicById(productId).getPicUrl());
        return "returnAndExchange";
    }
}

