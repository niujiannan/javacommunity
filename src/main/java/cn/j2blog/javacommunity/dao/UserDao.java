package cn.j2blog.javacommunity.dao;

import cn.j2blog.javacommunity.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into users(nick_name, password, email, head_portrait_url, create_time) values(#{nickName}, #{password}, #{email}, #{headPortraitUrl}, #{createTime})")
    Integer setInsert(User user);

    @Select("select id, nick_name, password, email, head_portrait_url, create_time from users where email = #{email}")
    User getUser(String email);

    @Select("select id, nick_name, password, email, head_portrait_url, create_time from users where id = #{publisherId}")
    User getIdUser(Integer publisherId);
}
