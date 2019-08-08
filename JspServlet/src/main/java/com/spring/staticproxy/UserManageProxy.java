package com.spring.staticproxy;

/**
 * 1.代理对象必须和目标对象实现相同的接口
 */
public class UserManageProxy implements ISuerManager {

    @Override
    public void addUserInfo(String username, String password) {
        securityCheck();
        System.out.println("------UserManager.addUserInfo()----");
    }

    @Override
    public void delUserInfo(int id) {
        securityCheck();
        System.out.println("------UserManager.delUserInfo()----");

    }

    @Override
    public void modifyUserInfo(String username, String password) {
        securityCheck();
        System.out.println("------UserManager.modifyUserInfo()----");

    }

    @Override
    public String queryUserInfo(int id) {
        securityCheck();
        System.out.println("------UserManager.queryUserInfo()----");
        return null;
    }

    public void securityCheck(){
        System.out.println("----------securityCheck------");
    }
}
