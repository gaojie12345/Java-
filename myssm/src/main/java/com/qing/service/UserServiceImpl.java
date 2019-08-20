package com.qing.service;

import com.qing.mapper.UserMapper;
import com.qing.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryUserListService() throws Exception {
        return userMapper.queryUserList();
    }
}
