package com.eight.bean;

import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public User getUser() {
        return userThreadLocal.get();
    }

    public void setUser(User user){
        userThreadLocal.set(user);
    }

    public void clear(){
        userThreadLocal.remove();
    }
}
