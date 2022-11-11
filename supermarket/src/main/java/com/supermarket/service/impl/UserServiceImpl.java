package com.supermarket.service.impl;


import com.supermarket.mapper.UserMapper;
import com.supermarket.pojo.User;
import com.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        System.out.println("数据测试2" + user.getUsername() + user.getPassword());
        return userMapper.login(user);
    }
}
