package com.ming.spring;

public class UserInfo {
    private String username;

    public UserInfo() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String sayHello() {
        return "hello " + this.username;
    }
}
