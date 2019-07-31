package cn.j2blog.javacommunity.dao;

import cn.j2blog.javacommunity.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    @Insert("insert into users(nick_name, password, email, head_portrait_url, create_time) values(#{nickName}, #{password}, #{email}, #{headPortraitUrl}, #{createTime})")
    void setInsert(User user);

}
