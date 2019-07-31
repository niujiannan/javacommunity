package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        User user = new User();
        user.setNickName("小黑");
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        user.setCreateTime(System.currentTimeMillis());
        userService.setInsert(user);
        return "register";
    }

}
