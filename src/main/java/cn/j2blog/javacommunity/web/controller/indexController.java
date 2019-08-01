package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.dto.PageDto;
import cn.j2blog.javacommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "countRow", defaultValue = "5") Integer countRow, Model model) {
        model.addAttribute("questionList", questionService.qeustionAll(currentPage, countRow));
        model.addAttribute("pageDto", questionService.getPageDto());
        return "index";
    }

}
