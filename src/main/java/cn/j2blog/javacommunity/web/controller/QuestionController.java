package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.dto.QuestionAndUserDto;
import cn.j2blog.javacommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{questionId}")
    public String question(@PathVariable("questionId") Integer questionId, HttpServletRequest request, Model model) {
        String requestPath = request.getServletPath();
        QuestionAndUserDto questionAndUserDto = questionService.getByIdQuestion(questionId);
        model.addAttribute("questionAndUserDto", questionAndUserDto);
        model.addAttribute("requestPath", requestPath);
        return "question";
    }

}
