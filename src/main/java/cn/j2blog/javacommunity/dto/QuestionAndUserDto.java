package cn.j2blog.javacommunity.dto;

import cn.j2blog.javacommunity.domain.User;
import lombok.Data;

@Data
public class QuestionAndUserDto {

    private Integer id;
    private String title;
    private String content;
    private Integer browseNumber;
    private Integer commentNumber;
    private Integer likeNumber;
    private Integer publisher;
    private Long publishTime;
    private Long updateTime;
    private String labels;
    private User user;


}
