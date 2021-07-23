package com.eight;

import com.eight.bean.User;
import com.eight.service.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EightsmApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Test
    void contextLoads() {
    }
    @Test
    public void queryUsernameAndPassword(){
        User user = userService.queryUserByUsername("kele");
        System.out.println("running ..." + user);
    }

}
