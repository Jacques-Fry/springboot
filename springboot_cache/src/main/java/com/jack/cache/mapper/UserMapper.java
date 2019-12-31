package com.jack.cache.mapper;

import com.jack.cache.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author PC20
 * @create 2019/8/12
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id= #{id}")
    public User getUser(Integer id);

    @Update("update user set last_name=#{lastName} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int delectUser(Integer id);
}
