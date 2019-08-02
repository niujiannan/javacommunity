package cn.j2blog.javacommunity.service.impl;

import cn.j2blog.javacommunity.dao.CommentMapper;
import cn.j2blog.javacommunity.dao.QuestionDao;
import cn.j2blog.javacommunity.dao.UserDao;
import cn.j2blog.javacommunity.domain.Comment;
import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.dto.CommentDto;
import cn.j2blog.javacommunity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Override
    public void insertSelective(Comment comment) {
        comment.setCreateTime(System.currentTimeMillis());
        comment.setUpdateTime(comment.getCreateTime());
        updateComment(comment.getQuestionId());
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<CommentDto> getByIdComment(Integer questionId){
        List<CommentDto> commentDtoList = commentMapper.getByIdComment(questionId);
        for(CommentDto commentDto : commentDtoList) {
            commentDto.setUser(userDao.getIdUser(commentDto.getCommentId()));
        }
        return commentDtoList;
    }

    @Override
    public void updateComment(Integer questionId) {
        Integer i = selectCommentNumber(questionId);
        i++;
        questionDao.updateComment(questionId, i);
    }

    @Override
    public Integer selectCommentNumber(Integer questionId) {
        return questionDao.selectCommentNumber(questionId);
    }

    public User getUser(Integer id){
        return userDao.getIdUser(id);
    }
}
