package cn.bugstack.mapper;

import cn.bugstack.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select username, password, role from user where username = #{username}")
    UserInfo findUserByUsername(String username);

    @Insert("INSERT INTO user (username, password, role) VALUES (#{username}, #{password}, #{role})")
    void insertUser(UserInfo userInfo);
}
