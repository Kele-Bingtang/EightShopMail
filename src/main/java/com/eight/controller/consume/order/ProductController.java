package com.eight.controller.consume.order;

import com.eight.service.consume.order.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("productController")
@RequestMapping("/orderDetail")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("productDetail")
    public String productDetail(String productId,Model model){
        model.addAttribute("orderDetail",productService.viewProductById(productId));
        return "/comsume/order/productDetail";
    }

}

