package cn.j2blog.javacommunity.service.impl;

import cn.j2blog.javacommunity.dao.UserDao;
import cn.j2blog.javacommunity.domain.User;
import cn.j2blog.javacommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Integer setInsert(User user) {
        // MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCreateTime(System.currentTimeMillis());
        return userDao.setInsert(user);
    }

    @Override
    public User getUser(User user) {

        User getUser = userDao.getUser(user.getEmail());
        if(getUser != null) {
            String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if(getUser.getPassword().equals(password)) {
                return getUser;
            }
        }
        return null;
    }
}
