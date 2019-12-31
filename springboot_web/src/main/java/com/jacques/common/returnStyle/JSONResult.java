package com.jacques.common.returnStyle;

import java.io.Serializable;

/**
 * @author PC20
 * @create 2019/8/5
 */
public class JSONResult implements Serializable {
  private static final long serialVersionUID = -4800793124936904868L;

  /**
   * 返回是否成功的状态码,200表示成功,
   */
  private Integer code;
  /**
   * 返回是否成功的状态,true表示成功,
   */
  private boolean flag;
  /**
   * 成功时候,返回的JSON数据
   */
  private Object data;
  /**
   * 是错误时候的错误消息
   */
  private String msg;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public boolean getFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public JSONResult() {
  }

  public JSONResult(boolean flag, Integer code, String msg) {
    this.flag = flag;
    this.code = code;
    this.msg = msg;
  }

  /**
   * 全自定义
   *
   * @param flag
   * @param code
   * @param msg
   * @param data
   */

  public JSONResult(boolean flag, Integer code, String msg, Object data) {
    this.flag = flag;
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
}
