package com.jacques.shiro.service;

import com.jacques.shiro.dao.UserDao;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.handler.CommonException;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:49
 */
@Transactional
@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Value("${custom.md5Salt}")
  private String md5Salt;

  public User findByUsername(String username) {
    return userDao.findByUsername(username);
  }

  public User findById(String id) {
    return userDao.findById(id);
  }

  public Result login(String username, String password) {
    try {
      //构造登陆令牌
      UsernamePasswordToken upToken = new UsernamePasswordToken(username, new Md5Hash(password, md5Salt, 3).toString());
      //获取subject
      Subject subject = SecurityUtils.getSubject();

      String sid = (String) subject.getSession().getId();
      //调用登陆
      subject.login(upToken);

      return new Result(true, StatusCode.OK, "登陆成功: ", sid);
    } catch (Exception e) {
      return new Result(true, StatusCode.OK, "用户名或密码错误");
    }
  }

  public void saveUserList(List<User> user) {
    long count = 2;
    //由于抛出自定义异常事务失效，所以先执行验证
    for (User u : user) {
      if (StringUtils.isBlank(u.getId()))
        throw new CommonException(StatusCode.OK, "有数据的ID值为空，导入失败，在第" + count + "行");
      if (userDao.countById(u.getId()) > 0)
        throw new CommonException(StatusCode.OK, "有ID被使用，导入失败，ID值为:" + u.getId()+"，在第" + count + "行");
      if (StringUtils.isBlank(u.getUsername()))
        throw new CommonException(StatusCode.OK, "有数据的用户名为空，导入失败，在第" + count + "行");
      if (userDao.countByUsername(u.getUsername()) > 0)
        throw new CommonException(StatusCode.OK, "有用户名被使用，导入失败，用户名为:" + u.getUsername()+"，在第" + count + "行");
      if (StringUtils.isBlank(u.getTel()))
        throw new CommonException(StatusCode.OK, "有数据的手机号码为空，导入失败，在第" + count + "行");
      if (userDao.countByTel(u.getTel()) > 0)
        throw new CommonException(StatusCode.OK, "有手机号码被使用，导入失败，手机号为:" + u.getTel()+"，在第" + count + "行");
      count++;
    }

    for (User u : user) {
      u.setPassword(new Md5Hash("123456", md5Salt, 3).toString());
      u.setStatus("0");
      u.setCreateTime(new Date());
      userDao.saveUser(u);
    }

  }

  public List<User> findAll() {
    return userDao.findAll();
  }
}
