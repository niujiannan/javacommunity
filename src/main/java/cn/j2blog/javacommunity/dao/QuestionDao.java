package cn.j2blog.javacommunity.dao;

import cn.j2blog.javacommunity.domain.Question;
import cn.j2blog.javacommunity.dto.PageDto;
import cn.j2blog.javacommunity.dto.QuestionAndUserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionDao {


    @Insert("insert into question(title, content, publisher, publish_time, update_time, labels)" +
            "values(#{title}, #{content}, #{publisher}, #{publishTime}, #{updateTime}, #{labels})")
    void insertQuestion(Question question);



    @Select("select * from question order by publish_time desc limit #{startRow}, #{countRow}")
    List<QuestionAndUserDto> questionAll(PageDto pageDto);

    @Select("select * from question where id = #{questionId}")
    QuestionAndUserDto getByIdQuestion(Integer questionId);


    @Update("update question set browse_number = #{number} where id = #{questionId}")
    void update(@Param("questionId") Integer questinId, @Param("number") Integer number);

    @Update("update question set title = #{title}, content = #{content}, labels = #{labels} where id = #{id}")
    void setIdUpdate(Question question);

    @Select("select count(1) from question")
    Integer count();

    @Update("update question set comment_number = #{number} where id = #{questionId}")
    void updateComment(@Param("questionId") Integer questinId, @Param("number") Integer number);

    @Select("select comment_number from question where id = #{questionId}")
    Integer selectCommentNumber(Integer questionId);
}
