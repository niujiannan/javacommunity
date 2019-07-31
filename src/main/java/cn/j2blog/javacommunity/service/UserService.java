package cn.j2blog.javacommunity.service;

import cn.j2blog.javacommunity.domain.User;

public interface UserService {

    Integer setInsert(User user);

    User getUser(User user);
}
