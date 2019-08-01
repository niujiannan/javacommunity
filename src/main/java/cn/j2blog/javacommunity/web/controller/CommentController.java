package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.dao.CommentMapper;
import cn.j2blog.javacommunity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {




    @Autowired
    private CommentService commentService;


    @PostMapping("/comment")
    public String comment(){
        return null;
    }
}
