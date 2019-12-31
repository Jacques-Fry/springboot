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
public interface PermissionDao {

  @Select("select p.name from permission p" +
      " left join role_permission rp on(rp.pid = p.id) " +
      " where rp.rid = #{roleId}")
  HashSet<String> findByRoleId(@Param("roleId") Integer roleId);
}
