package com.qing.mapper;

import com.qing.po.User;

import java.util.List;

public interface UserMapper {

    public List<User> queryUserList() throws Exception;
}
