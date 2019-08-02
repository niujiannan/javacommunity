package cn.j2blog.javacommunity.service;

import cn.j2blog.javacommunity.domain.Comment;
import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.dto.CommentDto;

import java.util.List;

public interface CommentService {

    void insertSelective(Comment comment);
    List<CommentDto> getByIdComment(Integer questionId);
    void updateComment(Integer questionId);
    Integer selectCommentNumber(Integer questionId);
    User getUser(Integer id);
}
