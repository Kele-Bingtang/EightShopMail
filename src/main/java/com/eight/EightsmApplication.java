package com.eight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.eight.mapper")
@SpringBootApplication
public class EightsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EightsmApplication.class, args);
    }

}
