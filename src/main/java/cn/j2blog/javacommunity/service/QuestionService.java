package cn.j2blog.javacommunity.service;

import cn.j2blog.javacommunity.domain.Question;
import cn.j2blog.javacommunity.dto.PageDto;
import cn.j2blog.javacommunity.dto.QuestionAndUserDto;

import java.util.List;

public interface QuestionService {

    void setQuestion(Question question);

    List<QuestionAndUserDto> qeustionAll(PageDto pageDto);

    QuestionAndUserDto getByIdQuestion(Integer questionId);

    void update(Integer questionId, Question question);
}
