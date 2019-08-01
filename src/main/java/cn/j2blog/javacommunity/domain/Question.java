package cn.j2blog.javacommunity.domain;


import lombok.Data;

@Data
public class Question {

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

}
