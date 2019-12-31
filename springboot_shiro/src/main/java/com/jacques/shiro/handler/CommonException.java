package com.jacques.shiro.handler;

/**
 * @author Jack_YD
 * @create 2019/12/10 13:50
 */
public class CommonException extends RuntimeException {
  private Integer code;
  private String msg;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public CommonException(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
