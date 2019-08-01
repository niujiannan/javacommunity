package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.dto.Result;
import cn.j2blog.javacommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, HttpServletRequest request) {
        userService.setInsert(user);
        Result result = Result.success("注册成功");
        request.getSession().setAttribute("result", result);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(User user,String requestPath, HttpServletRequest request, Model model) {
        if(requestPath == null) {
            requestPath = "/";
        }
        User getUser = userService.getUser(user);
        if(getUser != null) {
            request.getSession().setAttribute("user", getUser);
            return "redirect:" + requestPath;
        }
        model.addAttribute("message", "用户名或密码错误");
        return "/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";

    }
}
