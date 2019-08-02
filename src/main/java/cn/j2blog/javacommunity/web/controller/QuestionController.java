package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.dto.CommentDto;
import cn.j2blog.javacommunity.dto.QuestionAndUserDto;
import cn.j2blog.javacommunity.service.CommentService;
import cn.j2blog.javacommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{questionId}")
    public String question(@PathVariable("questionId") Integer questionId, HttpServletRequest request, Model model) {
        String requestPath = request.getServletPath();
        QuestionAndUserDto questionAndUserDto = questionService.getByIdQuestion(questionId);
        List<CommentDto> commentDtoList = commentService.getByIdComment(questionId);
        model.addAttribute("questionAndUserDto", questionAndUserDto);
        model.addAttribute("requestPath", requestPath);
        model.addAttribute("commentDtoList", commentDtoList);
        return "question";
    }

}
