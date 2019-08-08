package com.spring.staticproxy;

public class ProxyTest {
    public static void main(String[] args) {
        ISuerManager iSuerManager = new UserManageProxy();
        iSuerManager.addUserInfo("abc","123");
        iSuerManager.delUserInfo(1);
    }
}
