package com.supermarket.controller;


import com.supermarket.common.R;
import com.supermarket.pojo.User;
import com.supermarket.service.UserService;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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


    @GetMapping("/captcha")
    public void easyGenerateCode(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        //生成普通验证码
        //SpecCaptcha specCaptcha = new SpecCaptcha();
        //生成算数验证码
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha();
        //设置2为算数
        arithmeticCaptcha.setLen(3);
        //验证码结果
        String content = arithmeticCaptcha.text();
        //存放到session中
        session.setAttribute("code", content);
        try {
            com.wf.captcha.utils.CaptchaUtil.out(arithmeticCaptcha, request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

