package com.jacques.shiro.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:27
 */
@Mapper
@Component
public interface RoleDao {

  @Select("SELECT " +
      "  r.`name`" +
      "FROM" +
      "  `role` r " +
      "WHERE r.id=#{id}")
  HashSet<String> findById(@Param("id") Integer id);
}
