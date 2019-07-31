package cn.j2blog.javacommunity.service.impl;

import cn.j2blog.javacommunity.dao.UserDao;
import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void setInsert(User user) {
        userDao.setInsert(user);
    }
}
