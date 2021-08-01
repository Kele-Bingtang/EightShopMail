package com.eight.service.consume.order.impl;

import com.eight.mapper.consume.order.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public void transfer(String payer, String payee, Double money) throws Exception {


        accountMapper.outMoney(payer, money);

//        int i = 1 / 0;

        accountMapper.inMoney(payee, money);


    }


}
