package com.eight.controller.consume;

import com.eight.bean.ProductComment;
import com.eight.bean.ProductInfo;
import com.eight.service.consume.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("indexController")
@RequestMapping("/eight/index")
public class IndexController {
    @Autowired
    private IIndexService indexService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> queryAllProductInfo() {
        return indexService.queryAllProductInfo();
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
        return indexService.queryProductInfoByCategory(catrgoryId);
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> queryProductInfoBySeckill() {
        return indexService.queryProductInfoBySeckill();
    }

    @RequestMapping(value = "/box")
    @ResponseBody
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code) {
        return indexService.queryProductInfoByBox(boxName, code);
    }

    @RequestMapping("/commentArticle")
    @ResponseBody
    public List<ProductComment> queryCommentArticleByNum(Integer artcleFine){
        return indexService.queryCommentArticleByNum(artcleFine);
    }


}
