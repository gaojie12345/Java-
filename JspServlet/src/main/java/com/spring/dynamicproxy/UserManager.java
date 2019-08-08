package com.spring.dynamicproxy;

public class UserManager implements ISuerManager {
    @Override
    public void addUserInfo(String username, String password) {
        System.out.println("------UserManager.addUserInfo()----");
    }

    @Override
    public void delUserInfo(int id) {

    }

    @Override
    public void modifyUserInfo(String username, String password) {
        System.out.println("------UserManager.modifyUserInfo()----");

    }

    @Override
    public String queryUserInfo(int id) {
        System.out.println("------UserManager.queryUserInfo()----");
        return null;
    }
}
