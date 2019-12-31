package com.jacques.shiro.service;

import com.jacques.shiro.dao.PermissionDao;
import com.jacques.shiro.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:50
 */
@Service
@Transactional
public class PermissionService {

  @Autowired
  private PermissionDao permissionDao;

  public HashSet<String> findByRoleId(Integer roleId){
    System.out.println("==============执行了权限查询\n");
    return permissionDao.findByRoleId(roleId);
  }
}
