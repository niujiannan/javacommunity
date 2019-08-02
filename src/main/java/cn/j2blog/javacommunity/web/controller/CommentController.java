package cn.j2blog.javacommunity.web.controller;

import cn.j2blog.javacommunity.dao.UserDao;
import cn.j2blog.javacommunity.domain.Comment;
import cn.j2blog.javacommunity.dto.CommentDto;
import cn.j2blog.javacommunity.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    private CommentDto commentDto= new CommentDto();
    @ResponseBody
    @PostMapping("/comment")
    public CommentDto comment(@RequestBody Comment comment){
        commentService.insertSelective(comment);
        Map<String, Object> map = new HashMap<>();
        BeanUtils.copyProperties(comment, commentDto);
        commentDto.setUser(commentService.getUser(commentDto.getCommentId()));
        map.put("mssagge", "评论成功");
        return commentDto;
    }
}
