package com.supermarket.controller;


import com.supermarket.common.R;
import com.supermarket.pojo.User;
import com.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R login(String username, String password) {

        System.out.println("测试数据" + username + password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userLogin = userService.login(user);
        if (userLogin != null) {
            return R.ok().message("登录成功");
        } else {
            return R.error().message("登陆失败");
        }
    }
}

