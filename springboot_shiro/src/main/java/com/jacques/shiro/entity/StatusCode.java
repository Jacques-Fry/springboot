package com.jacques.shiro.entity;

/**
 * 状态
 */
public class StatusCode {

  public static final int OK = 200;//成功
  public static final int ERROR = 500;// 失败

  public static final int PARAMERROR = 4000;// 参数错误

  public static final int TOKENERROR = 6000;// token过期或无效/未登录
  public static final int USERERROR = 6001;// 用户名或密码错误
  public static final int FREEZE = 6002;// 账号被冻结
  public static final int SYSERROR = 6003;// 没有权限


}
