package cn.j2blog.javacommunity.service.impl;

import cn.j2blog.javacommunity.dao.QuestionDao;
import cn.j2blog.javacommunity.dao.UserDao;
import cn.j2blog.javacommunity.domain.Question;
import cn.j2blog.javacommunity.dto.PageDto;
import cn.j2blog.javacommunity.dto.QuestionAndUserDto;
import cn.j2blog.javacommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class QuestonServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private UserDao userDao;

    private PageDto pageDto = new PageDto();
    @Override
    public void setQuestion(Question question) {
        question.setPublishTime(System.currentTimeMillis());
        question.setUpdateTime(question.getPublishTime());
        questionDao.insertQuestion(question);
    }

    @Override
    public List<QuestionAndUserDto> qeustionAll(Integer currentPage, Integer countRow) {
        pageDto.startRow(currentPage, countRow, questionDao.count());
        List<QuestionAndUserDto> questionAndUserDtos = questionDao.questionAll(pageDto);
        for(QuestionAndUserDto questionAndUserDto : questionAndUserDtos) {
            questionAndUserDto.setUser(userDao.getIdUser(questionAndUserDto.getPublisher()));
        }
        return questionAndUserDtos;
    }

    @Override
    public QuestionAndUserDto getByIdQuestion(Integer questionId) {
        QuestionAndUserDto questionAndUserDto = questionDao.getByIdQuestion(questionId);
        int i = questionAndUserDto.getBrowseNumber() + 1;
        questionDao.update(questionId, i);
        questionAndUserDto.setBrowseNumber(i);
        questionAndUserDto.setUser(userDao.getIdUser(questionAndUserDto.getPublisher()));
        return questionAndUserDto;
    }

    @Override
    public void update(Integer questionId, Question question) {
        question.setUpdateTime(System.currentTimeMillis());
        question.setId(questionId);
        questionDao.setIdUpdate(question);
    }

    @Override
    public PageDto getPageDto() {
        return this.pageDto;
    }

}
