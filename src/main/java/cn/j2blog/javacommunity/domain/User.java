package cn.j2blog.javacommunity.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String nickName;
    private String password;
    private String email;
    private String headPortraitUrl;
    private Long createTime;


}
