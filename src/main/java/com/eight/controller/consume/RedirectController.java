package com.eight.controller.consume;

import com.eight.bean.ProductInfo;
import com.eight.service.consume.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("redirectController")
@RequestMapping("/eight/redirectPage")

public class RedirectController {
    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @ResponseBody
    private List<ProductInfo> Init(String pageName, String oneCategoryId,String pageSize, String curPage, String conLen, String condition) {
        return Process(pageName, oneCategoryId,pageSize, curPage, conLen, condition, false);
    }

    @RequestMapping(value = "/limit", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> Limit(String pageName, String oneCategoryId,String pageSize, String curPage, String conLen, String condition) {
        return Process(pageName,oneCategoryId, pageSize, curPage, conLen, condition, true);
    }

    @RequestMapping(value = "/updateCom", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> UpdateCom(String pageName,String oneCategoryId,String pageSize,String condition,String conLen){
        return Process(pageName,oneCategoryId,pageSize,"1",conLen,condition,true);
    }

    public List<ProductInfo> Process(String pageName,String oneCategoryId, String pageSize, String curPage, String conLen, String condition, boolean flag) {
        StringBuffer detail_name;
        int conlen = Integer.parseInt(conLen);
        StringBuffer classPath = new StringBuffer("com.eight.bean.");
        Map<String, String> conList = new HashMap<String, String>();
        String[] conditions = condition.split("&");
        int m = (Integer.parseInt(curPage) - 1) * Integer.parseInt(pageSize);
        if (conlen != 0) {
            for (String s : conditions) {
                if(s.equals("")){
                    continue;
                }
                s=s.substring(s.indexOf('=')+1,s.length());
                String tmpKey = s.substring(0, s.lastIndexOf('_'));
                String tmpValue = s.substring(s.lastIndexOf('_') + 1, s.length());
                if (!conList.containsKey(tmpKey)) {
                    conList.put(tmpKey, "'" + tmpValue + "'");
                } else {
                    conList.put(tmpKey, conList.get(tmpKey) + " OR de." + tmpKey + "='" + tmpValue + "'");
                }
            }
        }

        if (pageName.equals("phone")) {
            classPath.append("PhoneDetail");
            detail_name = new StringBuffer("phone_detail");
        } else if (pageName.equals("book")) {
            classPath.append("BookDetail");
            detail_name = new StringBuffer("book_detail");
        } else {
            classPath.append("HourseAppDetail");
            detail_name = new StringBuffer("hourse_app_detail");
        }

        if (conlen == 0) {
            classPath = new StringBuffer("");
        }
        if (flag) {
            List<ProductInfo> list = viewService.queryProductInfoWithlimitWithCondition(curPage, conList, pageSize, classPath.toString(), detail_name.toString(), oneCategoryId);
            return list;
        } else {
            List<ProductInfo> tmplist = viewService.queryProductInfoWithlimit(m, pageSize, "product_id", oneCategoryId);
            return tmplist;
        }

    }
}
