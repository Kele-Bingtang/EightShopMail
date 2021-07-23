package com.eight.controller;

import com.eight.bean.ProductInfo;
import com.eight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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


}
