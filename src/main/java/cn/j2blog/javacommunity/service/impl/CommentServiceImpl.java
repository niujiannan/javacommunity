package cn.j2blog.javacommunity.service.impl;

import cn.j2blog.javacommunity.dao.CommentMapper;
import cn.j2blog.javacommunity.domain.Comment;
import cn.j2blog.javacommunity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insert(Comment comment) {

    }
}
