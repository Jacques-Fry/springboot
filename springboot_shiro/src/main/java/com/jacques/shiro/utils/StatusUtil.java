package com.jacques.shiro.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 花落泪知雨
 * @create 2019/8/26
 */
public class StatusUtil {
  public static final int OK = 200;//成功
  public static final int ERROR = 500;//程序未知错误

  public static final int LOGIN_ERROR = 3001;//登陆失败
  public static final int ACCESS_ERROR = 3002;//权限不足
  public static final int REPETITIVE_OPERATION = 3003;//重复操作

  public static final int PARAM_ERROR = 4001;//参数错误
  public static final int FILE_UPLOAD_ERROR = 4021;//文件上传失败

  public static final int REMOTE_ERROR = 5021;//远程调用失败

}
