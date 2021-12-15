package com.eight.controller.consume;

import com.eight.bean.ProductComment;
import com.eight.bean.ProductInfo;
import com.eight.service.consume.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("indexController")
@RequestMapping("/eight/index")
public class IndexController {
    @Autowired
    private IIndexService indexService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public List<ProductInfo> queryAllProductInfo() {
        return indexService.queryAllProductInfo();
    }

    @RequestMapping(value = "/catrgory/*", method = RequestMethod.GET)
    public List<ProductInfo> queryProductInfosByCategory(String catrgoryId) {
        return indexService.queryProductInfoByCategory(catrgoryId);
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.GET)
    public List<ProductInfo> queryProductInfoBySeckill() {
        return indexService.queryProductInfoBySeckill();
    }

    @RequestMapping(value = "/box")
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code) {
        return indexService.queryProductInfoByBox(boxName, code);
    }

    @RequestMapping("/commentArticle")
    public List<ProductComment> queryCommentArticleByNum(Integer artcleFine){
        return indexService.queryCommentArticleByNum(artcleFine);
    }


}
