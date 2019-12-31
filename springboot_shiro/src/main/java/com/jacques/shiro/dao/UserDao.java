package com.jacques.shiro.dao;

import com.jacques.shiro.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:27
 */
@Mapper
@Component
public interface UserDao {

  @Select("SELECT " +
      "  `id`," +
      "  `password`," +
      "  `status` " +
      "FROM" +
      "  `user`  " +
      "WHERE `username` = #{username}")
  User findByUsername(@Param("username") String username);

  @Select("SELECT " +
      "  `status`, " +
      "  `role_id` " +
      "FROM" +
      "  `user`  " +
      "WHERE `id` = #{id}")
  User findById(@Param("id") String id);

  @Select("SELECT " +
      "  `id`, " +
      "  `username`, " +
      "  `password`, " +
      "  `tel`, " +
      "  `create_time`, " +
      "  `status`, " +
      "  `role_id` " +
      "FROM" +
      "  `user`  ")
  List<User> findAll();

  @Select("SELECT " +
      "  count(`id`) " +
      "FROM" +
      "  `user`  " +
      "WHERE `id` = #{id}")
  Integer countById(@Param("id") String id);

  @Select("SELECT " +
      "  count(`id`) " +
      "FROM" +
      "  `user`  " +
      "WHERE `tel` = #{tel}")
  Integer countByTel(@Param("tel") String tel);

  @Select("SELECT " +
      "  count(`id`) " +
      "FROM" +
      "  `user`  " +
      "WHERE `username` = #{username}")
  Integer countByUsername(@Param("username") String username);


  @Insert("INSERT INTO `common`.`user` ( " +
      "  `id`, " +
      "  `username`, " +
      "  `password`, " +
      "  `tel`, " +
      "  `create_time`, " +
      "  `status`, " +
      "  `role_id` " +
      ")  " +
      "VALUES " +
      "  ( " +
      "    #{user.id}, " +
      "    #{user.username}, " +
      "    #{user.password}, " +
      "    #{user.tel}, " +
      "    #{user.createTime}, " +
      "    #{user.status}, " +
      "    #{user.roleId} " +
      "  ) ; ")
  void saveUser(@Param("user") User user);


}
