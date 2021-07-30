package com.eight.controller;

import com.eight.service.Impl.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account-index")
    public String index() {
        return "account-index";
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestParam("payer") String payer,
                           @RequestParam("payee") String payee,
                           @RequestParam("money") Double money,
                           Model model) {

        System.out.println(payer + "--" + payee + "--" + money);

        try {
            accountService.transfer(payer, payee, money);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        model.addAttribute("msg", "转账成功！");
        return "transferHint";
    }
    @GetMapping("returnSuccess")
    public void viewDeleteOrder() {
        //把数据准备好，放入request作用域


    }

}
