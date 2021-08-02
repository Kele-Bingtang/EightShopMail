package com.eight.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限控制Shiro配置类
 */
@Configuration
public class ShiroFilterConfiguration {

    /**
     * 创建过滤工厂Bean
     * Shiro内置过滤器，实现权限相关的拦截器
     * anon:无需登录，可以访问
     * authc:必须登录才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String,String> filter = new LinkedHashMap<>();
        filter.put("/eight/manage/login", "anon");
        filter.put("/static/**", "anon");
        filter.put("/eight/manage/logging", "anon");
        filter.put("/eight/manage/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
        shiroFilterFactoryBean.setLoginUrl("/eight/manage/login");
        shiroFilterFactoryBean.setSuccessUrl("/eight/manage/index");
        return shiroFilterFactoryBean;
    }

    /**
     * 权限管理
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建Realm ，认证用
     * 引用UserRealm类
     * @return Realm
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    /**
     * thymeleaf整合Shiro
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
