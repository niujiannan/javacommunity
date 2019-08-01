package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.domain.Question;
import cn.j2blog.javacommunity.dto.QuestionAndUserDto;
import cn.j2blog.javacommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }


    @PostMapping("/publish")
    public String publist(Question queston, Model model, Integer questionId, HttpServletRequest request) {
        if(questionId != null) {
            questionService.update(questionId, queston);
            request.getSession().setAttribute("msg", "修改成功");
            return "redirect:/question/" + questionId;
        }
        questionService.setQuestion(queston);
        model.addAttribute("msg", "发布成功");
        return "publish";
    }

    @GetMapping("/updata/{questionId}")
    public String updata(@PathVariable("questionId") Integer questionId, Model model){
        QuestionAndUserDto questionAndUserDto = questionService.getByIdQuestion(questionId);
        model.addAttribute("questionAndUserDto", questionAndUserDto);
        return "publish";
    }


}
