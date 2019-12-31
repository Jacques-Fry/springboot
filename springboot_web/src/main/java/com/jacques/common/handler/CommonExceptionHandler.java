package com.jacques.common.handler;

import com.jacques.common.exception.CommonException;
import com.jacques.common.returnStyle.JSONResult;
import com.jacques.common.utils.StatusUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jack_YD
 * @create 2019/8/27 16:07
 */
@CrossOrigin(origins = "*")
@ControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(value = {CommonException.class})
  @ResponseBody
  public JSONResult commonException(CommonException e) {
    return new JSONResult(false, e.getCode(),e.getMsg());
  }


  @ExceptionHandler(value = {Exception.class})
  @ResponseBody
  public JSONResult exception(Exception e) {
    e.printStackTrace();
    return new JSONResult(false, StatusUtil.ERROR,"程序错误");
  }

}
