package com.jacques.shiro.service;

import com.jacques.shiro.dao.RoleDao;
import com.jacques.shiro.pojo.Role;
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
public class RoleService {

  @Autowired
  private RoleDao roleDao;

  public HashSet<String> findById(Integer id){
    System.out.println("==============执行了角色查询");
    return roleDao.findById(id);
  }
}
