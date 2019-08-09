package com.ming.spring;

public class UserInfo {
    private String username;
    private int password;
    private String address;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public UserInfo() {
    }

    public UserInfo(String username, int password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String sayHello() {
        return "hello " + this.username + this.password + this.car.getBrand() + this.car.getName();
    }
}
