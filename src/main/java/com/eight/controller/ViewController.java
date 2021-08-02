package com.eight.controller;

import com.eight.bean.BookDetail;
import com.eight.bean.ProductCategory;
import com.eight.service.BookDetailService;
import com.eight.service.CategoryService;
import com.eight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller("viewController")
@RequestMapping("/view")
public class ViewController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BookDetailService bookDetailService;

    @RequestMapping("/commodities")
    private String toCommodities(Model model, @RequestParam(value = "pageName", required = false, defaultValue = "") String pageName) {
        model.addAttribute("pageName", pageName);
        return "commodities.html";
    }

    @RequestMapping(value = "/undefined", method = RequestMethod.GET)
    @ResponseBody
    public String N() {
        return null;
    }

    @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductCategory> categoryInit(String categoryId) {
        List<ProductCategory> categoryList = categoryService.queryCategoryNameBycategoryId(categoryId);
        return categoryList;
    }

    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    @ResponseBody
    private List<BookDetail> detailListInit(String pageName) {
        boolean flag = true;
        List<BookDetail> tmplist = new ArrayList<>();
        List<BookDetail> detailList = new ArrayList<>();
        detailList = bookDetailService.queryAllBookDetail();
        tmplist.add(detailList.get(0));
        for (int i = 1, k = 0; i < detailList.size() && k < 6; i++) {
            flag = true;
            for (int j = 0; j < tmplist.size(); j++) {
                if ((tmplist.get(j).getBAuthor().equals(detailList.get(i).getBAuthor())) || (tmplist.get(j).getBPublisher().equals(detailList.get(i).getBPublisher()))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                tmplist.add(detailList.get(i));
                k++;
            }
        }
        return tmplist;
    }
}
