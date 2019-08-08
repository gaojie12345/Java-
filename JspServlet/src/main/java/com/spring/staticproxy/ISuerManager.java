package com.spring.staticproxy;


public interface ISuerManager {
    //主营业务
    public void addUserInfo(String username, String password);

    public void delUserInfo(int id);

    public void modifyUserInfo(String username, String password);

    public String queryUserInfo(int id);
}
