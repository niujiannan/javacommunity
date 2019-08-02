package cn.j2blog.javacommunity.dto;

import cn.j2blog.javacommunity.domain.User;
import lombok.Data;

@Data
public class CommentDto {

    private Integer id;
    private Integer parent_id;
    private Integer type;
    private Integer commentId;
    private Long createTime;
    private Long updateTime;
    private Integer likeNumber;
    private String content;
    private Integer questionId;
    private User user;


}
