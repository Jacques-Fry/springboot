package com.jacques.shiro.entity;

import java.io.Serializable;

public class Result implements Serializable{

	
	private boolean flag;
	private Integer code;
	private String msg;
	private Object data;
	
	
	
	public Result(boolean flag, Integer code, String msg, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public Result(boolean flag, Integer code, String msg) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
